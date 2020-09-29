package com.zzc.intern.DTO;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ApiModel(value="TraineeInfoDTO", description="实习生信息")
public class TraineeInfoDTO {

    /**
     * 实习生工号
     */
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @ApiModelProperty(value = "实习生入职时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime traineeEntryTime;

    /**
     * 实习生修改时间
     */
    @ApiModelProperty(value = "实习生修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime traineeUpdateTime;

    /**
     * 实习生电话
     */
    @ApiModelProperty(value = "实习生电话")
    private String traineePhoneNumber;

    /**
     * 实习生电话2
     */
    @ApiModelProperty(value = "实习生电话2")
    private String traineePhoneNumber2;

    /**
     * 实习生银行卡名
     */
    @ApiModelProperty(value = "实习生银行卡名")
    private String traineeBankName;

    /**
     * 实习生银行卡名2
     */
    @ApiModelProperty(value = "实习生银行卡名2")
    private String traineeBankName2;

    /**
     * 实习生银行卡号
     */
    @ApiModelProperty(value = "实习生银行卡号")
    private String traineeBankCard;

    /**
     * 实习生银行卡号2
     */
    @ApiModelProperty(value = "实习生银行卡号2")
    private String traineeBankCard2;

    /**
     * 实习生紧急联系人姓名
     */
    @ApiModelProperty(value = "实习生紧急联系人姓名")
    private String traineeContactsName;

    /**
     * 实习生紧急联系人姓名2
     */
    @ApiModelProperty(value = "实习生紧急联系人姓名2")
    private String traineeContactsName2;

    /**
     * 实习生与紧急联系人关系
     */
    @ApiModelProperty(value = "实习生与紧急联系人关系")
    private String traineeContactsRelation;

    /**
     * 实习生与紧急联系人关系2
     */
    @ApiModelProperty(value = "实习生与紧急联系人关系2")
    private String traineeContactsRelation2;

    /**
     * 实习生与紧急联系人电话
     */
    @ApiModelProperty(value = "实习生与紧急联系人电话")
    private String traineeContactsPhone;

    /**
     * 实习生与紧急联系人电话2
     */
    @ApiModelProperty(value = "实习生与紧急联系人电话2")
    private String traineeContactsPhone2;

}
