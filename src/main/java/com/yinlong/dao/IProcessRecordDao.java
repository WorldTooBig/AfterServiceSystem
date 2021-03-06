package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Feedback;
import com.yinlong.entity.ProcessRecord;

public interface IProcessRecordDao {

	/**
	 * 添加ProcessRecor
	 * @param processRecord
	 * @return
	 */
	public boolean addProcessRecord(ProcessRecord processRecord);
	
	/**
	 * 根据映射的Feedback的ID查询所有相关的ProcessRecord
	 * @param feedback
	 * @return
	 */
	public List<ProcessRecord> findProcessRecordListByFeedbackId(String hql);
}
