package com.example.demo.user.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class SimpleSearchCriteria {

    private String key;
    private String operation;
    private Object value;

}
