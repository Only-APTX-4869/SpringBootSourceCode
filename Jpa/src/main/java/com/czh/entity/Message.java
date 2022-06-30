package com.czh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "message")
@Entity //注解声明这是映射数据库的实体类
/**
 * Lombok @Data注解 省略getset方法 和构造器
 */
public class Message {
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date credat;
    @Id //注解声明这个属性映射数据库的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 默认使用主键生成的方式自增
    @Column
    private Long id;
    @Column
    private String password;
    @Column
    private String Message;

    public Message(final String password, final String message, final Date credat) {
        this.password = password;
        this.Message = message;
        this.credat = credat;
    }

    public Message() {
    }

    public static Date getCredat() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        simpleDateFormat.format(date);
        return date;
    }

    public void setCredat(Date credat) {
        this.credat = credat;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return this.Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }
}
