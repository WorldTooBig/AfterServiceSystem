package com.yinlong.entity;

import java.io.Serializable;

/**
 * 预防纠正措施预防报告
 * @author 01270059
 *
 */
@SuppressWarnings("serial")
public class ExecutiveReport implements Serializable {

//	Correction project
	private int		etrId;					// 
	private String	etrCorrectionProject;	// 措施自查确认项目
	private	String	etrDescription;			// 简要描述
	private	String	etrFileNo;				// 相关文件编号
	public ExecutiveReport() {
		super();
	}
	public ExecutiveReport(int etrId, String etrCorrectionProject, String etrDescription, String etrFileNo) {
		super();
		this.etrId = etrId;
		this.etrCorrectionProject = etrCorrectionProject;
		this.etrDescription = etrDescription;
		this.etrFileNo = etrFileNo;
	}
	public int getEtrId() {
		return etrId;
	}
	public void setEtrId(int etrId) {
		this.etrId = etrId;
	}
	public String getEtrCorrectionProject() {
		return etrCorrectionProject;
	}
	public void setEtrCorrectionProject(String etrCorrectionProject) {
		this.etrCorrectionProject = etrCorrectionProject;
	}
	public String getEtrDescription() {
		return etrDescription;
	}
	public void setEtrDescription(String etrDescription) {
		this.etrDescription = etrDescription;
	}
	public String getEtrFileNo() {
		return etrFileNo;
	}
	public void setEtrFileNo(String etrFileNo) {
		this.etrFileNo = etrFileNo;
	}
	
	
	
}
