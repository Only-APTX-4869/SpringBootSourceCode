package com.czh.entity;

import lombok.Data;
import javax.persistence.*;
@Entity
@Table(name = "student")
@Data
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
