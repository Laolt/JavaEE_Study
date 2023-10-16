package org.example.service;

import org.example.domain.train;

import java.util.List;

public interface trainService {
    List<train> selectAll(int page);

}
