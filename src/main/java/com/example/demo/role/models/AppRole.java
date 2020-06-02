package com.example.demo.role.models;

import com.example.demo.audit.Auditable;
import com.example.demo.security.models.AppAuthority;
import com.example.demo.user.models.AppUser;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "app_role")
@Audited
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = "users")
public class AppRole extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(generator = "role_generator")
    @SequenceGenerator(
            name = "role_generator",
            sequenceName = "role_sequence"
    )
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false, length = 15)
    private String roleName;

    @Column(name = "role_desc")
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<AppUser> users = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "app_role_auth")
    private Set<AppAuthority> authorities;

}
