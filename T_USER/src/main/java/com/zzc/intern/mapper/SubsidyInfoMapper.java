package com.zzc.intern.mapper;

import com.zzc.intern.DTO.JobSubsidyDTO;
import com.zzc.intern.entity.SubsidyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * 补贴 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface SubsidyInfoMapper extends BaseMapper<SubsidyInfo> {

	List<JobSubsidyDTO> findSubsidy();
	
	int addSubsidy(SubsidyInfo subsidyInfo);
	
	int updateSubsidy(SubsidyInfo subsidyInfo);
	
	SubsidyInfo findSubsidyByid(Integer id);
	
	int delSubsidy(Integer id);
	
	SubsidyInfo findSubsidyByjId(Integer jId);
	
	
	
	
	
}
