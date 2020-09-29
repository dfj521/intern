package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzc.intern.DTO.LearnInfoDTO;
import com.zzc.intern.entity.CourseInfo;
import com.zzc.intern.entity.LearnInfo;
import com.zzc.intern.entity.TraineeInfo;
import com.zzc.intern.entity.TraineeLearnRel;
import com.zzc.intern.mapper.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.TraineeLearnRelService;
import com.zzc.intern.vo.TraineeLearnRelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 实习生信息与学习内容信息关联表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeLearnRelServiceImpl extends ServiceImpl<TraineeLearnRelMapper, TraineeLearnRel> implements TraineeLearnRelService {

    @Autowired
    private TraineeInfoMapper traineeInfoMapper;

    @Autowired
    private LearnInfoMapper learnInfoMapper;

    @Autowired
    private TraineeLearnRelMapper traineeLearnRelMapper;

    /**
     * 添加实习生的学习内容信息
     *
     * @param traineeId 实习生编号
     * @param learnIds 学习内容编号
     * @return 是否添加成功
     */
    @Override
    public boolean addTraineeLearn(Integer traineeId, List<Integer> learnIds) {
        int i = 0;

        //校验参数
        if (traineeId == null || learnIds.size() == 0) {
            return false;
        }

        //查询是否有这个实习生
        Integer tiCount = traineeInfoMapper.selectCount(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(TraineeInfo::getTraineeId, traineeId)
                        .eq(TraineeInfo::getTraineeStatus, "1"));
        if (tiCount == 0) {
            return false;
        }

        //查询是否有这些学习内容
        Integer liCount = learnInfoMapper.selectCount(
                new LambdaQueryWrapper<LearnInfo>()
                        .in(LearnInfo::getLearnId, learnIds));
        if (liCount == 0) {
            return false;
        }

        //添加实习生的学习内容
        for (Integer learnId : learnIds) {
            TraineeLearnRel traineeLearnRel = new TraineeLearnRel();
            traineeLearnRel.setTraineeId(traineeId);
            traineeLearnRel.setLearnId(learnId);
            traineeLearnRel.setLearnState(0);
            traineeLearnRel.setTraineeLearnStatus("1");
            i = traineeLearnRelMapper.insert(traineeLearnRel);
        }

        return i > 0;
    }

    /**
     * 根据实习生id查询学习内容信息
     *
     * @param traineeId 实习生编号
     * @return 实习生的学习内容信息
     */
    @Override
    public TraineeLearnRelVO queryTraineeLearn(Integer traineeId) {

        TraineeLearnRelVO traineeLearnRelVO = new TraineeLearnRelVO();

        //参数校验
        if (traineeId == null) {
            return null;
        }

        //查询是否有这个实习生
        TraineeInfo traineeInfo = traineeInfoMapper.selectOne(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(TraineeInfo::getTraineeId, traineeId)
                        .eq(TraineeInfo::getTraineeStatus, "1"));
        if (traineeInfo == null) {
            return null;
        }

        traineeLearnRelVO.setTraineeId(traineeId);
        traineeLearnRelVO.setTraineeName(traineeInfo.getTraineeName());

        //查询这个实习生的学习内容
        List<TraineeLearnRel> traineeLearnRels = traineeLearnRelMapper.selectList(
                new LambdaQueryWrapper<TraineeLearnRel>()
                        .eq(TraineeLearnRel::getTraineeId, traineeId)
                        .eq(TraineeLearnRel::getTraineeLearnStatus, "1"));
        if (traineeLearnRels.size() == 0) {
            return traineeLearnRelVO;
        }

        List<LearnInfoDTO> learnInfoDTOS = new ArrayList<>();

        //查询实习生的学习内容
        for (TraineeLearnRel traineeLearnRel : traineeLearnRels) {
            LearnInfoDTO learnInfoDTO = new LearnInfoDTO();
            Integer learnId = traineeLearnRel.getLearnId();
            learnInfoDTO.setLearnId(learnId);
            learnInfoDTO.setLearnState(traineeLearnRel.getLearnState());
            LearnInfo learnInfo = learnInfoMapper.selectById(learnId);
            learnInfoDTO.setLearnElementary(learnInfo.getLearnElementary());
            learnInfoDTO.setLearnStage(learnInfo.getLearnStage());
            learnInfoDTOS.add(learnInfoDTO);
        }

        traineeLearnRelVO.setLearnInfoDTOS(learnInfoDTOS);

        return traineeLearnRelVO;
    }
}
