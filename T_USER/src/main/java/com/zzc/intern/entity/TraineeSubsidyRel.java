package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@TableName("trainee_subsidy_rel")
public class TraineeSubsidyRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&补贴id
     */
    @TableId(value = "ts_id", type = IdType.AUTO)
    private Integer tsId;

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

    /**
     * 发放时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;


}
