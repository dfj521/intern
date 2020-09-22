package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_subsidy_rel")
public class TraineeSubsidyRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&补贴id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 实习生id
     */
    private Integer tId;

    /**
     * 补贴id
     */
    private Integer sId;

    /**
     * 实习生&补贴状态（0：不存在，1：存在）
     */
    private String tsStatus;


}
