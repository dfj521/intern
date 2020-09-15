package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

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
     * 入住时间
     */
    private LocalDateTime hInTime;

    /**
     * 离宿时间
     */
    private LocalDateTime hOutTime;

    /**
     * 宿舍人数
     */
    private Integer hNumber;


}
