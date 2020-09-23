package com.zzc.intern.service.impl;

import com.zzc.intern.DTO.JobSubsidyDTO;
import com.zzc.intern.entity.SubsidyInfo;
import com.zzc.intern.mapper.SubsidyInfoMapper;
import com.zzc.intern.mapper.TraineeSubsidyRelMapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.SubsidyInfoService;
import com.zzc.intern.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 补贴 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class SubsidyInfoServiceImpl extends ServiceImpl<SubsidyInfoMapper, SubsidyInfo> implements SubsidyInfoService {

	@Resource
	private SubsidyInfoMapper subsidyInfoMapper;

	@Resource
	private TraineeSubsidyRelMapper traineeSubsidyRelMapper;
	
	@Override
	public ResponseUtil<List<JobSubsidyDTO>> findSubsidy() {
		ResponseUtil<List<JobSubsidyDTO>> responseUtil = new ResponseUtil<>();
		List<JobSubsidyDTO> findSubsidy = subsidyInfoMapper.findSubsidy();
		responseUtil.setCode(1);
		responseUtil.setMessage("查询成功");
		responseUtil.setData(findSubsidy);
		return responseUtil;
	}

	@Override
	public ResponseUtil<SubsidyInfo> findSubsidyByid(Integer id) {
		ResponseUtil<SubsidyInfo> responseUtil = new ResponseUtil<>();
		SubsidyInfo findSubsidyByid = subsidyInfoMapper.findSubsidyByid(id);
		responseUtil.setCode(1);
		responseUtil.setMessage("查询成功");
		responseUtil.setData(findSubsidyByid);
		return responseUtil;
	}

	@Override
	public ResponseUtil<SubsidyInfo> findSubsidyByjId(Integer jId) {
		ResponseUtil<SubsidyInfo> responseUtil = new ResponseUtil<>();
		SubsidyInfo findSubsidyByjId = subsidyInfoMapper.findSubsidyByjId(jId);
		responseUtil.setCode(1);
		responseUtil.setMessage("查询成功");
		responseUtil.setData(findSubsidyByjId);
		return responseUtil;
	}

	@Override
	public ResponseUtil<Integer> addSubsidy(Double sSubsidies, Integer sIssuedTime, Integer sLssueNum, Integer jId) {
		ResponseUtil<Integer> responseUtil = new ResponseUtil<>();
		if (StringUtils.isEmpty(subsidyInfoMapper.findSubsidyByjId(jId))) {
			SubsidyInfo subsidyInfo = new SubsidyInfo();
			subsidyInfo.setJId(jId);
			subsidyInfo.setSIssuedTime(sIssuedTime);
			subsidyInfo.setSLssueNum(sLssueNum);
			subsidyInfo.setSSubsidies(sSubsidies);
			subsidyInfoMapper.addSubsidy(subsidyInfo);
			responseUtil.setCode(1);
			responseUtil.setMessage("添加成功");
		} else {
			responseUtil.setCode(2);
			responseUtil.setMessage("已添加过");
		}
		return responseUtil;
	}

	@Override
	public ResponseUtil<Integer> updateSubsidy(Double sSubsidies, Integer sIssuedTime, Integer sLssueNum, Integer sId) {
		ResponseUtil<Integer> responseUtil = new ResponseUtil<>();
		SubsidyInfo subsidyInfo = new SubsidyInfo();
		subsidyInfo.setSId(sId);
		subsidyInfo.setSIssuedTime(sIssuedTime);
		subsidyInfo.setSLssueNum(sLssueNum);
		subsidyInfo.setSSubsidies(sSubsidies);
		subsidyInfoMapper.updateSubsidy(subsidyInfo);
		responseUtil.setCode(1);
		responseUtil.setMessage("修改成功");
		return responseUtil;
	}

	@Override
	public ResponseUtil<Integer> delSubsidy(Integer id) {
		ResponseUtil<Integer> responseUtil = new ResponseUtil<>();
		if (StringUtils.isEmpty(traineeSubsidyRelMapper.findTraineeSubsidyRels(id))) {
			subsidyInfoMapper.delSubsidy(id);
			responseUtil.setCode(1);
			responseUtil.setMessage("删除成功");
		}else {
			responseUtil.setCode(2);
			responseUtil.setMessage("有实习生使用这个补助，不能删除");
		}
		return responseUtil;
	}

}
