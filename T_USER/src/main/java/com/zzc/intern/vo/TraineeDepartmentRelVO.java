package com.zzc.intern.vo;

import com.zzc.intern.DTO.TraineeDepartmentRelDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="TraineeDepartmentRelVO", description="实习生的部门信息")
public class TraineeDepartmentRelVO {

    @ApiModelProperty(value = "当前页", name = "current", example = "0")
    private Integer current;

    @ApiModelProperty(value = "每页显示条数", name = "size", example = "0")
    private Integer size;

    @ApiModelProperty(value = "总数", name = "total")
    private Long total;

    @ApiModelProperty(value = "实习生的部门信息", name = "traineeDepartmentRelDTOS")
    private List<TraineeDepartmentRelDTO> traineeDepartmentRelDTOS;
}
