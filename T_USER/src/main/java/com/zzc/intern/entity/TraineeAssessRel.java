package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_assess_rel")
public class TraineeAssessRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&考核id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 实习生id
     */
    private Integer tId;

    /**
     * 考核id
     */
    private Integer aId;

    /**
     * 实习生&考核状态（0：不存在，1：存在）
     */
    private String taStatus;


}
