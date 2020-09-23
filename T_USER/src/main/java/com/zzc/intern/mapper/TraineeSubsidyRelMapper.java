package com.zzc.intern.mapper;

import com.zzc.intern.entity.TraineeSubsidyRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface TraineeSubsidyRelMapper extends BaseMapper<TraineeSubsidyRel> {

	List<TraineeSubsidyRel> findTraineeSubsidyRels(Integer sId);
	
}
