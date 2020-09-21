package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzc.intern.Convert.TraineeInfoInsertConvert;
import com.zzc.intern.DTO.TraineeInfoAllDTO;
import com.zzc.intern.entity.*;
import com.zzc.intern.mapper.*;
import com.zzc.intern.service.TraineeInfoAllService;
import com.zzc.intern.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private TraineeLearnRelMapper traineeLearnRelMapper;

    @Autowired
    private TraineeHouseRelMapper traineeHouseRelMapper;

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

    @Override
    @Transactional
    public ResponseUtil<Integer> addTrainee(TraineeInfoAllDTO traineeInfoAllDTO) {
        ResponseUtil<Integer> result = new ResponseUtil<>();
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
                traineeInfoAllDTO.getJId() == null || traineeInfoAllDTO.getRId() == null) {
            result.setCode(300);
            result.setMessage("参数不能为空");
            return result;
        }
        TraineeInfo traineeInfo;
        int i;

        traineeInfo = TraineeInfoInsertConvert.INSTANCE.dto2traineeInfo(traineeInfoAllDTO);
        traineeInfoMapper.insert(traineeInfo);

        traineeInfoAllDTO.setTId(traineeInfo.getTId());
        TraineeDepartmentRel traineeDepartmentRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeDepartmentRel(traineeInfoAllDTO);
        traineeDepartmentRelMapper.insert(traineeDepartmentRel);

        TraineeJobRel traineeJobRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeJobRel(traineeInfoAllDTO);
        traineeJobRelMapper.insert(traineeJobRel);

        TraineeResourceRel traineeResourceRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeResourceRel(traineeInfoAllDTO);
        traineeResourceRelMapper.insert(traineeResourceRel);


        JobLearnRel jobLearnRel = jobLearnRelMapper.selectOne(new LambdaQueryWrapper<JobLearnRel>()
                .eq(JobLearnRel::getJId, traineeInfoAllDTO.getJId())
                .eq(JobLearnRel::getLStage, 1));
        TraineeLearnRel traineeLearnRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeLearnRel(traineeInfoAllDTO);
        traineeLearnRel.setLId(jobLearnRel.getLId());
        traineeLearnRelMapper.insert(traineeLearnRel);

        TraineeHouseRel traineeHouseRel = TraineeInfoInsertConvert.INSTANCE.dto2traineeHouseRel(traineeInfoAllDTO);
        i = traineeHouseRelMapper.insert(traineeHouseRel);

        result.setCode(200);
        result.setMessage("添加成功");
        result.setData(i);
        return result;
    }

}
