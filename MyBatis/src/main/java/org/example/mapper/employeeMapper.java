package org.example.mapper;

import org.example.bean.employee;

import java.util.List;

public interface employeeMapper {
    List<employee> selectById(employee e);
    Boolean addMessage(employee e);
    Boolean setMessage(employee e);
    Boolean deleteMessage(employee e);
}
