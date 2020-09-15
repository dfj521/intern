package com.zzc.intern.service.impl;

import com.zzc.intern.entity.TraineeHouseRel;
import com.zzc.intern.mapper.TraineeHouseRelMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.TraineeHouseRelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeHouseRelServiceImpl extends ServiceImpl<TraineeHouseRelMapper, TraineeHouseRel> implements TraineeHouseRelService {

}
