package com.mike.tliasweb.entity;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author: mikeshinoda
 * @date: 2024/1/5
 * @description:
 */
/*部门类*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;
    @Getter
    @Setter
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
