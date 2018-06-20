package com.yinlong.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Feedback;
import com.yinlong.entity.Notified;
import com.yinlong.entity.PlaceFile;
import com.yinlong.entity.Process;
import com.yinlong.service.INotifiedService;
import com.yinlong.service.IPlaceFileService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;
import com.yinlong.util.NextProcess;

@Controller("notifiedAction")
@Scope("prototype")
public class NotifiedAction {

	@Resource(name = "notifiedService")
	private INotifiedService notifiedService;
	@Resource(name = "placeFileService")
	private IPlaceFileService placeFileService;
	
	private Notified notified;
	private Feedback feedback;
	private PlaceFile placeFile;
	private Process process;
	
	private List<Notified> notifiedList;
	
	/**
	 * 保存
	 * @return
	 */
	public String addNotified() {
		placeFile = placeFileService.findPlaceFileById(placeFile);	// 查询所有的PlaceFile
		feedback = placeFile.getFeedback();							// 获取该考核通报相关的反馈单
		notifiedService.addNotified(notified);						// 保存该考核通报
		AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "考核通报填写成功");	// 保存此次操作
		NextProcess.nextProcess(feedback, process);					// 改变流程节点
		return "addNotified";
	}
	
	/**
	 * 查询所有Notified
	 * @throws IOException
	 */
	public void findNotifiedList() throws IOException {
		notifiedList = notifiedService.findNotifiedList();
		LayuiTableData.layuiTableUserList(0, null, notifiedList.size(), notifiedList);
	}
	
	
	
	
	
	
	public Notified getNotified() {
		return notified;
	}
	public void setNotified(Notified notified) {
		this.notified = notified;
	}
	public List<Notified> getNotifiedList() {
		return notifiedList;
	}
	public void setNotifiedList(List<Notified> notifiedList) {
		this.notifiedList = notifiedList;
	}
	public void setNotifiedService(INotifiedService notifiedService) {
		this.notifiedService = notifiedService;
	}
	public PlaceFile getPlaceFile() {
		return placeFile;
	}
	public void setPlaceFile(PlaceFile placeFile) {
		this.placeFile = placeFile;
	}
	
	
	
	
}
