package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
	 * 学习id
	 */
	private Integer lId;

	/**
	 * 实习生ID
	 */
	private Integer tId;

	/**
	 * 考核状态（0：不存在，1：存在）
	 */
	private String aStatus;
	/**
	 * 考核是否通过（1.通过，0.不通过）
	 */
	private String aState;

}
