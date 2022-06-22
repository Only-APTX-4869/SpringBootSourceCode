package com.czh.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "student")
@Data
/**
 * lombok接口 @Data注解 省略getset 和构造器
 */
public class Student {
    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String sex;
    @Column
    private Integer age;

    public Student() {
    }

    public Student(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
