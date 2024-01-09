package com.mike.tliasweb.mapper;

import com.mike.tliasweb.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: mikeshinoda
 * @date: 2024/1/5
 * @description:
 */
@Mapper
public interface DeptMapper {
    //查询所有部门数据
    @Select("select * from dept")
    List<Dept> list();

    @Select("select * from dept")
    List<Dept> getAll();

    @Delete("delete from dept where id = #{id}")
    int deleteById(int id);

    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    int add(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getById(int id);

    @Update("update dept set name=#{name}, update_time=#{updateTime} where id = #{id}")
    int update(Dept dept);
}