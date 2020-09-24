package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzc.intern.Convert.TraineeInfoConvert;
import com.zzc.intern.DTO.TraineeInfoSaveDTO;
import com.zzc.intern.entity.*;
import com.zzc.intern.mapper.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.service.TraineeInfoService;
import com.zzc.intern.vo.TraineeInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 实习生个人信息 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-15
 */
@Slf4j
@Service
@Transactional
public class TraineeInfoServiceImpl extends ServiceImpl<TraineeInfoMapper, TraineeInfo> implements TraineeInfoService {

    @Autowired
    private TraineeInfoMapper traineeInfoMapper;

    @Autowired
    private TraineeDepartmentRelMapper traineeDepartmentRelMapper;

    @Autowired
    private TraineeJobRelMapper traineeJobRelMapper;

    @Autowired
    private TraineeResourceRelMapper traineeResourceRelMapper;

    @Autowired
    private TraineeLearnRelMapper traineeLearnRelMapper;

    @Autowired
    private TraineeSubsidyRelMapper traineeSubsidyRelMapper;

    @Autowired
    private TraineeHouseRelMapper traineeHouseRelMapper;

    @Autowired
    private AssessInfoMapper assessInfoMapper;

    /**
     * 添加实习生信息
     *
     * @param traineeInfoSaveDTO 实习生对象
     * @return 是否添加成功
     */
    @Override
    public boolean add(TraineeInfoSaveDTO traineeInfoSaveDTO) {

        //校验参数
        String tName = traineeInfoSaveDTO.getTName();
        Integer dId = traineeInfoSaveDTO.getDId();
        Integer jId = traineeInfoSaveDTO.getJId();
        if (tName == null || "".equals(tName) || dId == null || jId == null) {
            return false;
        }

        //添加实习生信息
        TraineeInfo traineeInfo = TraineeInfoConvert.INSTANCE.TISDto2TIEntity(traineeInfoSaveDTO);
        traineeInfo.setTStatus("1");
        traineeInfoMapper.insert(traineeInfo);

        //获取添加的实习生id
        Integer tId = traineeInfo.getTId();

        //添加实习生的部门信息
        TraineeDepartmentRel traineeDepartmentRel = new TraineeDepartmentRel();
        traineeDepartmentRel.setDId(traineeInfoSaveDTO.getDId());
        traineeDepartmentRel.setTId(tId);
        traineeDepartmentRel.setTdStatus("1");
        traineeDepartmentRelMapper.insert(traineeDepartmentRel);

        //添加实习生的岗位信息
        TraineeJobRel traineeJobRel = new TraineeJobRel();
        traineeJobRel.setJId(traineeInfoSaveDTO.getJId());
        traineeJobRel.setTId(tId);
        traineeJobRel.setTjStatus("1");
        int i = traineeJobRelMapper.insert(traineeJobRel);

        //返回是否添加成功
        return i > 0;
    }

    /**
     * 分页查询所有实习生基本信息
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @return 实习生的基本信息
     */
    @Override
    public TraineeInfoVO queryList(Integer current, Integer size) {
        TraineeInfoVO traineeInfoVO = new TraineeInfoVO();
        Page<TraineeInfo> page = new Page<>(current, size);
        traineeInfoMapper.selectPage(page, new LambdaQueryWrapper<TraineeInfo>()
                .eq(TraineeInfo::getTStatus, "1"));
        traineeInfoVO.setCurrent(current);
        traineeInfoVO.setSize(size);
        traineeInfoVO.setTotal(page.getTotal());
        traineeInfoVO.setTraineeInfoList(page.getRecords());
        return traineeInfoVO;
    }

    /**
     * 根据条件查询实习生信息
     *
     * @param tName     实习生姓名
     * @param startTime 开始时间
     * @param endTime   终止时间
     * @return 实习生的基本信息
     */
    @Override
    public TraineeInfoVO queryByCondition(Integer current, Integer size, String tName, LocalDateTime startTime, LocalDateTime endTime) {
        TraineeInfoVO traineeInfoVO = new TraineeInfoVO();
        Page<TraineeInfo> page = new Page<>(current, size);
        traineeInfoMapper.selectPage(page, new LambdaQueryWrapper<TraineeInfo>()
                .eq(tName != null && !"".equals(tName), TraineeInfo::getTName, tName)
                .gt(startTime != null, TraineeInfo::getTEntryTime, startTime)
                .lt(endTime != null, TraineeInfo::getTEntryTime, endTime)
                .eq(TraineeInfo::getTStatus, "1"));
        traineeInfoVO.setCurrent(current);
        traineeInfoVO.setSize(size);
        traineeInfoVO.setTotal(page.getTotal());
        traineeInfoVO.setTraineeInfoList(page.getRecords());
        return traineeInfoVO;
    }

