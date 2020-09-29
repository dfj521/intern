package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.zzc.intern.Convert.TraineeInfoInsertConvert;
import com.zzc.intern.DTO.TraineeInfoAllDTO;
import com.zzc.intern.entity.*;
import com.zzc.intern.mapper.*;
import com.zzc.intern.service.TraineeInfoAllService;
import com.zzc.intern.util.ResponseUtil;
import com.zzc.intern.vo.AssessInfoVO;
import com.zzc.intern.vo.LearnInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
@Transactional
public class TraineeInfoAllServiceImpl implements TraineeInfoAllService {

    @Autowired
    private TraineeInfoAllMapper traineeInfoAllMapper;

    @Autowired
    private TraineeInfoMapper traineeInfoMapper;

    @Autowired
    private TraineeDepartmentRelMapper traineeDepartmentRelMapper;

    @Autowired
    private TraineeJobRelMapper traineeJobRelMapper;

    @Autowired
    private TraineeResourceRelMapper traineeResourceRelMapper;

    @Autowired
    private JobLearnRelMapper jobLearnRelMapper;

    @Autowired
    private LearnInfoMapper learnInfoMapper;

    @Autowired
    private TraineeLearnRelMapper traineeLearnRelMapper;

    @Autowired
    private SubsidyInfoMapper subsidyInfoMapper;

    @Autowired
    private TraineeSubsidyRelMapper traineeSubsidyRelMapper;

    @Autowired
    private TraineeHouseRelMapper traineeHouseRelMapper;

    @Autowired
    private AssessInfoMapper assessInfoMapper;

    /**
     * 查询所有实习生信息
     *
     * @return
     */
    @Override
    public ResponseUtil<List<TraineeInfoAllDTO>> findAll() {
        ResponseUtil<List<TraineeInfoAllDTO>> result = new ResponseUtil<>();
        List<TraineeInfoAllDTO> traineeInfoAllDTOS = new ArrayList<>();
        try {
            traineeInfoAllDTOS = traineeInfoAllMapper.findByCondition(null);
            result.setCode(200);
            result.setMessage("查询成功");
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("查询失败");
        }
        result.setData(traineeInfoAllDTOS);
        return result;
    }

    /**
     * 根据实习生条件查询所有实习生信息
     *
     * @param traineeInfoAllDTO 实习生信息
     * @return
     */
    @Override
    public ResponseUtil<List<TraineeInfoAllDTO>> findByCondition(TraineeInfoAllDTO traineeInfoAllDTO) {
        ResponseUtil<List<TraineeInfoAllDTO>> result = new ResponseUtil<>();
        if (traineeInfoAllDTO == null) {
            result.setCode(300);
            result.setMessage("参数不能为空");
            return result;
        }
        List<TraineeInfoAllDTO> traineeInfoAllDTOS = new ArrayList<>();
        try {
            traineeInfoAllDTOS = traineeInfoAllMapper.findByCondition(traineeInfoAllDTO);
            result.setCode(200);
            result.setMessage("查询成功");
        } catch (Exception e) {
            result.setCode(500);
            result.setMessage("查询失败");
        }
        result.setData(traineeInfoAllDTOS);
        return result;
    }

