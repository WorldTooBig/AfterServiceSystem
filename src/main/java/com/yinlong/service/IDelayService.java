package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Reply;
import com.yinlong.entity.RequestDelay;

public interface IDelayService {

	public boolean addDelay(RequestDelay delay);
	
	public RequestDelay findDelayById(RequestDelay delay);
	
	public List<RequestDelay> findDelayList(int repHandleStep);
}
