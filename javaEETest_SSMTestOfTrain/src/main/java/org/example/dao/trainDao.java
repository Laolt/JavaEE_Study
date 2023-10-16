package org.example.dao;


import org.apache.ibatis.annotations.Select;
import org.example.domain.train;

import java.util.List;
public interface trainDao {
    @Select("select * from train limit #{pageNumber},4")
    List<train> selectByPageNumber(int pageNumber);
    List<train> selectByAimAddress(String aimAddress);
}
