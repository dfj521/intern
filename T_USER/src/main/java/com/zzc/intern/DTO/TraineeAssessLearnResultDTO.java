package com.zzc.intern.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zzc.intern.entity.AssessInfo;

import lombok.Data;

@Data
public class TraineeAssessLearnResultDTO {
	/**
	 * 考核ID
	 */

	private Integer aId;

	/**
	 * 考核成绩
	 */
	private Double aGrade;
	/**
	 * 学习阶段(1.初级、2.中级、3.高级)
	 */
	private Integer lStage;
	/**
	 * 实习生id
	 */
	private Integer tId;
	/**
	 * 实习生姓名
	 */
	private String tName;
	
}
