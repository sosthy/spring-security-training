package com.example.demo.user.criteria;

import com.example.demo.user.models.AppUser;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSpecificationsBuilder {

    private final List<SearchCriteria> params;

    public UserSpecificationsBuilder() {
        params = new ArrayList<>();
    }

    public final UserSpecificationsBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final UserSpecificationsBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            op = SearchCriteria.getSearchOperation(prefix, suffix, op);
            params.add(new SearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<AppUser> build() {
        if(params.size() == 0)
            return null;

        Specification<AppUser> result = new UserSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new UserSpecification(params.get(i)))
                    : Specification.where(result).and(new UserSpecification(params.get(i)));
        }

        return result;
    }

    public final UserSpecificationsBuilder with(UserSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final UserSpecificationsBuilder with(SearchCriteria criteria) {
        params.add(criteria);
        return this;
    }

}
