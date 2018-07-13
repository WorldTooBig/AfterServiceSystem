package com.yinlong.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.ProblemType;
import com.yinlong.service.IProblemTypeService;

@Controller("problemTypeAction")
@Scope("prototype")
public class ProblemTypeAction {

	@Resource(name = "problemTypeService")
	private IProblemTypeService problemTypeService;
	
	private List<ProblemType> problemTypeList;
	
	/**
	 * 查询所有ProblemType
	 * @return
	 */
	public String findProblemTypeList() {
		problemTypeList = problemTypeService.findProblemTypeList();
		return "findProblemTypeList";
	}
	

	public List<ProblemType> getProblemTypeList() {
		return problemTypeList;
	}

	public void setProblemTypeList(List<ProblemType> problemTypeList) {
		this.problemTypeList = problemTypeList;
	}

	public void setProblemTypeService(IProblemTypeService problemTypeService) {
		this.problemTypeService = problemTypeService;
	}
	
	
}