    /**
     * 添加实习生信息
     *
     * @param traineeInfoAllDTO 实习生信息
     * @return
     */
    @Override
    public ResponseUtil<Integer> addTrainee(TraineeInfoAllDTO traineeInfoAllDTO) {
        ResponseUtil<Integer> result = new ResponseUtil<>();

        //校验参数
        if (traineeInfoAllDTO == null ||
                traineeInfoAllDTO.getTName() == null || "".equals(traineeInfoAllDTO.getTName()) ||
                traineeInfoAllDTO.getTIdCard() == null || "".equals(traineeInfoAllDTO.getTIdCard()) ||
                traineeInfoAllDTO.getTPhone1() == null || "".equals(traineeInfoAllDTO.getTPhone1()) ||
                traineeInfoAllDTO.getTBankNum1() == null || "".equals(traineeInfoAllDTO.getTBankNum1()) ||
                traineeInfoAllDTO.getTAddress() == null || "".equals(traineeInfoAllDTO.getTAddress()) ||
                traineeInfoAllDTO.getTWornningName1() == null || "".equals(traineeInfoAllDTO.getTWornningName1()) ||
                traineeInfoAllDTO.getTWornningRelation1() == null || "".equals(traineeInfoAllDTO.getTWornningRelation1()) ||
                traineeInfoAllDTO.getTWornningNum1() == null || "".equals(traineeInfoAllDTO.getTWornningNum1()) ||
                traineeInfoAllDTO.getTEducation() == null || "".equals(traineeInfoAllDTO.getTEducation()) ||
                traineeInfoAllDTO.getTSchool() == null || "".equals(traineeInfoAllDTO.getTSchool()) ||
                traineeInfoAllDTO.getTFaculty() == null || "".equals(traineeInfoAllDTO.getTFaculty()) ||
                traineeInfoAllDTO.getTMajor() == null || "".equals(traineeInfoAllDTO.getTMajor()) ||
                traineeInfoAllDTO.getTEntryTime() == null || traineeInfoAllDTO.getDId() == null ||
                traineeInfoAllDTO.getJId() == null || traineeInfoAllDTO.getRId() == null ||
                traineeInfoAllDTO.getHId() == null
        ) {
            result.setCode(300);
            result.setMessage("参数不能为空");
            return result;
        }

        //添加实习生基本信息
        TraineeInfo traineeInfo = TraineeInfoInsertConvert.INSTANCE.dto2traineeInfo(traineeInfoAllDTO);
        traineeInfo.setTraineeStatus("1");
        traineeInfoMapper.insert(traineeInfo);

        //添加实习生的部门信息
        traineeInfoAllDTO.setTId(traineeInfo.getTraineeId());
        TraineeDepartmentRel traineeDepartmentRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeDepartmentRel(traineeInfoAllDTO);
        traineeDepartmentRel.setTdStatus("1");
        traineeDepartmentRelMapper.insert(traineeDepartmentRel);

        //添加实习生的岗位信息
        TraineeJobRel traineeJobRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeJobRel(traineeInfoAllDTO);
        traineeJobRel.setTjStatus("1");
        traineeJobRelMapper.insert(traineeJobRel);

        //添加实习生的资源信息
        TraineeResourceRel traineeResourceRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeResourceRel(traineeInfoAllDTO);
        traineeResourceRel.setTrStatus("1");
        traineeResourceRelMapper.insert(traineeResourceRel);

        //添加实习生的学习内容信息
        List<JobLearnRel> jobLearnRels = jobLearnRelMapper.selectList(new LambdaQueryWrapper<JobLearnRel>()
                .eq(JobLearnRel::getJId, traineeInfoAllDTO.getJId()));
        List<Integer> lIds = new ArrayList<>();
        for (JobLearnRel jobLearnRel : jobLearnRels) {
            lIds.add(jobLearnRel.getLId());
        }
        /*LearnInfo learnInfo = learnInfoMapper.selectOne(new LambdaQueryWrapper<LearnInfo>()
                .in(LearnInfo::getLId, lIds)
                .eq(LearnInfo::getLStage, 1));
        TraineeLearnRel traineeLearnRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeLearnRel(traineeInfoAllDTO);
        traineeLearnRel.setLId(learnInfo.getLId());
        traineeLearnRel.setLState(0);
        traineeLearnRel.setTlStatus("1");
        traineeLearnRelMapper.insert(traineeLearnRel);*/

        //添加实习生的补贴信息
        /*SubsidyInfo subsidyInfo = subsidyInfoMapper.selectOne(new LambdaQueryWrapper<SubsidyInfo>()
                .eq(SubsidyInfo::getJId, traineeInfoAllDTO.getJId()));
        TraineeSubsidyRel traineeSubsidyRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeSubsidyRel(traineeInfoAllDTO);
        traineeSubsidyRel.setSId(subsidyInfo.getSId());
        traineeSubsidyRel.setTsStatus("1");
        traineeSubsidyRel.setSCount(0);
        traineeSubsidyRelMapper.insert(traineeSubsidyRel);*/

        //添加实习生的宿舍信息
        TraineeHouseRel traineeHouseRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeHouseRel(traineeInfoAllDTO);
        traineeHouseRel.setThStatus("1");
        int i = traineeHouseRelMapper.insert(traineeHouseRel);

        result.setCode(200);
        result.setMessage("添加成功");
        result.setData(i);
        return result;
    }

