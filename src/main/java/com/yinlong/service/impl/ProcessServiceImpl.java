package com.yinlong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IProcessDao;
import com.yinlong.entity.Process;
import com.yinlong.service.IProcessService;

@Service("processService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProcessServiceImpl implements IProcessService {

	@Resource(name = "processDao")
	private IProcessDao processDao;
	
	public void setProcessDao(IProcessDao processDao) {
		this.processDao = processDao;
	}


	/**
	 * 根据ID查询流程节点
	 * @param process
	 * @return
	 */
	public Process findProcessById(Process process) {
		return processDao.findProcessById(process);
	}


}
