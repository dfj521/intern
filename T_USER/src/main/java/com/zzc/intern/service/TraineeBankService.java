package com.zzc.intern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.entity.TraineeBank;

import java.util.List;

/**
 * 实习生的所有银行卡信息 服务类
 */
public interface TraineeBankService extends IService<TraineeBank> {
    /**
     * 根据实习生id查询该实习生的银行卡信息
     * @param tId 实习生id
     * @return 实习生的银行卡信息
     */
    List<TraineeBank> queryById(Integer tId);
}
