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
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 实习生id
     */
    private Integer tId;

    /**
     * 部门id
     */
    private Integer dId;


}
