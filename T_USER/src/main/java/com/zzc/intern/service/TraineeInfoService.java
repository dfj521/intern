package com.zzc.intern.service;

import com.zzc.intern.DTO.TraineeInfoDTO;
import com.zzc.intern.entity.TraineeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.exception.BusinessException;
import com.zzc.intern.requestbody.ReqTraineeInfo;
import com.zzc.intern.vo.TraineeInfoVO;

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
     * @param traineeInfoDTO 实习生对象
     * @return 是否添加成功
     */
    boolean add(TraineeInfoDTO traineeInfoDTO) throws BusinessException;

    /**
     * 根据条件查询实习生信息
     *
     * @param reqTraineeInfo 实习生的条件查询信息
     * @return 实习生的基本信息
     */
    TraineeInfoVO queryByCondition(ReqTraineeInfo reqTraineeInfo) throws BusinessException;

    /**
     * 根据id删除实习生基本信息
     *
     * @param tId 实习生工号
     * @return 是否成功删除
     */
    boolean deleteById(Integer tId) throws BusinessException;

    /**
     * 根据id查询实习生信息
     *
     * @param tId 实习生工号
     * @return 实习生信息
     */
    TraineeInfoDTO queryById(Integer tId) throws BusinessException;

    /**
     * 根据id更新实习生基本信息
     *
     * @param traineeInfoDTO 实习生对象
     * @return 是否保存成功
     */
    boolean saveById(TraineeInfoDTO traineeInfoDTO) throws BusinessException;
}
