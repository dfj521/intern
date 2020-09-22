package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("job_info")
public class JobInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位编号
     */
    @TableId(value = "j_id", type = IdType.AUTO)
    private Integer jId;

    /**
     * 岗位名称
     */
    private String jName;

    /**
     * 岗位状态（0：不存在，1：存在）
     */
    private String jStatus;


}