    @Override
    public boolean deleteById(Integer tId) {
        int i = 0;
        //删除实习生基本信息
        Integer tiCount = traineeInfoMapper.selectCount(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(TraineeInfo::getTId, tId));
        if (tiCount > 0) {
            TraineeInfo traineeInfo = new TraineeInfo();
            traineeInfo.setTStatus("0");
            i = traineeInfoMapper.update(traineeInfo,
                    new LambdaUpdateWrapper<TraineeInfo>()
                            .eq(TraineeInfo::getTId, tId));
        }

        //删除实习生的部门信息
        Integer tdCount = traineeDepartmentRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeDepartmentRel>()
                        .eq(TraineeDepartmentRel::getTId, tId));
        if (tdCount > 0) {
            TraineeDepartmentRel traineeDepartmentRel = new TraineeDepartmentRel();
            traineeDepartmentRel.setTdStatus("0");
            i = traineeDepartmentRelMapper.update(traineeDepartmentRel,
                    new LambdaUpdateWrapper<TraineeDepartmentRel>()
                            .eq(TraineeDepartmentRel::getTId, tId));
        }

        //删除实习生的岗位信息
        Integer tjCount = traineeJobRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeJobRel>()
                        .eq(TraineeJobRel::getTId, tId));
        if (tjCount > 0) {
            TraineeJobRel traineeJobRel = new TraineeJobRel();
            traineeJobRel.setTjStatus("0");
            i = traineeJobRelMapper.update(traineeJobRel,
                    new LambdaUpdateWrapper<TraineeJobRel>()
                            .eq(TraineeJobRel::getTId, tId));
        }

        //删除实习生的资源信息
        Integer trCount = traineeResourceRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeResourceRel>()
                        .eq(TraineeResourceRel::getTId, tId));
        if (trCount > 0) {
            TraineeResourceRel traineeResourceRel = new TraineeResourceRel();
            traineeResourceRel.setTrStatus("0");
            i = traineeResourceRelMapper.update(traineeResourceRel,
                    new LambdaUpdateWrapper<TraineeResourceRel>()
                            .eq(TraineeResourceRel::getTId, tId));
        }

        //删除实习生的学习内容信息
        Integer tlCount = traineeLearnRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeLearnRel>()
                        .eq(TraineeLearnRel::getTId, tId));
        if (tlCount > 0) {
            TraineeLearnRel traineeLearnRel = new TraineeLearnRel();
            traineeLearnRel.setTlStatus("0");
            i = traineeLearnRelMapper.update(traineeLearnRel,
                    new LambdaUpdateWrapper<TraineeLearnRel>()
                            .eq(TraineeLearnRel::getTId, tId));
        }

        //删除实习生的补贴信息
        Integer tsCount = traineeSubsidyRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeSubsidyRel>()
                        .eq(TraineeSubsidyRel::getTId, tId));
        if (tsCount > 0) {
            TraineeSubsidyRel traineeSubsidyRel = new TraineeSubsidyRel();
            traineeSubsidyRel.setTsStatus("0");
            i = traineeSubsidyRelMapper.update(traineeSubsidyRel,
                    new LambdaUpdateWrapper<TraineeSubsidyRel>()
                            .eq(TraineeSubsidyRel::getTId, tId));
        }

        //删除实习生的宿舍信息
        Integer thCount = traineeHouseRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeHouseRel>()
                        .eq(TraineeHouseRel::getTId, tId));
        if (thCount > 0) {
            TraineeHouseRel traineeHouseRel = new TraineeHouseRel();
            traineeHouseRel.setThStatus("0");
            i = traineeHouseRelMapper.update(traineeHouseRel,
                    new LambdaUpdateWrapper<TraineeHouseRel>()
                            .eq(TraineeHouseRel::getTId, tId));
        }

        //删除实习生的考核信息
        Integer aiCount = assessInfoMapper.selectCount(
                new LambdaQueryWrapper<AssessInfo>()
                        .eq(AssessInfo::getTId, tId));
        if (aiCount > 0) {
            AssessInfo assessInfo = new AssessInfo();
            assessInfo.setAStatus("0");
            i = assessInfoMapper.update(assessInfo,
                    new LambdaUpdateWrapper<AssessInfo>()
                            .eq(AssessInfo::getTId, tId));
        }

        return i > 0;
    }
}
