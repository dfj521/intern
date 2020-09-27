package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_bank")
@ApiModel(value="TraineeBank", description="实习生的银行卡信息")
public class TraineeBank implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 银行卡名
     */
    @ApiModelProperty(value = "实习生银行卡名")
    private String traineeBankName;

    /**
     * 银行卡号
     */
    @ApiModelProperty(value = "实习生银行卡号")
    private String traineeBankCard;

    /**
     * 实习生id
     */
    @ApiModelProperty(value = "实习生工号")
    private Integer traineeId;

    /**
     * 是否可用（1，可用.0，不可用）
     */
    @ApiModelProperty(value = "是否可用（1，可用.0，不可用）")
    private String traineeBankStatus;


}
