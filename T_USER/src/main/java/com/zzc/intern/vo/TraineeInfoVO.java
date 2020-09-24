package com.zzc.intern.vo;

import com.zzc.intern.entity.TraineeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="TraineeInfoVO", description="实习生的基本信息")
public class TraineeInfoVO {

    @ApiModelProperty(value = "当前页", name = "current", example = "0")
    private Integer current;

    @ApiModelProperty(value = "每页显示条数", name = "size", example = "0")
    private Integer size;

    @ApiModelProperty(value = "总数", name = "total")
    private Long total;

    @ApiModelProperty(value = "实习生的基本信息", name = "traineeInfoList")
    private List<TraineeInfo> traineeInfoList;
}
