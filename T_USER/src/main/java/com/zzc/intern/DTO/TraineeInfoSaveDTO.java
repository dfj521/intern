package com.zzc.intern.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value="TraineeInfoSaveDTO", description="添加实习生信息")
public class TraineeInfoSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实习生姓名
     */
    @ApiModelProperty(value = "实习生姓名", name = "tName", required = true)
    private String tName;

    /**
     * 实习生性别
     */
    @ApiModelProperty(value = "实习生性别", name = "tSex")
    private String tSex;

    /**
     * 实习生年龄
     */
    @ApiModelProperty(value = "实习生年龄",name = "tAge", example = "0")
    private Integer tAge;

    /**
     * 实习生出生日期
     */
    @ApiModelProperty("实习生出生日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime tBirthday;

    /**
     * 实习生身份证号
     */
    @ApiModelProperty("实习生身份证号")
    private String tIdCard;

    /**
     * 实习生手机号1
     */
    @ApiModelProperty("实习生手机号1")
    private String tPhone1;

    /**
     * 实习生手机号2
     */
    @ApiModelProperty("实习生手机号2")
    private String tPhone2;

    /**
     * 实习生银行卡号1
     */
    @ApiModelProperty("实习生银行卡号1")
    private String tBankNum1;

    /**
     * 实习生银行卡号2
     */
    @ApiModelProperty("实习生银行卡号2")
    private String tBankNum2;

    /**
     * 实习生家庭住址
     */
    @ApiModelProperty("实习生家庭住址")
    private String tAddress;

    /**
     * 实习生紧急联系人1电话
     */
    @ApiModelProperty("实习生紧急联系人1电话")
    private String tWornningNum1;

    /**
     * 实习生紧急联系人1关系
     */
    @ApiModelProperty("实习生紧急联系人1关系")
    private String tWornningRelation1;

    /**
     * 实习生紧急联系人1姓名
     */
    @ApiModelProperty("实习生紧急联系人1姓名")
    private String tWornningName1;

    /**
     * 实习生紧急联系人2电话
     */
    @ApiModelProperty("实习生紧急联系人2电话")
    private String tWornningNum2;

    /**
     * 实习生紧急联系人2关系
     */
    @ApiModelProperty("实习生紧急联系人2关系")
    private String tWornningRelation2;

    /**
     * 实习生紧急联系人2姓名
     */
    @ApiModelProperty("实习生紧急联系人2姓名")
    private String tWornningName2;

    /**
     * 实习生学历
     */
    @ApiModelProperty("实习生学历")
    private String tEducation;

    /**
     * 实习生毕业学校
     */
    @ApiModelProperty("实习生毕业学校")
    private String tSchool;

    /**
     * 实习生毕业院系
     */
    @ApiModelProperty("实习生毕业院系")
    private String tFaculty;

    /**
     * 实习生专业
     */
    @ApiModelProperty("实习生专业")
    private String tMajor;

    /**
     * 实习生入职时间
     */
    @ApiModelProperty("实习生入职时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime tEntryTime;

    /**
     * 实习生修改时间
     */
    @ApiModelProperty("实习生修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime tUpdateTime;

    /**
     * 部门编号
     */
    @ApiModelProperty(value = "部门编号", required = true, example = "0")
    private Integer dId;

    /**
     * 岗位编号
     */
    @ApiModelProperty(value = "岗位编号", required = true, example = "0")
    private Integer jId;
}
