package com.czh.vo;

import lombok.Data;

@Data
public class JiFenVo {

    private Long id;

    private String name;
    private String sub;
    private JiFenVo nextJiFen;

    @Override
    public String toString() {
        return "JiFenVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sub='" + sub + '\'' +
                ", nextJiFen=" + nextJiFen +
                '}';
    }
}
