package com.zzc.intern.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzc.intern.entity.CourseInfo;
import com.zzc.intern.entity.TraineeCourseRel;
import com.zzc.intern.entity.TraineeInfo;
import com.zzc.intern.mapper.CourseInfoMapper;
import com.zzc.intern.mapper.TraineeCourseRelMapper;
import com.zzc.intern.mapper.TraineeInfoMapper;
import com.zzc.intern.service.TraineeCourseRelService;
import com.zzc.intern.vo.TraineeCourseRelVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 实习生信息与课程信息关联表 服务实现类
 */
@Slf4j
@Service
@Transactional
public class TraineeCourseRelServiceImpl extends ServiceImpl<TraineeCourseRelMapper, TraineeCourseRel> implements TraineeCourseRelService {

    @Autowired
    private TraineeInfoMapper traineeInfoMapper;

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Autowired
    private TraineeCourseRelMapper traineeCourseRelMapper;

    /**
     * 添加实习生的课程信息
     *
     * @param traineeId 实习生编号
     * @param courseId  课程编号
     * @return 是否添加成功
     */
    @Override
    public boolean addTraineeCourse(Integer traineeId, Integer courseId) {

        //校验参数
        if (traineeId == null || courseId == null) {
            return false;
        }

        //是否有这个实习生
        Integer tiCount = traineeInfoMapper.selectCount(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(TraineeInfo::getTraineeId, traineeId)
                        .eq(TraineeInfo::getTraineeStatus, "1"));
        if (tiCount == 0) {
            return false;
        }

        //是否有这个课程
        Integer ciCount = courseInfoMapper.selectCount(
                new LambdaQueryWrapper<CourseInfo>()
                        .eq(CourseInfo::getCourseId, courseId)
                        .eq(CourseInfo::getCourseStatus, "1"));
        if (ciCount == 0) {
            return false;
        }

        //实习生是否有这个课程
        Integer tcrCount = traineeCourseRelMapper.selectCount(
                new LambdaQueryWrapper<TraineeCourseRel>()
                        .eq(TraineeCourseRel::getTraineeId, traineeId)
                        .eq(TraineeCourseRel::getCourseId, courseId));
        if (tcrCount > 0) {
            TraineeCourseRel traineeCourseRel = new TraineeCourseRel();
            traineeCourseRel.setTraineeCourseStatus("1");
            int i = traineeCourseRelMapper.insert(traineeCourseRel);
            return i > 0;
        }

        //添加实习生的课程信息
        TraineeCourseRel traineeCourseRel = new TraineeCourseRel();
        traineeCourseRel.setTraineeId(traineeId);
        traineeCourseRel.setCourseId(courseId);
        traineeCourseRel.setTraineeCourseStatus("1");
        int i = traineeCourseRelMapper.insert(traineeCourseRel);

        //返回是否添加成功
        return i > 0;
    }

    @Override
    public TraineeCourseRelVO queryTraineeCourse(Integer traineeId) {

        TraineeCourseRelVO traineeCourseRelVO = new TraineeCourseRelVO();

        //校验参数
        if (traineeId == null) {
            return null;
        }

        //是否有这个实习生
        TraineeInfo traineeInfo = traineeInfoMapper.selectOne(
                new LambdaQueryWrapper<TraineeInfo>()
                        .eq(TraineeInfo::getTraineeId, traineeId)
                        .eq(TraineeInfo::getTraineeStatus, "1"));
        if (traineeInfo == null) {
            return null;
        }

        traineeCourseRelVO.setTraineeId(traineeId);
        traineeCourseRelVO.setTraineeName(traineeInfo.getTraineeName());

        //查询实习生的课程信息
        TraineeCourseRel traineeCourseRel = traineeCourseRelMapper.selectOne(
                new LambdaQueryWrapper<TraineeCourseRel>()
                        .eq(TraineeCourseRel::getTraineeId, traineeId)
                        .eq(TraineeCourseRel::getTraineeCourseStatus, "1"));
        Integer courseId = traineeCourseRel.getCourseId();
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);

        traineeCourseRelVO.setCourseId(courseInfo.getCourseId());
        traineeCourseRelVO.setCourseName(courseInfo.getCourseName());

        return traineeCourseRelVO;
    }
}
