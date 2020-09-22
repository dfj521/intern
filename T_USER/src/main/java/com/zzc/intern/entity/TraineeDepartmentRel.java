package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_department_rel")
public class TraineeDepartmentRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&部门id
     */
    @TableId(value = "td_id", type = IdType.AUTO)
    private Integer tdId;

    /**
     * 实习生id
     */
    private Integer tId;

    /**
     * 部门id
     */
    private Integer dId;

    /**
     * 实习生&部门状态（0：不存在，1：存在）
     */
    private String tdStatus;


}
