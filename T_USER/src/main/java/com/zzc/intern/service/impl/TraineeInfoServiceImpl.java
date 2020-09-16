package com.zzc.intern.service.impl;

import com.zzc.intern.entity.TraineeInfo;
import com.zzc.intern.mapper.TraineeInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.TraineeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 实习生个人信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeInfoServiceImpl extends ServiceImpl<TraineeInfoMapper, TraineeInfo> implements TraineeInfoService {

}
