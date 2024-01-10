package com.mike.tliasweb.mapper;

import com.github.pagehelper.Page;
import com.mike.tliasweb.entity.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: mikeshinoda
 * @date: 2024/1/5
 * @description:
 */
@Mapper
public interface EmpMapper {
    //    @Select("select count(*) from emp")
//    Long count();
//
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    List<Emp> list(Integer start, Integer pageSize);

    List<Emp> page(String name, Short gender, LocalDate begin, LocalDate end);

    @Delete("delete from emp where id = #{id}")
    void deleteById(Integer id);

    //新增员工
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void insert(Emp emp);

    //根据ID查询员工信息
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp " +
            "where id = #{id}")
    Emp findById(Integer id);

    public void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp login(String username, String password);
}