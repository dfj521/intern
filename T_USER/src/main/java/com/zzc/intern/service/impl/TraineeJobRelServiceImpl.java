package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzc.intern.Convert.TraineeJobRelConvert;
import com.zzc.intern.DTO.TraineeJobRelDTO;
import com.zzc.intern.entity.JobInfo;
import com.zzc.intern.entity.TraineeInfo;
import com.zzc.intern.entity.TraineeJobRel;
import com.zzc.intern.mapper.JobInfoMapper;
import com.zzc.intern.mapper.TraineeInfoMapper;
import com.zzc.intern.mapper.TraineeJobRelMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.TraineeJobRelService;
import com.zzc.intern.vo.TraineeJobRelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 实习生信息与岗位信息的关联表 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeJobRelServiceImpl extends ServiceImpl<TraineeJobRelMapper, TraineeJobRel> implements TraineeJobRelService {

    @Autowired
    private TraineeInfoMapper traineeInfoMapper;

    @Autowired
    private JobInfoMapper jobInfoMapper;

    @Autowired
    private TraineeJobRelMapper traineeJobRelMapper;

    /**
     * 按条件分页查询实习生的岗位信息
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param tName   实习生姓名
     * @param jName   岗位名称
     * @return 实习生的岗位信息
     */
    @Override
    public TraineeJobRelVO queryByCondition(Integer current, Integer size, String tName, String jName) {
        TraineeJobRelVO traineeJobRelVO = new TraineeJobRelVO();

        List<TraineeInfo> traineeInfos = traineeInfoMapper.selectList(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(tName != null && !"".equals(tName),
                                TraineeInfo::getTraineeName, tName)
                        .eq(TraineeInfo::getTraineeStatus, "1"));

        if (traineeInfos.size() == 0) {
            traineeJobRelVO.setCurrent(current);
            traineeJobRelVO.setSize(size);
            traineeJobRelVO.setTotal(0L);
            return traineeJobRelVO;
        }

        List<JobInfo> jobInfos = jobInfoMapper.selectList(
                new LambdaQueryWrapper<JobInfo>()
                        .eq(jName != null && !"".equals(jName),
                                JobInfo::getJName, jName)
                        .eq(JobInfo::getJStatus, "1")
        );

        if (jobInfos.size() == 0) {
            traineeJobRelVO.setCurrent(current);
            traineeJobRelVO.setSize(size);
            traineeJobRelVO.setTotal(0L);
            return traineeJobRelVO;
        }

        ArrayList<Integer> tIds = new ArrayList<>();
        for (TraineeInfo traineeInfo : traineeInfos) {
            tIds.add(traineeInfo.getTraineeId());
        }

        ArrayList<Integer> jIds = new ArrayList<>();
        for (JobInfo jobInfo : jobInfos) {
            jIds.add(jobInfo.getJId());
        }

        IPage<TraineeJobRel> traineeJobRelIPage = traineeJobRelMapper.selectPage(
                new Page<>(current, size),
                new LambdaQueryWrapper<TraineeJobRel>()
                        .in(TraineeJobRel::getTId, tIds)
                        .in(TraineeJobRel::getJId, jIds)
                        .eq(TraineeJobRel::getTjStatus, "1")
        );

        List<TraineeJobRel> traineeJobRels = traineeJobRelIPage.getRecords();

        List<TraineeJobRelDTO> traineeJobRelDTOS = TraineeJobRelConvert
                .INSTANCE.listTJREntity2listTJRDto(traineeJobRels);

        for (TraineeJobRelDTO traineeJobRelDTO : traineeJobRelDTOS) {
            TraineeInfo traineeInfo = traineeInfoMapper.selectById(traineeJobRelDTO.getTId());
            JobInfo jobInfo = jobInfoMapper.selectById(traineeJobRelDTO.getJId());
            traineeJobRelDTO.setTName(traineeInfo.getTraineeName());
            traineeJobRelDTO.setJName(jobInfo.getJName());
        }

        traineeJobRelVO.setCurrent(current);
        traineeJobRelVO.setSize(size);
        traineeJobRelVO.setTotal(traineeJobRelIPage.getTotal());
        traineeJobRelVO.setTraineeJobRelDTOS(traineeJobRelDTOS);

        return traineeJobRelVO;
    }

    /**
     * 根据id查询实习生的岗位信息
     *
     * @param tjId 实习生的岗位信息id
     * @return 实习生的岗位信息
     */
    @Override
    public TraineeJobRelDTO queryById(Integer tjId) {
        TraineeJobRel traineeJobRel = traineeJobRelMapper.selectById(tjId);
        if (traineeJobRel == null) {
            return null;
        }
        TraineeInfo traineeInfo = traineeInfoMapper.selectById(traineeJobRel.getTId());
        JobInfo jobInfo = jobInfoMapper.selectById(traineeJobRel.getJId());
        TraineeJobRelDTO traineeJobRelDTO = TraineeJobRelConvert
                .INSTANCE.TJREntity2TJRDto(traineeJobRel);
        traineeJobRelDTO.setTName(traineeInfo.getTraineeName());
        traineeJobRelDTO.setJName(jobInfo.getJName());
        return traineeJobRelDTO;
    }
}
