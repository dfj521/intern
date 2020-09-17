package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.entity.TraineeAssessRel;
import com.zzc.intern.mapper.TraineeAssessRelMapper;
import com.zzc.intern.service.TraineeAssessRelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 实习生&考核 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-17
 */
@Slf4j
@Service
@Transactional
public class TraineeAssessRelServiceImpl extends ServiceImpl<TraineeAssessRelMapper, TraineeAssessRel> implements TraineeAssessRelService {

}
