package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("department_info")
public class DepartmentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer dId;

    /**
     * 部门名称
     */
    private String dName;

    /**
     * 部门状态（0：不存在，1：存在）
     */
    private String dStatus;


}
