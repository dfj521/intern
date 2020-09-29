package com.zzc.intern.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="LearnInfoDTO", description="学习内容信息")
public class LearnInfoDTO {

    /**
     * 学习内容ID
     */
    @ApiModelProperty("学习内容ID")
    private Integer learnId;

    /**
     * 学习内容
     */
    @ApiModelProperty("学习内容")
    private String learnElementary;

    /**
     * 学习阶段(1.初级、2.中级、3.高级)
     */
    @ApiModelProperty("学习阶段(1.初级、2.中级、3.高级)")
    private Integer learnStage;

    /**
     * 学习状态（0，进行中，1，已完成）
     */
    @ApiModelProperty("学习状态（0，进行中，1，已完成）")
    private Integer learnState;

}
