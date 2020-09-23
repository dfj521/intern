package com.zzc.intern.DTO;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zzc.intern.entity.SubsidyInfo;

import lombok.Data;

@Data
public class TraineeSubsidyDTO {
	/**
     * 实习生&补贴id
     */
    private Integer tsId;

    /**
     * 补贴金额
     */
    private Double sSubsidies;


    /**
     * 发放时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    /**
     * 实习生姓名
     */
    private String tName;
}
