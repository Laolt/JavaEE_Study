package com.example.service;


import com.example.domain.train;

import java.util.List;

public interface trainService {
    List<train> selectAll(int page);

}
