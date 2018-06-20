package com.yinlong.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

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
}
