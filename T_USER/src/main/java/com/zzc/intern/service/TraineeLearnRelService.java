package com.zzc.intern.service;

import com.zzc.intern.DTO.TraineeLearnRelDTO;
import com.zzc.intern.entity.TraineeLearnRel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.vo.TraineeLearnRelVO;

import java.util.List;

/**
 * <p>
 * 实习生信息与学习内容信息关联表 服务类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
public interface TraineeLearnRelService extends IService<TraineeLearnRel> {

    /**
     * 添加实习生的学习内容信息
     *
     * @param traineeId 实习生编号
     * @param learnIds  学习内容编号
     * @return 是否添加成功
     */
    boolean addTraineeLearn(Integer traineeId, List<Integer> learnIds);

    /**
     * 根据实习生id查询学习内容信息
     *
     * @param traineeId 实习生编号
     * @return 实习生的学习内容信息
     */
    TraineeLearnRelVO queryTraineeLearn(Integer traineeId);

    /**
     * 根据实习生id修改学习内容信息
     *
     * @param traineeLearnRelDTO 实习生的学习内容
     * @return 是否修改成功
     */
    boolean updateTraineeLearn(TraineeLearnRelDTO traineeLearnRelDTO);
}
