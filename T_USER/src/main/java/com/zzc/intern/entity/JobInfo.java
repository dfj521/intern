package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

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
     * 部门编号
     */
    private Integer dId;


}
