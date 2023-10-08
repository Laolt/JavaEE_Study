package org.example.service;

import org.example.domain.test;

public interface testServiceMFA {
    void selectById(int id);
    void selectAll();
    void deleteById(int id);
    void updateById(test t);
    void insert(test t);
}
