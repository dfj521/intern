package com.zzc.intern.service;

import com.zzc.intern.DTO.TraineeAssessLearnResultDTO;
import com.zzc.intern.entity.AssessInfo;
import com.zzc.intern.util.ResponseUtil;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 考核信息 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface AssessInfoService extends IService<AssessInfo> {
	/**
	 * 根据考核条件查询考核信息
	 * 
	 * @param assessInfo 条件对象
	 * @return
	 */
	ResponseUtil<List<TraineeAssessLearnResultDTO>> findByEerm(String name, Double minaGrade, Double maxaGrade,
			Integer lstage);

	/**
	 * 根据考核ID查询单个考核
	 * 
	 * @param id
	 * @return
	 */
	ResponseUtil<TraineeAssessLearnResultDTO> findById(int id);

	/**
	 * 添加考核信息
	 * 
	 * @param assessInfo
	 * @return
	 */
	ResponseUtil addAssess(Double grade, Integer lId, Integer lStage, Integer tId);

	/**
	 * 修改考核信息
	 * 
	 * @param assessInfo 添加信息
	 * @return
	 */
	ResponseUtil updateAssess(AssessInfo assessInfo);

	/**
	 * 删除考核信息
	 * 
	 * @param id
	 * @return
	 */
	ResponseUtil delAssess(int id);
}
