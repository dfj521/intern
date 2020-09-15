package com.zzc.intern.service.impl;

import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.mapper.LearnInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.LearnInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

}
