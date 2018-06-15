package com.yinlong.dao;

import com.yinlong.entity.Process;

public interface IProcessDao {

	/**
	 * 根据ID查询流程节点信息
	 * @param process
	 * @return
	 */
	public Process findProcessById(Process process);
}
