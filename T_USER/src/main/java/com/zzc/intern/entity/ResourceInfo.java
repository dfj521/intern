package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("resource_info")
@ApiModel("ResourceInfo")
public class ResourceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    @ApiModelProperty("资源ID")
    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer rId;

    /**
     * 电脑型号
     */
    @ApiModelProperty("电脑型号")
    private String rComputer;

    /**
     * GitHub账号
     */
    @ApiModelProperty("GitHub账号")
    private String rGithub;


}
