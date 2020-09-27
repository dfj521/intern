package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("course_info")
public class CourseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 岗位编号
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    /**
     * 岗位名称
     */
    private String courseName;

    /**
     * 岗位状态（0：不存在，1：存在）
     */
    private String courseStatus;


}
