package com.zzc.intern.service;

import com.zzc.intern.DTO.TraineeInfoAllDTO;
import com.zzc.intern.util.ResponseUtil;
import com.zzc.intern.vo.AssessInfoVO;
import com.zzc.intern.vo.LearnInfoVO;

import java.util.List;

public interface TraineeInfoAllService {

    /**
     * 查询所有实习生信息
     *
     * @return
     */
    ResponseUtil<List<TraineeInfoAllDTO>> findAll();

    /**
     * 根据实习生条件查询所有实习生信息
     *
     * @param traineeInfoAllDTO 实习生信息
     * @return
     */
    ResponseUtil<List<TraineeInfoAllDTO>> findByCondition(TraineeInfoAllDTO traineeInfoAllDTO);

    /**
     * 添加实习生信息
     *
     * @param traineeInfoAllDTO 实习生信息
     * @return
     */
    ResponseUtil<Integer> addTrainee(TraineeInfoAllDTO traineeInfoAllDTO);

    /**
     * 更新实习生信息
     *
     * @param traineeInfoAllDTO 实习生信息
     * @return
     */
    ResponseUtil<Integer> updateTrainee(TraineeInfoAllDTO traineeInfoAllDTO);

    /**
     * 删除实习生信息
     *
     * @param tId 实习生编号
     * @return
     */
    ResponseUtil<Integer> deleteTrainee(Integer tId);

    /**
     * 根据实习生的id查询实习生的学习情况
     *
     * @param tId 实习生编号
     * @return
     */
    ResponseUtil<List<LearnInfoVO>> selectTraineeLearn(Integer tId);

    /**
     * 根据实习生的id和学习内容id查询实习生的考核情况
     *
     * @param tId 实习生编号
     * @param lId 学习内容编号
     * @return
     */
    ResponseUtil<List<AssessInfoVO>> selectTraineeAssess(Integer tId, Integer lId);
}
