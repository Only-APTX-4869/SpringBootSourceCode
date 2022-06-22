package com.czh.vo;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class MessageVo {

    public Date credat;
    private Long id;
    private String password;
    private String Message;

    public MessageVo() {
    }

    public MessageVo(String password, String Message, Date credat) {
        this.password = password;
        this.Message = Message;
        this.credat = credat;
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
}
