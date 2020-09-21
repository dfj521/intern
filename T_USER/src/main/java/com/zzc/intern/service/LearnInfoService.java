package com.zzc.intern.service;

import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.util.ResponseUtil;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学习内容 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface LearnInfoService extends IService<LearnInfo> {

	
	ResponseUtil<List<LearnInfo>> findAllLearn();
	
	ResponseUtil<LearnInfo> findById(int id);
	
	ResponseUtil<Integer> updateLearn(LearnInfo learnInfo);
	
	ResponseUtil<Integer> addLearn(LearnInfo learnInfo);



}
