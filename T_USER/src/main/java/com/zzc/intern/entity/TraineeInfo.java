package com.zzc.intern.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("trainee_info")
@ApiModel(value="TraineeInfo", description="实习生信息")
public class TraineeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生工号
     */
    @TableId(value = "trainee_id", type = IdType.AUTO)
    @ApiModelProperty("实习生工号")
    private Integer traineeId;

    /**
     * 实习生姓名
     */
    @ApiModelProperty("实习生姓名")
    private String traineeName;

    /**
     * 实习生性别
     */
    @ApiModelProperty("实习生性别")
    private String traineeSex;

    /**
     * 实习生年龄
     */
    @ApiModelProperty("实习生年龄")
    private Integer traineeAge;

    /**
     * 实习生出生日期
     */
    @ApiModelProperty("实习生出生日期")
    private LocalDateTime traineeBirthday;

    /**
     * 实习生身份证号
     */
    @ApiModelProperty("实习生身份证号")
    private String traineeIdCard;

    /**
     * 实习生家庭住址
     */
    @ApiModelProperty("实习生家庭住址")
    private String traineeAddress;

    /**
     * 实习生学历
     */
    @ApiModelProperty("实习生学历")
    private String traineeEducation;

    /**
     * 实习生毕业学校
     */
    @ApiModelProperty("实习生毕业学校")
    private String traineeSchool;

    /**
     * 实习生毕业院系
     */
    @ApiModelProperty("实习生毕业院系")
    private String traineeFaculty;

    /**
     * 实习生专业
     */
    @ApiModelProperty("实习生专业")
    private String traineeMajor;

    /**
     * 实习生入职时间
     */
    @ApiModelProperty("实习生入职时间")
    private LocalDateTime traineeEntryTime;

    /**
     * 实习生修改时间
     */
    @ApiModelProperty("实习生修改时间")
    private LocalDateTime traineeUpdateTime;

    /**
     * 是否可用（1，可用.0，不可用）
     */
    @ApiModelProperty("是否可用（1，可用.0，不可用）")
    private String traineeStatus;


}
