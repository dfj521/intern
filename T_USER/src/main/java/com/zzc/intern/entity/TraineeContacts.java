package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("trainee_contacts")
@ApiModel(value="TraineeContacts", description="实习生的紧急联系人信息")
public class TraineeContacts implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 紧急联系人姓名
     */
    @ApiModelProperty(value = "实习生紧急联系人姓名")
    private String traineeContactsName;

    /**
     * 紧急联系人关系
     */
    @ApiModelProperty(value = "实习生与紧急联系人关系")
    private String traineeContactsRelation;

    /**
     * 紧急联系人电话
     */
    @ApiModelProperty(value = "实习生与紧急联系人电话")
    private String traineeContactsPhone;

    /**
     * 实习生id
     */
    @ApiModelProperty(value = "实习生工号")
    private Integer traineeId;

    /**
     * 是否可用（1，可用.0，不可用）
     */
    @ApiModelProperty(value = "是否可用（1，可用.0，不可用）")
    private String traineeContactsStatus;


}
