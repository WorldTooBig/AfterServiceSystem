package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Conclusion;

public interface IConDeadlineDao {

	public boolean addConclusion(Conclusion conclusion);

	public List<Conclusion> findConclusion(String hql);
	
	public Conclusion findConclusionById(Conclusion conclusion);
}
