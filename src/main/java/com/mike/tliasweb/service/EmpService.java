package com.mike.tliasweb.service;

import com.mike.tliasweb.entity.Emp;
import com.mike.tliasweb.entity.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: mikeshinoda
 * @date: 2024/1/5
 * @description:
 */
//员工业务规则
public interface EmpService {
    /**
     * 条件分页查询
     *
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     姓名
     * @param gender   性别
     * @param begin    开始时间
     * @param end      结束时间
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);
}