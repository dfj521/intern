package com.zzc.intern.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="TraineeCourseRelDTO", description="实习生的课程信息")
public class TraineeCourseRelDTO {

    /**
     * 实习生工号
     */
    @ApiModelProperty("实习生工号")
    private Integer traineeId;

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
