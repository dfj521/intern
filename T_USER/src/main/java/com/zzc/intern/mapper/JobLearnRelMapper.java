package com.zzc.intern.mapper;

import com.zzc.intern.entity.JobInfo;
import com.zzc.intern.entity.JobLearnRel;
import com.zzc.intern.entity.LearnInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 岗位信息和学习内容信息的关联表 Mapper 接口
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Repository
public interface JobLearnRelMapper extends BaseMapper<JobLearnRel> {
	/**
	 * 根据岗位id查询学习内容
	 * @param jid 岗位id
	 * @return 学习内容
	 */
	LearnInfo findLearnByJId(Integer jId);
	/**
	 * 根据ID删除岗位&学习内容数据
	 * @param id 岗位&学习内容id
	 * @return 成功否
	 */
	int delJobLearnById(Integer id);
	/**
	 * 添加岗位&学习内容
	 * @param jobLearnRel 添加岗位&学习内容
	 * @return 成功否
	 */
	int addJobLearn(JobLearnRel jobLearnRel);
}
