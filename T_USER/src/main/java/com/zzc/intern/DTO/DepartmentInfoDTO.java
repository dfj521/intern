package com.zzc.intern.DTO;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
@Data
public class DepartmentInfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer dId;

    /**
     * 部门名称
     */
    private String dName;
    /**
     * 岗位名称
     */
    private String jName;
    /**
     * 实习生ID
     */
    private Integer tId;
    /**
     * 学习阶段(1.初级、2.中级、3.高级)
     */
    private Integer lStage;
    /**
     * 考核成绩
     */
    private Double aGrade;
    /**
     * 考核状态（0：不存在，1：存在）
     */
    /**
     * 实习生姓名
     */
    private String tName;
    
    private String aStatus;
    
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getjName() {
		return jName;
	}
	public void setjName(String jName) {
		this.jName = jName;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public Integer getlStage() {
		return lStage;
	}
	public void setlStage(Integer lStage) {
		this.lStage = lStage;
	}
	public Double getaGrade() {
		return aGrade;
	}
	public void setaGrade(Double aGrade) {
		this.aGrade = aGrade;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getaStatus() {
		return aStatus;
	}
	public void setaStatus(String aStatus) {
		this.aStatus = aStatus;
	}
    
}
