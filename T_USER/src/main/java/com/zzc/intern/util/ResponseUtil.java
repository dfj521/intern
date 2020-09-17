package com.zzc.intern.util;

import lombok.Data;

@Data
public class ResponseUtil<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;
}
