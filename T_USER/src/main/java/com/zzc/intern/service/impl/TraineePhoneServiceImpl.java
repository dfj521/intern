package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.entity.TraineePhone;
import com.zzc.intern.mapper.TraineePhoneMapper;
import com.zzc.intern.service.TraineePhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实习生的所有电话 服务实现类
 */
@Slf4j
@Service
@Transactional
public class TraineePhoneServiceImpl extends ServiceImpl<TraineePhoneMapper, TraineePhone> implements TraineePhoneService {

    @Autowired
    TraineePhoneMapper traineePhoneMapper;

    /**
     * 根据实习生id查询该实习生的电话
     * @param tId 实习生id
     * @return 实习生的电话
     */
    @Override
    public List<TraineePhone> queryById(Integer tId) {
        return traineePhoneMapper.selectList(
                new LambdaQueryWrapper<TraineePhone>()
                        .eq(TraineePhone::getTraineeId, tId)
                        .eq(TraineePhone::getTraineePhoneStatus, "1"));
    }
}
