package com.zzc.intern.service;

import com.zzc.intern.DTO.JobSubsidyDTO;
import com.zzc.intern.DTO.TraineeAssessLearnResultDTO;
import com.zzc.intern.entity.AssessInfo;
import com.zzc.intern.entity.SubsidyInfo;
import com.zzc.intern.util.ResponseUtil;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 补贴 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface SubsidyInfoService extends IService<SubsidyInfo> {

	ResponseUtil<List<JobSubsidyDTO>> findSubsidy();

	ResponseUtil<SubsidyInfo> findSubsidyByid(Integer id);

	ResponseUtil<SubsidyInfo> findSubsidyByjId(Integer jId);

	ResponseUtil<Integer> addSubsidy(Double sSubsidies,Integer sIssuedTime,Integer sLssueNum,Integer jId);

	ResponseUtil<Integer> updateSubsidy(Double sSubsidies,Integer sIssuedTime,Integer sLssueNum,Integer sId);

	ResponseUtil<Integer> delSubsidy(Integer id);

}