    /**
     * 更新实习生信息
     *
     * @param traineeInfoAllDTO 实习生信息
     * @return
     */
    @Override
    public ResponseUtil<Integer> updateTrainee(TraineeInfoAllDTO traineeInfoAllDTO) {
        ResponseUtil<Integer> result = new ResponseUtil<>();

        //校验参数
        if (
                traineeInfoAllDTO == null || traineeInfoAllDTO.getTId() == null ||
                        traineeInfoAllDTO.getTName() == null || "".equals(traineeInfoAllDTO.getTName()) ||
                        traineeInfoAllDTO.getTIdCard() == null || "".equals(traineeInfoAllDTO.getTIdCard()) ||
                        traineeInfoAllDTO.getTPhone1() == null || "".equals(traineeInfoAllDTO.getTPhone1()) ||
                        traineeInfoAllDTO.getTBankNum1() == null || "".equals(traineeInfoAllDTO.getTBankNum1()) ||
                        traineeInfoAllDTO.getTAddress() == null || "".equals(traineeInfoAllDTO.getTAddress()) ||
                        traineeInfoAllDTO.getTWornningName1() == null || "".equals(traineeInfoAllDTO.getTWornningName1()) ||
                        traineeInfoAllDTO.getTWornningRelation1() == null || "".equals(traineeInfoAllDTO.getTWornningRelation1()) ||
                        traineeInfoAllDTO.getTWornningNum1() == null || "".equals(traineeInfoAllDTO.getTWornningNum1()) ||
                        traineeInfoAllDTO.getTEducation() == null || "".equals(traineeInfoAllDTO.getTEducation()) ||
                        traineeInfoAllDTO.getTSchool() == null || "".equals(traineeInfoAllDTO.getTSchool()) ||
                        traineeInfoAllDTO.getTFaculty() == null || "".equals(traineeInfoAllDTO.getTFaculty()) ||
                        traineeInfoAllDTO.getTMajor() == null || "".equals(traineeInfoAllDTO.getTMajor()) ||
                        traineeInfoAllDTO.getTEntryTime() == null || traineeInfoAllDTO.getDId() == null ||
                        traineeInfoAllDTO.getJId() == null || traineeInfoAllDTO.getRId() == null ||
                        traineeInfoAllDTO.getHId() == null
        ) {
            result.setCode(300);
            result.setMessage("参数不能为空");
            return result;
        }

        //更新实习生基本信息
        TraineeInfo traineeInfo = TraineeInfoInsertConvert.INSTANCE.dto2traineeInfo(traineeInfoAllDTO);
        traineeInfoMapper.updateById(traineeInfo);

        //更新实习生的部门信息
        TraineeDepartmentRel traineeDepartmentRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeDepartmentRel(traineeInfoAllDTO);
        traineeDepartmentRelMapper.update(traineeDepartmentRel,
                new LambdaUpdateWrapper<TraineeDepartmentRel>()
                        .eq(TraineeDepartmentRel::getTId, traineeDepartmentRel.getTId()));

        //更新实习生的岗位信息
        TraineeJobRel traineeJobRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeJobRel(traineeInfoAllDTO);
        traineeJobRelMapper.update(traineeJobRel,
                new LambdaUpdateWrapper<TraineeJobRel>()
                        .eq(TraineeJobRel::getTId, traineeJobRel.getTId()));

        //更新实习生的资源信息
        TraineeResourceRel traineeResourceRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeResourceRel(traineeInfoAllDTO);
        traineeResourceRelMapper.update(traineeResourceRel,
                new LambdaUpdateWrapper<TraineeResourceRel>()
                        .eq(TraineeResourceRel::getTId, traineeDepartmentRel.getTId()));

        //更新实习生的学习内容信息
        List<JobLearnRel> jobLearnRels = jobLearnRelMapper.selectList(new LambdaQueryWrapper<JobLearnRel>()
                .eq(JobLearnRel::getJId, traineeInfoAllDTO.getJId()));
        List<Integer> lIds = new ArrayList<>();
        for (JobLearnRel jobLearnRel : jobLearnRels) {
            lIds.add(jobLearnRel.getLId());
        }
        /*LearnInfo learnInfo = learnInfoMapper.selectOne(new LambdaQueryWrapper<LearnInfo>()
                .in(LearnInfo::getLId, lIds)
                .eq(LearnInfo::getLStage, 1));
        TraineeLearnRel traineeLearnRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeLearnRel(traineeInfoAllDTO);
        traineeLearnRel.setLId(learnInfo.getLId());
        traineeLearnRelMapper.update(traineeLearnRel,
                new LambdaUpdateWrapper<TraineeLearnRel>()
                        .eq(TraineeLearnRel::getTId, traineeLearnRel.getTId()));*/

        //更新实习生的补贴信息
        /*SubsidyInfo subsidyInfo = subsidyInfoMapper.selectOne(new LambdaQueryWrapper<SubsidyInfo>()
                .eq(SubsidyInfo::getJId, traineeInfoAllDTO.getJId()));
        TraineeSubsidyRel traineeSubsidyRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeSubsidyRel(traineeInfoAllDTO);
        traineeSubsidyRel.setSId(subsidyInfo.getSId());
        traineeSubsidyRelMapper.update(traineeSubsidyRel,
                new LambdaUpdateWrapper<TraineeSubsidyRel>()
                        .eq(TraineeSubsidyRel::getTId, traineeSubsidyRel.getTId()));*/

        //更新实习生的宿舍信息
        TraineeHouseRel traineeHouseRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeHouseRel(traineeInfoAllDTO);
        int i = traineeHouseRelMapper.update(traineeHouseRel,
                new LambdaUpdateWrapper<TraineeHouseRel>()
                        .eq(TraineeHouseRel::getTId, traineeHouseRel.getTId()));

        result.setCode(200);
        result.setMessage("更新成功");
        result.setData(i);
        return result;
    }

