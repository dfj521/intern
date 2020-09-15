package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

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
     * 岗位编号
     */
    private Integer jId;


}
