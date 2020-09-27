package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("learn_info")
public class LearnInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学习内容ID
     */
    @TableId(value = "learn_id", type = IdType.AUTO)
    private Integer learnId;

    /**
     * 学习内容
     */
    private String learnElementary;

    /**
     * 学习阶段(1.初级、2.中级、3.高级)
     */
    private Integer learnStage;

    /**
     * 学习内容状态（0：不存在，1：存在）
     */
    private String learnStatus;

    /**
     * 课程id
     */
    private Integer courseId;


}
