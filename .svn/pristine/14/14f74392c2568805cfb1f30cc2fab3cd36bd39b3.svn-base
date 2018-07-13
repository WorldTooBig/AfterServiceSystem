package com.yinlong.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Quas002;
import com.yinlong.service.IQuas002Service;
import com.yinlong.service.impl.Quas002ServiceImpl;

@Controller("quas002Action")
@Scope("prototype")
public class Quas002Action {
	
	@Resource(name = "quas002Service")
	private  IQuas002Service quas002Service;
	
	private Quas002 quas002;
	
	/**
	 * 添加
	 * @return
	 */
	public String addquas002() {
		if (quas002Service.addQuas002(quas002)) {
			
		}
		return "";
	}

	
	public Quas002 getQuas002() {
		return quas002;
	}

	public void setQuas002(Quas002 quas002) {
		this.quas002 = quas002;
	}

	public void setQuas002Service(IQuas002Service quas002Service) {
		this.quas002Service = quas002Service;
	}
	
	
}
																																																																																																																						