package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_resource_rel")
public class TraineeResourceRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&资源id
     */
    @TableId(value = "tr_id", type = IdType.AUTO)
    private Integer trId;

    /**
     * 实习生id
     */
    private Integer tId;

    /**
     * 资源id
     */
    private Integer rId;

    /**
     * 实习生&资源状态（0：不存在，1：存在）
     */
    private String trStatus;


}
