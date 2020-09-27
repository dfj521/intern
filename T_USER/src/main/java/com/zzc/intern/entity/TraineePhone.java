package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_phone")
@ApiModel(value="TraineePhone", description="实习生的电话信息")
public class TraineePhone implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 实习生id
     */
    @ApiModelProperty("实习生工号")
    private Integer traineeId;

    /**
     * 电话
     */
    @ApiModelProperty("实习生电话")
    private String traineePhoneNumber;

    /**
     * 是否可用（1，可用.0，不可用）
     */
    @ApiModelProperty("是否可用（1，可用.0，不可用）")
    private String traineePhoneStatus;


}
