package com.zzc.intern.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="TraineeHouseRelDTO", description="实习生的宿舍信息")
public class TraineeHouseRelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&宿舍id
     */
    @ApiModelProperty(value = "实习生&宿舍id", name = "thId", example = "0")
    private Integer thId;

    /**
     * 实习生id
     */
    @ApiModelProperty(value = "实习生id", name = "tId", example = "0")
    private Integer tId;

    /**
     * 宿舍id
     */
    @ApiModelProperty(value = "宿舍id", name = "hId", example = "0")
    private Integer hId;

    /**
     * 住宿地址
     */
    @ApiModelProperty(value = "住宿地址", name = "hAddress")
    private String hAddress;

    /**
     * 宿舍人数
     */
    @ApiModelProperty(value = "宿舍人数", name = "hNumber", example = "0")
    private Integer hNumber;

    /**
     * 宿舍描述
     */
    @ApiModelProperty(value = "宿舍描述", name = "hDescribe")
    private String hDescribe;

    /**
     * 宿舍图片
     */
    @ApiModelProperty(value = "宿舍图片", name = "hUrl")
    private String hUrl;

    /**
     * 宿舍管理员
     */
    @ApiModelProperty(value = "宿舍管理员", name = "hAdministrators")
    private String hAdministrators;
}
