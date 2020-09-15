package com.zzc.intern.service.impl;

import com.zzc.intern.entity.JobLearnRel;
import com.zzc.intern.mapper.JobLearnRelMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.JobLearnRelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 岗位信息和学习内容信息的关联表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class JobLearnRelServiceImpl extends ServiceImpl<JobLearnRelMapper, JobLearnRel> implements JobLearnRelService {

}
