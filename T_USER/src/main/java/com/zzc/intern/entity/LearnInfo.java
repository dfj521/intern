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
	@TableId(value = "l_id", type = IdType.AUTO)
	private Integer lId;

	/**
	 * 学习内容
	 */
	private String lElementary;

	/**
	 * 学习阶段(1.初级、2.中级、3.高级)
	 */
	private Integer lStage;

	/**
	 *是否可用（1.可用，0.不可用）
	 */
	private String lStatus;

}
