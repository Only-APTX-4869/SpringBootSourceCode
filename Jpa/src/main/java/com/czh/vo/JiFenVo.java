package com.czh.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class JiFenVo {
    @Min(value = 0, message = "用户ID不能为空")
    private Long id;
    @NotNull(message = "用户NAME不能为空")
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
