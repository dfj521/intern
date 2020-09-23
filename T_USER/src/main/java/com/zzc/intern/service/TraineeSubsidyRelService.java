package com.zzc.intern.service;

import com.zzc.intern.DTO.TraineeSubsidyDTO;
import com.zzc.intern.entity.TraineeSubsidyRel;
import com.zzc.intern.util.ResponseUtil;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface TraineeSubsidyRelService extends IService<TraineeSubsidyRel> {
	/**
	 * 查询实习生补助信息
	 * @return 实习生补助信息
	 */
	ResponseUtil<List<TraineeSubsidyDTO>> findTraineeSubsidy();
	/**
	 * 根据实习生Id查询实习生补助信息
	 * @param tId 实习生id
	 * @return
	 */
	ResponseUtil<List<TraineeSubsidyDTO>> findTraineeSubsidybyId(Integer tId);
	/**
	 * 添加实习生补助信息
	 * @param tId 实习生id
	 * @param sId 补助id
	 * @return
	 */
	ResponseUtil<Integer> addTraineeSubsidy(Integer tId,Integer sId);
	
}