    /**
     * 删除实习生信息
     *
     * @param tId 实习生编号
     * @return
     */
    @Override
    public ResponseUtil<Integer> deleteTrainee(Integer tId) {
        ResponseUtil<Integer> result = new ResponseUtil<>();

        //校验参数
        if (tId == null) {
            result.setCode(300);
            result.setMessage("参数不能为空");
        }

        int i = 0;

        //删除实习生基本信息
        Integer tiCount = traineeInfoMapper.selectCount(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(TraineeInfo::getTraineeId, tId));
        if (tiCount > 0) {
            TraineeInfo traineeInfo = new TraineeInfo();
            traineeInfo.setTraineeStatus("0");
            traineeInfoMapper.update(traineeInfo,
                    new LambdaUpdateWrapper<TraineeInfo>()
                            .eq(TraineeInfo::getTraineeId, tId));
        }

        //删除实习生的部门信息
        Integer tdCount = traineeDepartmentRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeDepartmentRel>()
                        .eq(TraineeDepartmentRel::getTId, tId));
        if (tdCount > 0) {
            TraineeDepartmentRel traineeDepartmentRel = new TraineeDepartmentRel();
            traineeDepartmentRel.setTdStatus("0");
            traineeDepartmentRelMapper.update(traineeDepartmentRel,
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
            traineeJobRelMapper.update(traineeJobRel,
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
            traineeResourceRelMapper.update(traineeResourceRel,
                    new LambdaUpdateWrapper<TraineeResourceRel>()
                            .eq(TraineeResourceRel::getTId, tId));
        }

        //删除实习生的学习内容信息
        Integer tlCount = traineeLearnRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeLearnRel>()
                        .eq(TraineeLearnRel::getTraineeId, tId));
        if (tlCount > 0) {
            TraineeLearnRel traineeLearnRel = new TraineeLearnRel();
            traineeLearnRel.setTraineeLearnStatus("0");
            traineeLearnRelMapper.update(traineeLearnRel,
                    new LambdaUpdateWrapper<TraineeLearnRel>()
                            .eq(TraineeLearnRel::getTraineeId, tId));
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

        result.setCode(200);
        result.setMessage("删除成功");
        result.setData(i);
        return result;
    }

    /**
     * 根据实习生的id查询实习生的学习情况
     *
     * @param tId 实习生编号
     * @return
     */
    @Override
    public ResponseUtil<List<LearnInfoVO>> selectTraineeLearn(Integer tId) {
        ResponseUtil<List<LearnInfoVO>> result = new ResponseUtil<>();
        //查询到学习状态
        List<TraineeLearnRel> traineeLearnRels = traineeLearnRelMapper.selectList(
                new LambdaQueryWrapper<TraineeLearnRel>()
                        .eq(TraineeLearnRel::getTraineeId, tId));

        ArrayList<Integer> list = new ArrayList<>();
        for (TraineeLearnRel traineeLearnRel : traineeLearnRels) {
            list.add(traineeLearnRel.getLearnId());
        }
        //查询到学习阶段和学习内容
        /*List<LearnInfo> learnInfos = learnInfoMapper.selectList(
                new LambdaQueryWrapper<LearnInfo>()
                        .in(LearnInfo::getLId, list));*/

        List<LearnInfoVO> learnInfoVOS = TraineeInfoInsertConvert.INSTANCE.listTLR2listLIVO(traineeLearnRels);

        /*Iterator<LearnInfoVO> learnInfoVOIterator = learnInfoVOS.iterator();
        Iterator<LearnInfo> learnInfoIterator = learnInfos.iterator();
        while (learnInfoVOIterator.hasNext() && learnInfoIterator.hasNext()) {
            LearnInfoVO learnInfoVO = learnInfoVOIterator.next();
            LearnInfo learnInfo = learnInfoIterator.next();
            learnInfoVO.setLElementary(learnInfo.getLElementary());
            learnInfoVO.setLStage(learnInfo.getLStage());
        }*/

        result.setCode(200);
        result.setMessage("查询成功");
        result.setData(learnInfoVOS);
        return result;
    }

    /**
     * 根据实习生的id和学习内容id查询实习生的考核情况
     *
     * @param tId 实习生编号
     * @param lId 学习内容编号
     * @return
     */
    @Override
    public ResponseUtil<List<AssessInfoVO>> selectTraineeAssess(Integer tId, Integer lId) {
        ResponseUtil<List<AssessInfoVO>> result = new ResponseUtil<>();

        List<AssessInfo> assessInfos = assessInfoMapper.selectList(
                new LambdaQueryWrapper<AssessInfo>()
                        .eq(AssessInfo::getTId, tId)
                        .eq(AssessInfo::getLId, lId));

        List<AssessInfoVO> assessInfoVOS = TraineeInfoInsertConvert.INSTANCE.listAI2listAIVO(assessInfos);

        result.setCode(200);
        result.setMessage("查询成功");
        result.setData(assessInfoVOS);
        return result;
    }

}
