package com.zzc.intern.mapper;

import com.zzc.intern.entity.LearnInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * <p>
 * 学习内容 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface LearnInfoMapper extends BaseMapper<LearnInfo> {
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
	int updateLearn(LearnInfo learnInfo);

	/**
	 * 添加学习内容
	 * 
	 * @param learnInfo 学习内容
	 * @return
	 */
	int addLearn(LearnInfo learnInfo);

	/**
	 * 删除学习内容
	 * 
	 * @param lId 学习内容id
	 * @return
	 */
	int delLearn(Integer learnId);

	
}
