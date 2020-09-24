package com.zzc.intern.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="TraineeJobRelDTO", description="实习生的岗位信息")
public class TraineeJobRelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生&岗位id
     */
    @ApiModelProperty(value = "实习生&岗位id", name = "tjId", example = "0")
    private Integer tjId;

    /**
     * 实习生编号
     */
    @ApiModelProperty(value = "实习生编号", name = "tId", example = "0")
    private Integer tId;

    /**
     * 岗位编号
     */
    @ApiModelProperty(value = "岗位编号", name = "jId", example = "0")
    private Integer jId;

    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称", name = "jName")
    private String jName;

    /**
     * 实习生姓名
     */
    @ApiModelProperty(value = "实习生姓名", name = "tName")
    private String tName;
}
