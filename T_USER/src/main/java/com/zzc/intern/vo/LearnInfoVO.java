package com.zzc.intern.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="LearnInfoVO", description="实习生的学习情况")
public class LearnInfoVO {

    private Integer tlId;

    /**
     * 实习生id
     */
    @ApiModelProperty(value = "实习生id", example = "0")
    private Integer tId;

    /**
     * 学习内容ID
     */
    @ApiModelProperty(value = "学习内容ID", example = "0")
    private Integer lId;

    /**
     * 学习阶段(1.初级、2.中级、3.高级)
     */
    @ApiModelProperty(value = "学习阶段(1.初级、2.中级、3.高级)", example = "0")
    private Integer lStage;

    /**
     * 学习内容
     */
    @ApiModelProperty("学习内容")
    private String lElementary;

    /**
     * 学习状态（0，进行中，1，已完成）
     */
    @ApiModelProperty("学习状态（0，进行中，1，已完成）")
    private Integer lState;
}
