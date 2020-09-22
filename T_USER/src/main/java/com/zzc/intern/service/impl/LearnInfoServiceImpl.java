package com.zzc.intern.service.impl;

import com.zzc.intern.entity.JobLearnRel;
import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.mapper.JobLearnRelMapper;
import com.zzc.intern.mapper.LearnInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.LearnInfoService;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 学习内容 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class LearnInfoServiceImpl extends ServiceImpl<LearnInfoMapper, LearnInfo> implements LearnInfoService {

	@Resource
	private LearnInfoMapper learnInfoMapper;

	@Resource
	private JobLearnRelMapper JobLearnRelMapper;

	@Override
	public ResponseUtil<List<LearnInfo>> findAllLearn() {
		ResponseUtil<List<LearnInfo>> responseUtil = new ResponseUtil<>();
		List<LearnInfo> findAllLearn = new ArrayList<>();
		try {
			findAllLearn = learnInfoMapper.findAllLearn();
		} catch (Exception e) {
			responseUtil.setCode(0);
			responseUtil.setMessage("查询失败");
		}
		responseUtil.setCode(1);
		responseUtil.setMessage("查询成功");
		responseUtil.setData(findAllLearn);
		return responseUtil;
	}

	@Override
	public ResponseUtil<LearnInfo> findById(int id) {
		ResponseUtil<LearnInfo> responseUtil = new ResponseUtil<>();
		LearnInfo findByid = new LearnInfo();
		try {
			findByid = learnInfoMapper.findByid(id);
		} catch (Exception e) {
			responseUtil.setCode(0);
			responseUtil.setMessage("查询失败");
		}
		responseUtil.setCode(1);
		responseUtil.setMessage("查询成功");
		responseUtil.setData(findByid);
		return responseUtil;
	}

	@Override
	public ResponseUtil<Integer> updateLearn(Integer id, String lElementary, Integer lStage) {
		ResponseUtil<Integer> responseUtil = new ResponseUtil<>();
		try {
			LearnInfo learnInfo=new LearnInfo();
			learnInfo.setLElementary(lElementary);
			learnInfo.setLId(id);
			learnInfo.setLStage(lStage);
			learnInfoMapper.updateLearn(learnInfo);
		} catch (Exception e) {
			responseUtil.setCode(0);
			responseUtil.setMessage("修改失败");
		}
		responseUtil.setCode(1);
		responseUtil.setMessage("修改成功");
		return responseUtil;
	}

	@Override
	public ResponseUtil<Integer> addLearn(Integer id,String lElementary, Integer lStage) {
		ResponseUtil<Integer> responseUtil = new ResponseUtil<>();
		LearnInfo learnInfo=new LearnInfo();
		learnInfo.setLElementary(lElementary);
		learnInfo.setLStage(lStage);
		
		try {
			int addLearn = learnInfoMapper.addLearn(learnInfo);
			System.out.println(learnInfo.getLId());
			JobLearnRel jobLearnRel = new JobLearnRel();
			jobLearnRel.setLId(learnInfo.getLId());
			jobLearnRel.setJId(id);
			JobLearnRelMapper.addJobLearn(jobLearnRel);
			responseUtil.setCode(1);
			responseUtil.setMessage("添加成功");
		} catch (Exception e) {
			responseUtil.setCode(0);
			responseUtil.setMessage("添加失败");
		}

		return responseUtil;
	}

}
