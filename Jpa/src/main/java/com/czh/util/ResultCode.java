package com.czh.util;

import lombok.Getter;

@Getter
public enum ResultCode implements StatusCode {
    SUCCESS(200, "请求成功"),
    FAILED(400, "请求失败"),
    VALIDATE_ERROR(1002, "参数校验失败"),
    RESPONSE_PACK_ERROR(1003, "response返回包装失败");

    public int code;
    public String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
