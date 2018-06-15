package com.yinlong.dao.impl;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IProcessRecordDao;
import com.yinlong.entity.ProcessRecord;

@Repository("processRecordDao")
public class ProcessRecordDaoImpl extends BaseDao implements IProcessRecordDao {

	/**
	 * 添加ProcessRecor
	 * @param processRecord
	 * @return
	 */
	public boolean addProcessRecord(ProcessRecord processRecord) {
		try {
			getSession().saveOrUpdate(processRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
