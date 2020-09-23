package com.zzc.intern.mapper;

import com.zzc.intern.DTO.TraineeAssessLearnParameterDTO;
import com.zzc.intern.DTO.TraineeAssessLearnResultDTO;
import com.zzc.intern.entity.AssessInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;
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
public interface AssessInfoMapper extends BaseMapper<AssessInfo> {
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
	/**
	 * 根据实习生ID与学习内容阶段查询学习内容id
	 * 
	 * @param tId    实习生id
	 * @param lStage 学习内容阶段
	 * @return
	 */
	int findLId(@Param("tId") Integer tId, @Param("lStage") Integer lStage);
	
	int findMaxStage(Integer tId);
}
