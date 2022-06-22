package com.czh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table
@Entity //注解声明这是映射数据库的实体类
@Data
public class Message {
    @Id //注解声明这个属性映射数据库的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 默认使用主键生成的方式自增
    @Column
    private Long id;

    @Column
    private String password;
    @Column
    private String Message;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date credat;

    public static Date getCredat() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        simpleDateFormat.format(date);
        return date;
    }

    public void setCredat(Date credat) {
        this.credat = credat;
    }

    public Message() {
    }

       public Message(String password, String Message,Date credat) {
        this.password = password;
        this.Message = Message;
        this.credat = credat;
    }
}
