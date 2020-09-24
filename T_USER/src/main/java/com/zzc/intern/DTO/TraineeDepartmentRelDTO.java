package com.zzc.intern.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="TraineeDepartmentRelDTO", description="实习生的部门信息")
public class TraineeDepartmentRelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&部门id
     */
    @ApiModelProperty(value = "实习生&部门id", name = "tdId")
    private Integer tdId;

    /**
     * 实习生id
     */
    @ApiModelProperty(value = "实习生id", name = "tId")
    private Integer tId;

    /**
     * 实习生姓名
     */
    @ApiModelProperty(value = "实习生姓名", name = "tName")
    private String tName;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id", name = "dId")
    private Integer dId;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称", name = "dName")
    private String dName;

}
