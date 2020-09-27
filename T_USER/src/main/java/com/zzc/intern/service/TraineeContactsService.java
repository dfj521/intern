package com.zzc.intern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.entity.TraineeContacts;

import java.util.List;

/**
 * 实习生的所有紧急联系人信息 服务类
 */
public interface TraineeContactsService extends IService<TraineeContacts> {
    /**
     * 根据实习生id查询该实习生的紧急联系人信息
     *
     * @param tId 实习生id
     * @return 实习生的紧急联系人信息
     */
    List<TraineeContacts> queryById(Integer tId);
}
