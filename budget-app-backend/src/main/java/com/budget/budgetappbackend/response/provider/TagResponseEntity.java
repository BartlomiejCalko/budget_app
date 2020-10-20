package com.budget.budgetappbackend.response.provider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TagResponseEntity extends ResponseEntity<TagsList> {

    public TagResponseEntity(TagsList body, HttpStatus httpStatus) {
        super(body, httpStatus);
    }
}
