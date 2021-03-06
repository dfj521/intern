package com.zzc.intern.util;



import java.util.List;

import com.zzc.intern.entity.HouseInfo;

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
