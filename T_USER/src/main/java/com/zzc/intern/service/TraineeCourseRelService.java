package com.zzc.intern.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzc.intern.entity.TraineeCourseRel;
import com.zzc.intern.vo.TraineeCourseRelVO;

/**
 * 实习生信息与课程信息关联表 服务类
 */
public interface TraineeCourseRelService extends IService<TraineeCourseRel> {
    /**
     * 添加实习生的课程信息
     *
     * @param traineeId 实习生编号
     * @param courseId  课程编号
     * @return 是否添加成功
     */
    boolean addTraineeCourse(Integer traineeId, Integer courseId);

    /**
     * 根据实习生id查询课程信息
     *
     * @param traineeId 实习生编号
     * @return 实习生的课程信息
     */
    TraineeCourseRelVO queryTraineeCourse(Integer traineeId);
}
