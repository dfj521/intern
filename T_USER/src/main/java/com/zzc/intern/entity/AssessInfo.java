package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("assess_info")
public class AssessInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考核ID
     */
    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;

    /**
     * 考核成绩
     */
    private Double aGrade;

    /**
     * 学习内容编号
     */
    private Integer lId;

    /**
     * 实习生编号
     */
    private Integer tId;


}
