package com.yinlong.dao.impl;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IProcessDao;
import com.yinlong.entity.Process;

@Repository("processDao")
public class ProcessDaoImpl extends BaseDao implements IProcessDao {

	/**
	 * 根据id查询流程节点
	 */
	public Process findProcessById(Process process) {
		try {
			return getSession().get(Process.class, process.getProId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
