package com.zzc.intern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.entity.TraineePhone;

import java.util.List;

/**
 * 实习生的所有电话 服务类
 */
public interface TraineePhoneService extends IService<TraineePhone> {
    /**
     * 根据实习生id查询该实习生的电话
     * @param tId 实习生id
     * @return 实习生的电话
     */
    List<TraineePhone> queryById(Integer tId);
}
