package com.mike.tliasweb.service.impl;

import com.mike.tliasweb.entity.Dept;
import com.mike.tliasweb.mapper.DeptMapper;
import com.mike.tliasweb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: mikeshinoda
 * @date: 2024/1/5
 * @description:
 */
//部门业务实现类
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }

    @Override
    public List<Dept> getAll() {
        List<Dept> deptList = deptMapper.getAll();
        return deptList;
    }

    @Override
    public int deleteById(int id) {
        return deptMapper.deleteById(id);
    }

    @Override
    public int add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        return deptMapper.add(dept);
    }

    @Override
    public Dept getById(int id) {
        return deptMapper.getById(id);
    }

    @Override
    public int update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        return deptMapper.update(dept);
    }
}