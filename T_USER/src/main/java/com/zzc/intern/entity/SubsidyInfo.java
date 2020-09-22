package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("subsidy_info")
public class SubsidyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生补贴id
     */
    @TableId(value = "s_id", type = IdType.AUTO)
    private Integer sId;

    /**
     * 补贴金额
     */
    private Double sSubsidies;

    /**
     * 发放时间
     */
    private Integer sIssuedTime;

    /**
     * 发放次数
     */
    private Integer sLssueNum;

    /**
     * 岗位ID
     */
    private Integer jId;

    /**
     * 实习生补贴状态（0：不存在，1：存在）
     */
    private String sStatus;


}
