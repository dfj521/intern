package com.zzc.intern.service.impl;

import com.zzc.intern.entity.TraineeHouseRel;
import com.zzc.intern.mapper.TraineeHouseRelMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.TraineeHouseRelService;
import com.zzc.intern.vo.TraineeHouseRelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeHouseRelServiceImpl extends ServiceImpl<TraineeHouseRelMapper, TraineeHouseRel> implements TraineeHouseRelService {

    /**
     * 按条件分页查询实习生的宿舍信息
     *
     * @param current  当前页
     * @param size     每页显示条数
     * @param tName    实习生姓名
     * @param hAddress 宿舍地址
     * @return 实习生的宿舍信息
     */
    @Override
    public TraineeHouseRelVO queryByCondition(Integer current, Integer size, String tName, String hAddress) {

        return null;
    }
}
