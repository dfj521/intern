package com.zzc.intern.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="TraineeCourseRelVO", description="实习生的课程信息")
public class TraineeCourseRelVO {

    /**
     * 实习生工号
     */
    @ApiModelProperty("实习生工号")
    private Integer traineeId;

    /**
     * 实习生姓名
     */
    @ApiModelProperty("实习生姓名")
    private String traineeName;

    /**
     * 课程编号
     */
    @ApiModelProperty("课程编号")
    private Integer courseId;

    /**
     * 课程名称
     */
    @ApiModelProperty("课程名称")
    private String courseName;
}
