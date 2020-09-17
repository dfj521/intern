package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("department_job_rel")
public class DepartmentJobRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门&岗位id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 岗位id
     */
    private Integer jId;

    /**
     * 部门id
     */
    private Integer dId;


}
