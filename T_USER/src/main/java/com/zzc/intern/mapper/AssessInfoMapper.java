package com.zzc.intern.mapper;

import com.zzc.intern.DTO.TraineeAssessLearnParameterDTO;
import com.zzc.intern.DTO.TraineeAssessLearnResultDTO;
import com.zzc.intern.entity.AssessInfo;
import com.zzc.intern.util.ResponseUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * 考核信息 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface AssessInfoMapper extends BaseMapper<AssessInfo>{
	
	/**
	 * 根据考核条件查询考核信息
	 * @param assessInfo 考核条件
	 * @return
	 */
	List<TraineeAssessLearnResultDTO> findByEerm(TraineeAssessLearnParameterDTO assessInfo);
	/**
	 * 根据考核ID查询单个考核
	 * @param id
	 * @return
	 */
	TraineeAssessLearnResultDTO findById(int id);
	/**
	 * 添加考核信息
	 * @param assessInfo
	 * @return 
	 */
	int addAssess(AssessInfo assessInfo);
	/**
	 * 修改考核信息
	 * @param assessInfo 添加信息
	 * @return
	 */
	int updateAssess(AssessInfo assessInfo);
	/**
	 * 删除考核信息
	 * @param id
	 * @return
	 */
	int delAssess(int id);
	
}
