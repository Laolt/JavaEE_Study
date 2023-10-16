package org.example.service.impl;

import org.example.dao.trainDao;
import org.example.domain.train;
import org.example.service.trainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class trainServiceImpl implements trainService {
    @Autowired
    private trainDao tdao;
    @Override
    public List<train> selectAll(int page) {
        return tdao.selectByPageNumber(page);
    }
}
