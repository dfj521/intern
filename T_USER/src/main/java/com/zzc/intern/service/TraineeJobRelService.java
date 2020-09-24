package com.zzc.intern.service;

import com.zzc.intern.DTO.TraineeJobRelDTO;
import com.zzc.intern.entity.TraineeJobRel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.vo.TraineeJobRelVO;

/**
 * <p>
 * 实习生信息与岗位信息的关联表 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface TraineeJobRelService extends IService<TraineeJobRel> {

    /**
     * 按条件分页查询实习生的岗位信息
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param tName   实习生姓名
     * @param jName   岗位名称
     * @return 实习生的岗位信息
     */
    TraineeJobRelVO queryByCondition(Integer current, Integer size, String tName, String jName);

    /**
     * 根据id查询实习生的岗位信息
     *
     * @param tjId 实习生的岗位信息id
     * @return 实习生的岗位信息
     */
    TraineeJobRelDTO queryById(Integer tjId);
}
