package com.zzc.intern.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="ResourceInfoDTO", description="资源管理信息")
public class ResourceInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    private Integer rId;

    /**
     * 电脑型号
     */
    @ApiModelProperty(value = "电脑型号")
    private String rComputer;

    /**
     * GitHub账号
     */
    @ApiModelProperty(value = "GitHub账号")
    private String rGithub;

    /**
     * 实习生姓名
     */
    @ApiModelProperty(value = "实习生姓名")
    private String tName;

}
