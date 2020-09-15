package com.zzc.intern.service.impl;

import com.zzc.intern.entity.TraineeJobRel;
import com.zzc.intern.mapper.TraineeJobRelMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.TraineeJobRelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 实习生信息与岗位信息的关联表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeJobRelServiceImpl extends ServiceImpl<TraineeJobRelMapper, TraineeJobRel> implements TraineeJobRelService {

}
