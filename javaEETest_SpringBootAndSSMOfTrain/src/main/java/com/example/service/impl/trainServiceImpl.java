package com.example.service.impl;


import com.example.dao.trainDao;
import com.example.domain.train;
import com.example.service.trainService;
import org.springframework.beans.factory.annotation.Autowired;
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
