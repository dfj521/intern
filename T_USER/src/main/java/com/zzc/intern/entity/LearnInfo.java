package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("learn_info")
public class LearnInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学习内容ID
     */
    @TableId(value = "l_id", type = IdType.AUTO)
    private Integer lId;

    /**
     * 学习内容
     */
    private String lElementary;

    /**
     * 学习阶段 1.2.3
     */
    private Integer lStage;


}
