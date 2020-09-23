package com.zzc.intern.service.impl;

import com.zzc.intern.DTO.TraineeSubsidyDTO;
import com.zzc.intern.entity.TraineeSubsidyRel;
import com.zzc.intern.mapper.TraineeSubsidyRelMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.TraineeSubsidyRelService;
import com.zzc.intern.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeSubsidyRelServiceImpl extends ServiceImpl<TraineeSubsidyRelMapper, TraineeSubsidyRel>
		implements TraineeSubsidyRelService {

	@Resource
	private TraineeSubsidyRelMapper traineeSubsidyRelMapper;

	@Override
	public ResponseUtil<List<TraineeSubsidyDTO>> findTraineeSubsidy() {
		ResponseUtil<List<TraineeSubsidyDTO>> responseUtil = new ResponseUtil<>();
		List<TraineeSubsidyDTO> findTraineeSubsidy = traineeSubsidyRelMapper.findTraineeSubsidy();
		responseUtil.setCode(1);
		responseUtil.setData(findTraineeSubsidy);
		responseUtil.setMessage("查询成功");
		return responseUtil;
	}

	@Override
	public ResponseUtil<List<TraineeSubsidyDTO>> findTraineeSubsidybyId(Integer tId) {
		ResponseUtil<List<TraineeSubsidyDTO>> responseUtil = new ResponseUtil<>();
		List<TraineeSubsidyDTO> findTraineeSubsidybyId = traineeSubsidyRelMapper.findTraineeSubsidybyId(tId);
		responseUtil.setCode(1);
		responseUtil.setData(findTraineeSubsidybyId);
		responseUtil.setMessage("查询成功");
		return responseUtil;
	}

	@Override
	public ResponseUtil<Integer> addTraineeSubsidy(Integer tId, Integer sId) {
		ResponseUtil<Integer> responseUtil = new ResponseUtil<>();
		TraineeSubsidyRel traineeSubsidyRel = new TraineeSubsidyRel();
		traineeSubsidyRel.setSId(sId);
		traineeSubsidyRel.setTId(tId);
		traineeSubsidyRelMapper.addTraineeSubsidy(traineeSubsidyRel);
		responseUtil.setCode(1);
		responseUtil.setMessage("添加成功");
		return responseUtil;
	}

}
