package com.zzc.intern.service;

import com.zzc.intern.DTO.TraineeInfoSaveDTO;
import com.zzc.intern.entity.TraineeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.vo.TraineeInfoVO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 实习生个人信息 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface TraineeInfoService extends IService<TraineeInfo> {

    /**
     * 添加实习生信息
     *
     * @param traineeInfoSaveDTO 实习生对象
     * @return 是否添加成功
     */
    boolean add(TraineeInfoSaveDTO traineeInfoSaveDTO);

    /**
     * 分页查询所有实习生基本信息
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @return 实习生的基本信息
     */
    TraineeInfoVO queryList(Integer current, Integer size);

    /**
     * 根据条件查询实习生信息
     *
     * @param tName     实习生姓名
     * @param startTime 开始时间
     * @param endTime   终止时间
     * @return 实习生的基本信息
     */
    TraineeInfoVO queryByCondition(Integer current, Integer size, String tName, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 根据id删除实习生基本信息
     *
     * @param tId 实习生id
     * @return 是否成功删除
     */
    boolean deleteById(Integer tId);
}
