package com.mike.tliasweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: mikeshinoda
 * @date: 2024/1/8
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total; //总记录数
    private List rows; //当前页数据列表
}