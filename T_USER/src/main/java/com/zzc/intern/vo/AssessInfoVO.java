package com.zzc.intern.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="AssessInfoVO", description="实习生的考核情况")
public class AssessInfoVO {

    /**
     * 考核ID
     */
    @ApiModelProperty(value = "考核ID", example = "0")
    private Integer aId;

    /**
     * 考核成绩
     */
    @ApiModelProperty("考核成绩")
    private Double aGrade;

    /**
     * 考核是否通过（1.通过，0.不通过）
     */
    private String aState;

}
