package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Conclusion;

public interface IConDeadlineService {

	public boolean addConclusion(Conclusion conclusion);
	
	public List<Conclusion> findConclusionList(int proId);
	
	public Conclusion findConclusionById(Conclusion conclusion);
}
