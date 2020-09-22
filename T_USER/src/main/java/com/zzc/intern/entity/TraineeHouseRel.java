package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_house_rel")
public class TraineeHouseRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&宿舍id
     */
    @TableId(value = "th_id", type = IdType.AUTO)
    private Integer thId;

    /**
     * 实习生id
     */
    private Integer tId;

    /**
     * 宿舍id
     */
    private Integer hId;

    /**
     * 实习生&宿舍状态（0：不存在，1：存在）
     */
    private String thStatus;


}
