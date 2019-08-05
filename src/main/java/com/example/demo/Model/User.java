package com.example.demo.Model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
@Entity // 跟数据库关联
@Table(name = "test")
public class User {

    @Id
    private Integer id;

    @Column
    private String name;




}
