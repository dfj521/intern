package com.zzc.intern.mapper;

import com.zzc.intern.entity.JobLearnRel;
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

}
