package org.example.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.bean.test;
import org.example.bean.testjob;

public interface testForAnnotation {
    @Select("select * from test where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "jid",javaType = testjob.class,property = "job",one=@One(
                    select = "org.example.mapper.testForAnnotation.selectJobById"
            ))
    })
    test selectTestWithJobById(int id);
    @Select("select * from test_job where jid=#{jid}")
    testjob selectJobById();
}
