package com.zzc.intern.vo;

import com.zzc.intern.DTO.LearnInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="TraineeLearnRelVO", description="实习生的学习内容信息")
public class TraineeLearnRelVO {

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

    @ApiModelProperty("实习生的学习内容")
    private List<LearnInfoDTO> learnInfoDTOS;

}
