package com.zzc.intern.service.impl;

import com.zzc.intern.DTO.TraineeAssessLearnParameterDTO;
import com.zzc.intern.DTO.TraineeAssessLearnResultDTO;
import com.zzc.intern.entity.AssessInfo;
import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.entity.TraineeLearnRel;
import com.zzc.intern.mapper.AssessInfoMapper;
import com.zzc.intern.mapper.TraineeLearnRelMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.AssessInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 考核信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class AssessInfoServiceImpl extends ServiceImpl<AssessInfoMapper, AssessInfo> implements AssessInfoService {

	@Resource
	private AssessInfoMapper assessInfoMapper;
	@Resource
	private TraineeLearnRelMapper traineeLearnRelMapper;

	@Override
	public ResponseUtil<List<TraineeAssessLearnResultDTO>> findByEerm(String name, Double minaGrade, Double maxaGrade,
			Integer lstage) {
		// TODO Auto-generated method stub
		ResponseUtil<List<TraineeAssessLearnResultDTO>> responseUtil = new ResponseUtil<>();
		TraineeAssessLearnParameterDTO traineeAssessLearnParameterDTO = new TraineeAssessLearnParameterDTO();
		traineeAssessLearnParameterDTO.setTName(name);
		traineeAssessLearnParameterDTO.setLStage(lstage);
		traineeAssessLearnParameterDTO.setMinaGrade(minaGrade);
		traineeAssessLearnParameterDTO.setMaxaGrade(maxaGrade);
		System.out.println(maxaGrade);

		System.out.println(traineeAssessLearnParameterDTO);
		List<TraineeAssessLearnResultDTO> findByEerm = assessInfoMapper.findByEerm(traineeAssessLearnParameterDTO);
		findByEerm.forEach(System.out::print);
		if (findByEerm.size() > 0) {
			responseUtil.setCode(1);
			responseUtil.setMessage("查询成功");
			responseUtil.setData(findByEerm);
		} else {
			responseUtil.setCode(0);
			responseUtil.setMessage("查询失败");
		}
		return responseUtil;

	}

	@Override
	public ResponseUtil addAssess(Double grade, Integer lId,Integer lStage, Integer tId) {
		// TODO Auto-generated method stub
		ResponseUtil responseUtil = new ResponseUtil();
		AssessInfo assessInfo = new AssessInfo();
		assessInfo.setAGrade(grade);
		assessInfo.setLId(lId);
		assessInfo.setTId(tId);
		if (assessInfoMapper.findMaxStage(tId)==lStage) {
			if (grade >= 60) {
				assessInfo.setAState("1");
				assessInfoMapper.addAssess(assessInfo);
				traineeLearnRelMapper.updateState(tId);
			} else {
				assessInfo.setAState("0");
				assessInfoMapper.addAssess(assessInfo);
			}
		}else {
			if (grade >= 60) {
				assessInfo.setAState("1");
				assessInfoMapper.addAssess(assessInfo);
				traineeLearnRelMapper.updateState(tId);
				TraineeLearnRel traineeLearnRel = new TraineeLearnRel();
				int findLId = assessInfoMapper.findLId(tId, lStage);
				traineeLearnRel.setLId(findLId);
				traineeLearnRel.setTId(tId);
				traineeLearnRelMapper.addLearn(traineeLearnRel);
			} else {
				assessInfo.setAState("0");
				assessInfoMapper.addAssess(assessInfo);
			}
		}
		responseUtil.setCode(1);
		responseUtil.setMessage("添加成功");
		return responseUtil;
	}

	@Override
	public ResponseUtil updateAssess(AssessInfo assessInfo) {
		// TODO Auto-generated method stub
		int updateAssess = assessInfoMapper.updateAssess(assessInfo);
		ResponseUtil responseUtil = new ResponseUtil<>();
		if (updateAssess != 0) {
			responseUtil.setCode(1);
			responseUtil.setMessage("修改成功");
		} else {
			responseUtil.setCode(0);
			responseUtil.setMessage("修改失败");
		}
		return responseUtil;
	}

	@Override
	public ResponseUtil delAssess(int id) {
		// TODO Auto-generated method stub
		ResponseUtil responseUtil = new ResponseUtil<>();
		int delAssess = assessInfoMapper.delAssess(id);
		if (delAssess != 0) {
			responseUtil.setCode(1);
			responseUtil.setMessage("删除成功");
		} else {
			responseUtil.setCode(0);
			responseUtil.setMessage("删除失败");
		}

		return responseUtil;
	}

	@Override
	public ResponseUtil<TraineeAssessLearnResultDTO> findById(int id) {
		// TODO Auto-generated method stub
		ResponseUtil<TraineeAssessLearnResultDTO> responseUtil = new ResponseUtil<>();
		TraineeAssessLearnResultDTO findByid = assessInfoMapper.findById(id);
		if (findByid != null) {
			responseUtil.setCode(1);
			responseUtil.setMessage("查询成功");
			responseUtil.setData(findByid);
		} else {
			responseUtil.setCode(0);
			responseUtil.setMessage("查询失败");
		}
		return responseUtil;
	}

}
