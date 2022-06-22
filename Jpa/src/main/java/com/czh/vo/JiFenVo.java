package com.czh.vo;

import lombok.Data;

@Data
public class JiFenVo {

    private Long id;
    private String name;
    private String sub;
    private JiFenVo nextJiFen;
}
