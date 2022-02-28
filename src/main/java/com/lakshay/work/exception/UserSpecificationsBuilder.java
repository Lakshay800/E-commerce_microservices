package com.lakshay.work.exception;

import com.lakshay.work.entity.User;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSpecificationsBuilder {

    private final List<SearchCriteria> params;

    public UserSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public void with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
    }

    public Specification<User> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specifications = params.stream()
                .map(UserSpecification::new)
                .collect(Collectors.toList());

        Specification result = specifications.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i)
                    .isOrPredicate()
                    ? Specification.where(result)
                    .or(specifications.get(i))
                    : Specification.where(result)
                    .and(specifications.get(i));
        }
        return result;
    }
}
