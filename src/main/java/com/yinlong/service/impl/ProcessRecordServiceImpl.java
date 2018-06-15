package com.yinlong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IProcessRecordDao;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.service.IProcessRecordService;

@Service("processRecordService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProcessRecordServiceImpl implements IProcessRecordService {

	@Resource(name = "processRecordDao")
	private IProcessRecordDao processRecordDao;
	
	public void setProcessRecordDao(IProcessRecordDao processRecordDao) {
		this.processRecordDao = processRecordDao;
	}

	/**
	 * 添加ProcessRecord
	 * @param processRecord
	 * @return
	 */
	public boolean addProcessRecord(ProcessRecord processRecord) {
		
		return processRecordDao.addProcessRecord(processRecord);
	}

}
