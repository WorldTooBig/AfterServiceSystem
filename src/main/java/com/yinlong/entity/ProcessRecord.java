package com.yinlong.entity;

import java.io.Serializable;

/**
 * 流程记录表
 * 每个单据每走一次流程就在此记录一次
 * id:
 * data: 记录详细时间
 * reason: 操作原因
 * result: 记录操作结果
 * User: 操作人			即登陆人
 * Process: 对应流程表
 * Feedback: 对应单据
 * 
 * 当质量工程师填写单据保存时，对应流程表里的name为质量工程师填写单据，记录result：保存成功or保存失败
 * 质控部领导驳回时，对应流程表里的name质控部领导审批，记录：result==>驳回
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class ProcessRecord implements Serializable {

}
