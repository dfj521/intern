package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.entity.TraineeBank;
import com.zzc.intern.mapper.TraineeBankMapper;
import com.zzc.intern.service.TraineeBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实习生的所有银行卡信息 服务实现类
 */
@Slf4j
@Service
@Transactional
public class TraineeBankServiceImpl extends ServiceImpl<TraineeBankMapper, TraineeBank> implements TraineeBankService {

    @Autowired
    TraineeBankMapper traineeBankMapper;

    @Override
    public List<TraineeBank> queryById(Integer tId) {
        return traineeBankMapper.selectList(
                new LambdaQueryWrapper<TraineeBank>()
                        .eq(TraineeBank::getTraineeId, tId)
                        .eq(TraineeBank::getTraineeBankStatus, "1"));
    }
}
