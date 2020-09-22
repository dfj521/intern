package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("job_learn_rel")
public class JobLearnRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "jl_id", type = IdType.AUTO)
    private Integer jlId;

    /**
     * 岗位编号
     */
    private Integer jId;

    /**
     * 学习内容编号
     */
    private Integer lId;

    /**
     * 岗位&学习内容状态（0：不存在，1：存在）
     */
    private String jlStatus;


}
