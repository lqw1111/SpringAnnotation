package com.spring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookRepository{" +
                "label='" + label + '\'' +
                '}';
    }
}
