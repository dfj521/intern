package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_job_rel")
public class TraineeJobRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&岗位id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 实习生编号
     */
    private Integer tId;

    /**
     * 岗位编号
     */
    private Integer jId;

    /**
     * 实习生&岗位状态（0：不存在，1：存在）
     */
    private String tjStatus;


}
