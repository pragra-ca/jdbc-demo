package io.pragra.learning.jdbcfirstapp.entity;

import lombok.Data;

import java.util.Date;
//  JDBC
@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Date joinDate;
    private Date createDate;
    private Date updateDate;
    private String course;
}
