package com.czh.vo;

import com.czh.util.ResultCode;
import com.czh.util.StatusCode;
import lombok.Data;

@Data
public class ResultVo<T> {
    private int code;
    private String msg;
    private Object data;

    public ResultVo(final int code, final String msg, final Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 返回指定状态码，数据对象
    public ResultVo(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    // 只返回状态码
    public ResultVo(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }
}
