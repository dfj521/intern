package com.zzc.intern.vo;

import com.zzc.intern.DTO.TraineeHouseRelDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="TraineeHouseRelVO", description="实习生的宿舍信息")
public class TraineeHouseRelVO {

    @ApiModelProperty(value = "当前页", name = "current", example = "0")
    private Integer current;

    @ApiModelProperty(value = "每页显示条数", name = "size", example = "0")
    private Integer size;

    @ApiModelProperty(value = "总数", name = "total")
    private Long total;

    @ApiModelProperty(value = "实习生的宿舍信息", name = "traineeHouseRelDTOS")
    private List<TraineeHouseRelDTO> traineeHouseRelDTOS;
}
