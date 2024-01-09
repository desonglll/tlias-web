package com.mike.tliasweb.service;

import com.mike.tliasweb.entity.Dept;

import java.util.List;

/**
 * @author: mikeshinoda
 * @date: 2024/1/5
 * @description:
 */
//部门业务规则
public interface DeptService {
    /**
     * 查询所有的部门数据
     *
     * @return 存储Dept对象的集合
     */
    List<Dept> list();

    List<Dept> getAll();

    int deleteById(int id);

    int add(Dept dept);

    Dept getById(int id);

    int update(Dept dept);
}
