package com.zzc.intern.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zzc.intern.entity.SubsidyInfo;

import lombok.Data;

@Data
public class JobSubsidyDTO {

    /**
     * 岗位名称
     */
    private String jName;
    /**
     * 实习生补贴id
     */
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
     * 发放总次数
     */
    private Integer sLssueNum;

    /**
     * 岗位ID
     */
    private Integer jId;
}
