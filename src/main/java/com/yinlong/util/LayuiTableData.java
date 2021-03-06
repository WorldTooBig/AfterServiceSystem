package com.yinlong.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.ProcessRecord;

/**
 * layui table 表格所需数据
 * @author 01270059
 *
 */
public class LayuiTableData {
	
	/**
	 * layui table 表格所需数据
	 * @param code	
	 * @param msg	
	 * @param count	数据总数
	 * @param list	
	 * @throws IOException
	 */
	public static void layuiTableUserList(int code, String msg, int count, List list) throws IOException {
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("code", code);    
		jsonObj.put("msg", msg);    
		jsonObj.put("count", count);    
		jsonObj.put("data",list);    
		
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(jsonObj.toString());
        out.close();
	}
	
	public void test(List<ProcessRecord> prList) {
		boolean isNotifiedExamine1 = false;
		for (ProcessRecord processRecord : prList) {
			switch (processRecord.getProcess().getProId()) {
			case 1:	// 异常反馈单
				ActionContext.getContext().put("feePr", processRecord);
				break;
			case 2:	// 归档处理
				ActionContext.getContext().put("plaPr", processRecord);
				break;
			case 4:	// 考核通报
				ActionContext.getContext().put("notPr", processRecord);
				break;
			case 6: // 科室主任审核
				if(isNotifiedExamine1) {
					if(ActionContext.getContext().get("conEx1") == null) {
						List<ProcessRecord> l = new ArrayList<ProcessRecord>();
						l.add(processRecord);
						ActionContext.getContext().put("conEx1", l);
					} else {
						List<ProcessRecord> l = (List<ProcessRecord>) ActionContext.getContext().get("conEx1");
						l.add(processRecord);
						ActionContext.getContext().put("conEx1", l);
					}
				} else {
					ActionContext.getContext().put("notEx1", processRecord);
					isNotifiedExamine1 = true;
				}
				break;
			case 7: // 部门领导审批
				ActionContext.getContext().put("notEx2", processRecord);
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
	
			default:
				break;
			}
		}
	}
}
