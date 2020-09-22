package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("house_info")
public class HouseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 住宿id
     */
    @TableId(value = "h_id", type = IdType.AUTO)
    private Integer hId;

    /**
     * 住宿地址
     */
    private String hAddress;

    /**
     * 宿舍人数
     */
    private Integer hNumber;

    /**
     * 宿舍描述
     */
    private String hDescribe;

    /**
     * 宿舍图片
     */
    private String hUrl;

    /**
     * 宿舍管理员
     */
    private String hAdministrators;

    /**
     * 宿舍状态（0：不存在，1：存在）
     */
    private String hStatus;


}
