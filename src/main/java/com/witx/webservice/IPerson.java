package com.witx.webservice;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.witx.entity.FirstEntity;

@WebService
public interface IPerson {
	
	public FirstEntity getEntityById(int id);
	
	public List<FirstEntity> getEnititiesByPrice(double price);
	
	public Map<Integer, FirstEntity> getEnitityMap();
	
}
