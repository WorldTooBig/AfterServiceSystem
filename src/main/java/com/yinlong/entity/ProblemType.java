package com.yinlong.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 问题类别表
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_ProblemType")
@SuppressWarnings("serial")
public class ProblemType implements Serializable {
	
	private int		pbtId;
	private String	pbtName;		// 问题类名称
	
	
	public ProblemType() {
		super();
	}
	
	public ProblemType(int pbtId, String pbtName) {
		super();
		this.pbtId = pbtId;
		this.pbtName = pbtName;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ProblemType")   
    @SequenceGenerator(name="SEQ_ProblemType", sequenceName="SEQ_ProblemType",allocationSize = 1) 
	public int getPbtId() {
		return pbtId;
	}
	public void setPbtId(int pbtId) {
		this.pbtId = pbtId;
	}
	public String getPbtName() {
		return pbtName;
	}
	public void setPbtName(String pbtName) {
		this.pbtName = pbtName;
	}
	

}
