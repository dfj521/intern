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
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 岗位编号
     */
    private Integer jId;

    /**
     * 学习内容编号
     */
    private Integer lId;

    /**
	 *是否可用（1.可用，0.不可用）
	 */
	private String Status;

    /**
     * 学习阶段(1.初级、2.中级、3.高级)
     */
    private Integer lStage;
}
