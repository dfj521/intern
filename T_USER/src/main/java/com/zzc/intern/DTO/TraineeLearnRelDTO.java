package com.zzc.intern.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="TraineeLearnRelDTO", description="实习生的学习内容信息")
public class TraineeLearnRelDTO {

    /**
     * 实习生工号
     */
    @ApiModelProperty("实习生工号")
    private Integer traineeId;

    @ApiModelProperty("实习生的学习内容id")
    private List<Integer> learnIds;
}
