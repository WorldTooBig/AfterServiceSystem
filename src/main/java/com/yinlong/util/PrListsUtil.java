package com.yinlong.util;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.Reply;
import com.yinlong.entity.User;

/**
 * 查询反馈单的操作记录
 * @author 01270059
 *
 */
public class PrListsUtil {

	/**
	 * 查询Feedback的所有操作记录
	 * @param list
	 */
	public static void findPrList(List<ProcessRecord> list) {

		for (ProcessRecord processRecord : list) {
			switch (processRecord.getProcess().getProId()) {
			case 1:	// 异常反馈单
				ActionContext.getContext().put("feePr", processRecord);
				break;
			case 2:	// 归档处理
				ActionContext.getContext().put("plaPr", processRecord);
				break;
			case 3:	// 无需处理
				ActionContext.getContext().put("pr3", processRecord);
				break;
			case 4:	// 考核通报
				ActionContext.getContext().put("notPr", processRecord);
				break;
			case 5:	// 限期整改
				ActionContext.getContext().put("pr5", processRecord);
				break;
			case 6: // 科室主任审核
				ActionContext.getContext().put("pr6", processRecord);
				break;
			case 7: // 部门领导审批
				ActionContext.getContext().put("pr7", processRecord);
				break;
			case 9: // 责任单位答复
				ActionContext.getContext().put("repPr", processRecord);
				break;
			case 13: // 责任单位主任审核
				ActionContext.getContext().put("repEx1", processRecord);
				break;
			case 14: // 责任单位领导审批
				ActionContext.getContext().put("repEx2", processRecord);
				break;
			case 15: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx", processRecord);
				break;
			case 10: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx1", processRecord);
				break;
			case 11: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx2", processRecord);
				break;
			case 16: // 确认延期申请
				ActionContext.getContext().put("pr16", processRecord);
				break;
			case 17: // 确认关闭申请
				ActionContext.getContext().put("pr17", processRecord);
				break;
			case 18: // 确认责任单位指派下一责任单位
				ActionContext.getContext().put("pr18", processRecord);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * 查询Feedback的所有操作记录 ， 答复审核刷选该Reply
	 * @param list
	 */
	public static void findPrListOnReply(List<ProcessRecord> list) {
		User user = (User) ActionContext.getContext().getSession().get("user_login");
		for (ProcessRecord processRecord : list) {
			switch (processRecord.getProcess().getProId()) {
			case 1:	// 异常反馈单
				ActionContext.getContext().put("feePr", processRecord);
				break;
			case 2:	// 归档处理
				ActionContext.getContext().put("plaPr", processRecord);
				break;
			case 3:	// 无需处理
				ActionContext.getContext().put("pr3", processRecord);
				break;
			case 4:	// 考核通报
				ActionContext.getContext().put("notPr", processRecord);
				break;
			case 5:	// 限期整改
				ActionContext.getContext().put("pr5", processRecord);
				break;
			case 6: // 科室主任审核
				ActionContext.getContext().put("pr6", processRecord);
				break;
			case 7: // 部门领导审批
				ActionContext.getContext().put("pr7", processRecord);
				break;
			case 9: // 责任单位答复
				ActionContext.getContext().put("repPr", processRecord);
				break;
			case 13: // 责任单位主任审核
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == user.getSection().getDepartment().getDeptId()) {
					ActionContext.getContext().put("repEx1", processRecord);
				}
				break;
			case 14: // 责任单位领导审批
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == user.getSection().getDepartment().getDeptId()) {
					ActionContext.getContext().put("repEx2", processRecord);	
				}
				break;
			case 15: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx", processRecord);
				break;
			case 10: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx1", processRecord);
				break;
			case 11: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx2", processRecord);
				break;
			case 16: // 确认延期申请
				ActionContext.getContext().put("pr16", processRecord);
				break;
			case 17: // 确认关闭申请
				ActionContext.getContext().put("pr17", processRecord);
				break;
			case 18: // 确认责任单位指派下一责任单位
				ActionContext.getContext().put("pr18", processRecord);
				break;

			default:
				break;
			}
		}
	}
	
	/**
	 * 查询Feedback的所有操作记录  在下考核阶段
	 * @param list
	 */
	public static void findPrListOnConclusion(List<ProcessRecord> list) {

		for (ProcessRecord processRecord : list) {
			switch (processRecord.getProcess().getProId()) {
			case 1:	// 异常反馈单
				ActionContext.getContext().put("feePr", processRecord);
				break;
			case 2:	// 归档处理
				ActionContext.getContext().put("plaPr", processRecord);
				break;
			case 3:	// 无需处理
				ActionContext.getContext().put("pr3", processRecord);
				break;
			case 4:	// 考核通报
				ActionContext.getContext().put("notPr", processRecord);
				break;
			case 5:	// 限期整改
				ActionContext.getContext().put("pr5", processRecord);
				break;
			case 6: // 科室主任审核
				ActionContext.getContext().put("pr6", processRecord);
				break;
			case 7: // 部门领导审批
				ActionContext.getContext().put("pr7", processRecord);
				break;
			case 9: // 责任单位答复
				List<ProcessRecord> l3 = new ArrayList<ProcessRecord>();
				if(ActionContext.getContext().get("repPr") == null) {
					l3.add(processRecord);
					ActionContext.getContext().put("repPr", l3);
				} else {
					l3 = (List<ProcessRecord>) ActionContext.getContext().get("repPr");
					l3.add(processRecord);
					ActionContext.getContext().put("repPr", l3);
				}
				break;
			case 13: // 责任单位主任审核
				List<ProcessRecord> l = new ArrayList<ProcessRecord>();
				if(ActionContext.getContext().get("repEx1") == null) {
					l.add(processRecord);
					ActionContext.getContext().put("repEx1", l);
				} else {
					l = (List<ProcessRecord>) ActionContext.getContext().get("repEx1");
					l.add(processRecord);
					ActionContext.getContext().put("repEx1", l);
				}
				break;
			case 14: // 责任单位领导审批
				List<ProcessRecord> l2 = new ArrayList<ProcessRecord>();
				if(ActionContext.getContext().get("repEx2") == null) {
					l2.add(processRecord);
					ActionContext.getContext().put("repEx2", l2);
				} else {
					l2 = (List<ProcessRecord>) ActionContext.getContext().get("repEx2");
					l2.add(processRecord);
					ActionContext.getContext().put("repEx2", l2);
				}
				break;
			case 15: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx", processRecord);
				break;
			case 10: // 审核考核结论
				ActionContext.getContext().put("conEx1", processRecord);
				break;
			case 11: // 审批考核结论
				ActionContext.getContext().put("conEx2", processRecord);
				break;
			case 16: // 确认延期申请
				ActionContext.getContext().put("pr16", processRecord);
				break;
			case 17: // 确认关闭申请
				ActionContext.getContext().put("pr17", processRecord);
				break;
			case 18: // 确认责任单位指派下一责任单位
				ActionContext.getContext().put("pr18", processRecord);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * 查询Feedback的所有操作记录   根据Deadline的Reply
	 * @param list
	 */
	public static void findPrListOnDeadline(List<ProcessRecord> list) {

		User user = (User) ActionContext.getContext().getSession().get("user_login");
		for (ProcessRecord processRecord : list) {
			switch (processRecord.getProcess().getProId()) {
			case 1:	// 异常反馈单
				ActionContext.getContext().put("feePr", processRecord);
				break;
			case 2:	// 归档处理
				ActionContext.getContext().put("plaPr", processRecord);
				break;
			case 3:	// 无需处理
				ActionContext.getContext().put("pr3", processRecord);
				break;
			case 4:	// 考核通报
				ActionContext.getContext().put("notPr", processRecord);
				break;
			case 5:	// 限期整改
				ActionContext.getContext().put("pr5", processRecord);
				break;
			case 6: // 科室主任审核
				ActionContext.getContext().put("pr6", processRecord);
				break;
			case 7: // 部门领导审批
				ActionContext.getContext().put("pr7", processRecord);
				break;
			case 9: // 责任单位答复
				ActionContext.getContext().put("repPr", processRecord);
				break;
			case 13: // 责任单位主任审核
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == user.getSection().getDepartment().getDeptId()) 
					ActionContext.getContext().put("repEx1", processRecord);
				break;
			case 14: // 责任单位领导审批
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == user.getSection().getDepartment().getDeptId()) 
					ActionContext.getContext().put("repEx2", processRecord);
				break;
			case 15: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx", processRecord);
				break;
			case 10: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx1", processRecord);
				break;
			case 11: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx2", processRecord);
				break;
			case 16: // 确认延期申请
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == user.getSection().getDepartment().getDeptId()) 
					ActionContext.getContext().put("pr16", processRecord);
				break;
			case 17: // 确认关闭申请
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == user.getSection().getDepartment().getDeptId()) 
					ActionContext.getContext().put("pr17", processRecord);
				break;
			case 18: // 确认责任单位指派下一责任单位
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == user.getSection().getDepartment().getDeptId()) 
					ActionContext.getContext().put("pr18", processRecord);
				break;

			default:
				break;
			}
		}
	}

	
	public static void findPrListOnDelay(List<ProcessRecord> list, Reply reply) {

		for (ProcessRecord processRecord : list) {
			switch (processRecord.getProcess().getProId()) {
			case 1:	// 异常反馈单
				ActionContext.getContext().put("feePr", processRecord);
				break;
			case 2:	// 归档处理
				ActionContext.getContext().put("plaPr", processRecord);
				break;
			case 3:	// 无需处理
				ActionContext.getContext().put("pr3", processRecord);
				break;
			case 4:	// 考核通报
				ActionContext.getContext().put("notPr", processRecord);
				break;
			case 5:	// 限期整改
				ActionContext.getContext().put("pr5", processRecord);
				break;
			case 6: // 科室主任审核
				if(reply.getRepHandleStep() != 0)
					ActionContext.getContext().put("pr6", processRecord);	
				else 
					ActionContext.getContext().put("pr6d", processRecord);	
				break;
			case 7: // 部门领导审批
				if(processRecord.getFeedback().getProcess().getProId() != 9)
					ActionContext.getContext().put("pr7", processRecord);	
				else 
					ActionContext.getContext().put("pr7d", processRecord);	
				break;
			case 9: // 责任单位答复
				List<ProcessRecord> l3 = new ArrayList<ProcessRecord>();
				if(ActionContext.getContext().get("repPr") == null) {
					l3.add(processRecord);
					ActionContext.getContext().put("repPr", l3);
				} else {
					l3 = (List<ProcessRecord>) ActionContext.getContext().get("repPr");
					l3.add(processRecord);
					ActionContext.getContext().put("repPr", l3);
				}
				break;
			case 10: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx1", processRecord);
				break;
			case 11: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx2", processRecord);
				break;
			case 12: // 质量部确认申请
				ActionContext.getContext().put("pr12", processRecord);
				break;
			case 13: // 责任单位主任审核
				List<ProcessRecord> l = new ArrayList<ProcessRecord>();
				if(ActionContext.getContext().get("repEx1") == null) {
					l.add(processRecord);
					ActionContext.getContext().put("repEx1", l);
				} else {
					l = (List<ProcessRecord>) ActionContext.getContext().get("repEx1");
					l.add(processRecord);
					ActionContext.getContext().put("repEx1", l);
				}
				break;
			case 14: // 责任单位领导审批
				List<ProcessRecord> l2 = new ArrayList<ProcessRecord>();
				if(ActionContext.getContext().get("repEx2") == null) {
					l2.add(processRecord);
					ActionContext.getContext().put("repEx2", l2);
				} else {
					l2 = (List<ProcessRecord>) ActionContext.getContext().get("repEx2");
					l2.add(processRecord);
					ActionContext.getContext().put("repEx2", l2);
				}
				break;
			case 15: // 质量工程师下考核结论
				ActionContext.getContext().put("conEx", processRecord);
				break;
			case 16: // 确认延期申请
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == reply.getDepartment().getDeptId())
					ActionContext.getContext().put("pr16", processRecord);
				break;
			case 17: // 确认关闭申请
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == reply.getDepartment().getDeptId())
					ActionContext.getContext().put("pr17", processRecord);
				break;
			case 18: // 确认责任单位指派下一责任单位
				if(processRecord.getUser().getSection().getDepartment().getDeptId() == reply.getDepartment().getDeptId())
					ActionContext.getContext().put("pr18", processRecord);
				break;

			default:
				break;
			}
		}
	}
	
	
	
	
}
