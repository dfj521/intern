package com.zzc.intern.service;

import com.zzc.intern.entity.LearnInfo;

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

	
		/**
		 * 查询所有的学习内容
		 * 
		 * @return 所有学习内容
		 */
		List<LearnInfo> findAllLearn(Integer page,Integer size);

		/**
		 * 根据学习内容ID查询学习内容
		 * 
		 * @param id 学习内容id
		 * @return 学习内容
		 */
		LearnInfo findByid(Integer learnId);

		
		List<LearnInfo> findByCourseId(Integer courseId);
		/**
		 * 修改学习内容
		 * 
		 * @param learnInfo 学习内容
		 * @return
		 */
		int updateLearn(Integer learnId,String learnElementary,Integer learnStage,Integer courseId);

		/**
		 * 添加学习内容
		 * 
		 * @param learnInfo 学习内容
		 * @return
		 */
		int addLearn(String learnElementary,Integer learnStage,Integer courseId);

		/**
		 * 删除学习内容
		 * 
		 * @param lId 学习内容id
		 * @return
		 */
		int delLearn(Integer learnId);

		
	
}
