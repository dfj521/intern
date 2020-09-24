package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.Convert.TraineeDepartmentRelConvert;
import com.zzc.intern.DTO.DepartmentInfoDTO;
import com.zzc.intern.DTO.TraineeDepartmentRelDTO;
import com.zzc.intern.entity.DepartmentInfo;
import com.zzc.intern.entity.TraineeDepartmentRel;
import com.zzc.intern.entity.TraineeInfo;
import com.zzc.intern.mapper.DepartmentInfoMapper;
import com.zzc.intern.mapper.TraineeDepartmentRelMapper;
import com.zzc.intern.mapper.TraineeInfoMapper;
import com.zzc.intern.service.TraineeDepartmentRelService;
import com.zzc.intern.vo.TraineeDepartmentRelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 实习生&部门 服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-09-17
 */
@Slf4j
@Service
@Transactional
public class TraineeDepartmentRelServiceImpl extends ServiceImpl<TraineeDepartmentRelMapper, TraineeDepartmentRel> implements TraineeDepartmentRelService {

    @Autowired
    TraineeDepartmentRelMapper traineeDepartmentRelMapper;

    @Autowired
    TraineeInfoMapper traineeInfoMapper;

    @Autowired
    DepartmentInfoMapper departmentInfoMapper;

    /**
     * 按条件分页查询实习生的部门信息
     *
     * @param current 当前页
     * @param size    每页显示条数
     * @param tName   实习生姓名
     * @param dName   部门名称
     * @return 实习生的部门信息
     */
    @Override
    public TraineeDepartmentRelVO queryByCondition(Integer current, Integer size, String tName, String dName) {
        TraineeDepartmentRelVO traineeDepartmentRelVO = new TraineeDepartmentRelVO();

        List<TraineeInfo> traineeInfos = traineeInfoMapper.selectList(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(tName != null && !"".equals(tName),
                                TraineeInfo::getTName, tName)
                        .eq(TraineeInfo::getTStatus, "1"));

        if (traineeInfos.size() == 0) {
            traineeDepartmentRelVO.setCurrent(current);
            traineeDepartmentRelVO.setSize(size);
            traineeDepartmentRelVO.setTotal(0L);
            return traineeDepartmentRelVO;
        }

        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectList(
                new LambdaQueryWrapper<DepartmentInfo>()
                        .eq(dName != null && !"".equals(dName),
                                DepartmentInfo::getDName, dName)
                        .eq(DepartmentInfo::getDStatus, "1"));

        if (departmentInfos.size() == 0) {
            traineeDepartmentRelVO.setCurrent(current);
            traineeDepartmentRelVO.setSize(size);
            traineeDepartmentRelVO.setTotal(0L);
            return traineeDepartmentRelVO;
        }

        ArrayList<Integer> tIds = new ArrayList<>();
        for (TraineeInfo traineeInfo : traineeInfos) {
            tIds.add(traineeInfo.getTId());
        }

        ArrayList<Integer> dIds = new ArrayList<>();
        for (DepartmentInfo departmentInfo : departmentInfos) {
            dIds.add(departmentInfo.getDId());
        }

        IPage<TraineeDepartmentRel> traineeDepartmentRelIPage = traineeDepartmentRelMapper
                .selectPage(
                        new Page<>(current, size),
                        new LambdaQueryWrapper<TraineeDepartmentRel>()
                                .in(TraineeDepartmentRel::getTId, tIds)
                                .in(TraineeDepartmentRel::getDId, dIds)
                                .eq(TraineeDepartmentRel::getTdStatus, "1")
        );

        List<TraineeDepartmentRel> traineeDepartmentRels = traineeDepartmentRelIPage.getRecords();

        List<TraineeDepartmentRelDTO> traineeDepartmentRelDTOS = TraineeDepartmentRelConvert
                .INSTANCE.listTDREntity2listTDRDto(traineeDepartmentRels);

        for (TraineeDepartmentRelDTO traineeDepartmentRelDTO : traineeDepartmentRelDTOS) {
            TraineeInfo traineeInfo = traineeInfoMapper.selectById(traineeDepartmentRelDTO.getTId());
            DepartmentInfo departmentInfo = departmentInfoMapper.selectById(traineeDepartmentRelDTO.getDId());
            traineeDepartmentRelDTO.setTName(traineeInfo.getTName());
            traineeDepartmentRelDTO.setDName(departmentInfo.getDName());
        }

        traineeDepartmentRelVO.setCurrent(current);
        traineeDepartmentRelVO.setSize(size);
        traineeDepartmentRelVO.setTotal(traineeDepartmentRelIPage.getTotal());
        traineeDepartmentRelVO.setTraineeDepartmentRelDTOS(traineeDepartmentRelDTOS);

        return traineeDepartmentRelVO;
    }

    @Override
    public TraineeDepartmentRelDTO queryById(Integer tdId) {
        TraineeDepartmentRel traineeDepartmentRel = traineeDepartmentRelMapper.selectById(tdId);
        if (traineeDepartmentRel == null) {
            return null;
        }
        TraineeInfo traineeInfo = traineeInfoMapper.selectById(traineeDepartmentRel.getTId());
        DepartmentInfo departmentInfo = departmentInfoMapper.selectById(traineeDepartmentRel.getDId());
        TraineeDepartmentRelDTO traineeDepartmentRelDTO = TraineeDepartmentRelConvert
                .INSTANCE.TDREntity2TDRDto(traineeDepartmentRel);
        traineeDepartmentRelDTO.setTName(traineeInfo.getTName());
        traineeDepartmentRelDTO.setDName(departmentInfo.getDName());
        return traineeDepartmentRelDTO;
    }

    @Override
    public boolean deleteById(Integer tdId) {
        TraineeDepartmentRel traineeDepartmentRel = new TraineeDepartmentRel();
        traineeDepartmentRel.setTdId(tdId);
        traineeDepartmentRel.setTdStatus("0");
        int i = traineeDepartmentRelMapper.updateById(traineeDepartmentRel);
        return i > 0;
    }

}
