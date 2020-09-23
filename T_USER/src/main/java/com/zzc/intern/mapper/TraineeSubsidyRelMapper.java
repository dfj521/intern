package com.zzc.intern.mapper;

import com.zzc.intern.DTO.TraineeSubsidyDTO;
import com.zzc.intern.entity.TraineeSubsidyRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface TraineeSubsidyRelMapper extends BaseMapper<TraineeSubsidyRel> {

	/**
	 * 根据sId查询TraineeSubsidyRel
	 * 
	 * @param sId 学习内容id
	 * @return
	 */
	List<TraineeSubsidyRel> findTraineeSubsidyRels(Integer sId);

	/**
	 * 添加实习生补助信息
	 * @param traineeSubsidyRel 实习生补助
	 * @return
	 */
	int addTraineeSubsidy(TraineeSubsidyRel traineeSubsidyRel);
	/**
	 * 查询实习生补助信息
	 * @return 实习生补助信息
	 */
	List<TraineeSubsidyDTO> findTraineeSubsidy();

	/**
	 * 根据实习生Id查询实习生补助信息
	 * @param tId 实习生id
	 * @return
	 */
	List<TraineeSubsidyDTO> findTraineeSubsidybyId(Integer tId);

}
