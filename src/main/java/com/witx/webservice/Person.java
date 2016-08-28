package com.witx.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.witx.entity.FirstEntity;

@Component("getPerson")
@WebService
public class Person implements IPerson {

	public FirstEntity getEntityById(int id) {
		
		return new FirstEntity(id, "小张", 40, 20000.59);
	}

	public List<FirstEntity> getEnititiesByPrice(double price) {
		
		List<FirstEntity> firstEntities = new ArrayList<FirstEntity>();
		
		firstEntities.add(new FirstEntity(1, "小张", 40, price+1));
		firstEntities.add(new FirstEntity(2, "小王", 20, price+2));
		firstEntities.add(new FirstEntity(3, "小明", 30, price+3));
		firstEntities.add(new FirstEntity(4, "小宋", 23, price+4));
		return firstEntities;
	}

	public Map<Integer, FirstEntity> getEnitityMap() {
		
		Map<Integer, FirstEntity> map = new HashMap<Integer, FirstEntity>();
		map.put(1, new FirstEntity(1, "m小张", 40, 111.23));
		map.put(2, new FirstEntity(2, "m小王", 20,213.2));
		map.put(3, new FirstEntity(3, "m小明", 30, 324532.5));
		map.put(4, new FirstEntity(4, "m小宋", 33, 54323.98));
		
		return map;
	}

}
