package com.zzc.intern.service;

import com.zzc.intern.entity.TraineeHouseRel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.vo.TraineeHouseRelVO;
import com.zzc.intern.vo.TraineeJobRelVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface TraineeHouseRelService extends IService<TraineeHouseRel> {

    /**
     * 按条件分页查询实习生的宿舍信息
     *
     * @param current 当前页
     * @param size 每页显示条数
     * @param tName 实习生姓名
     * @param hAddress 宿舍地址
     * @return 实习生的宿舍信息
     */
    TraineeHouseRelVO queryByCondition(Integer current, Integer size, String tName, String hAddress);
}
