package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.entity.TraineeContacts;
import com.zzc.intern.mapper.TraineeContactsMapper;
import com.zzc.intern.service.TraineeContactsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实习生的所有紧急联系人信息 服务实现类
 */
@Slf4j
@Service
@Transactional
public class TraineeContactsServiceImpl extends ServiceImpl<TraineeContactsMapper, TraineeContacts> implements TraineeContactsService {

    @Autowired
    private TraineeContactsMapper traineeContactsMapper;

    /**
     * 根据实习生id查询该实习生的紧急联系人信息
     *
     * @param tId 实习生id
     * @return 实习生的紧急联系人信息
     */
    @Override
    public List<TraineeContacts> queryById(Integer tId) {
        return traineeContactsMapper.selectList(
                new LambdaQueryWrapper<TraineeContacts>()
                        .eq(TraineeContacts::getTraineeId, tId)
                        .eq(TraineeContacts::getTraineeContactsStatus, "1"));
    }
}
