package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_course_rel")
public class TraineeCourseRel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&课程id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 实习生编号
     */
    private Integer traineeId;

    /**
     * 课程编号
     */
    private Integer courseId;

    /**
     * 实习生&课程状态（0：不存在，1：存在）
     */
    private String traineeCourseStatus;


}
