package com.zzc.intern.service.impl;

import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.mapper.LearnInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.LearnInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * <p>
 * 学习内容 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Service
@Transactional
public class LearnInfoServiceImpl extends ServiceImpl<LearnInfoMapper, LearnInfo> implements LearnInfoService {

	@Resource
	private LearnInfoMapper learnInfoMapper;

	@Override
	public List<LearnInfo> findAllLearn(Integer page, Integer size) {
		page=(page-1)*size;
		return learnInfoMapper.findAllLearn(page, size);
	}

	@Override
	public LearnInfo findByid(Integer learnId) {
		return learnInfoMapper.findByid(learnId);
	}

	@Override
	public List<LearnInfo> findByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		return learnInfoMapper.findByCourseId(courseId);
	}

	@Override
	public int updateLearn(Integer learnId, String learnElementary, Integer learnStage, Integer courseId) {
		// TODO Auto-generated method stub
		LearnInfo learnInfo = new LearnInfo();
		learnInfo.setCourseId(courseId);
		learnInfo.setLearnElementary(learnElementary);
		learnInfo.setLearnId(learnId);
		learnInfo.setLearnStage(learnStage);
		return learnInfoMapper.updateLearn(learnInfo);
	}

	@Override
	public int addLearn(String learnElementary, Integer learnStage, Integer courseId) {
		LearnInfo learnInfo = new LearnInfo();
		learnInfo.setCourseId(courseId);
		learnInfo.setLearnElementary(learnElementary);
		learnInfo.setLearnStage(learnStage);
		return learnInfoMapper.addLearn(learnInfo);
	}

	@Override
	public int delLearn(Integer learnId) {
		// TODO Auto-generated method stub
		return learnInfoMapper.delLearn(learnId);
	}

}
