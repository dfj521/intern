package com.zzc.intern.service;

import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.util.ResponseUtil;

import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

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

	ResponseUtil<Integer> updateLearn(Integer id, String lElementary, Integer lStage);

	ResponseUtil<Integer> addLearn(Integer id,String lElementary, Integer lStage);
	
	ResponseUtil<Integer> delLearn(Integer id);
}
