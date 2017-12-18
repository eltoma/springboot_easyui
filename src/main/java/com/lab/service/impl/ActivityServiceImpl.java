package com.lab.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.lab.dao.ActivityrecordMapper;
import com.lab.model.Activityrecord;
import com.lab.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	ActivityrecordMapper activityMapper;

	public String deleteByName(String activityrecordname){
		int name=activityMapper.deleteByName(activityrecordname);
		return activityrecordname;
	}

	public int insertSelective(Activityrecord record) {
		int i=activityMapper.insertSelective(record);
		return i;
	}
	
  public Activityrecord selectByPrimaryKey(String activityrecordcode) {
	  Activityrecord activityrecord=new Activityrecord();
	  activityrecord=activityMapper.selectByPrimaryKey(activityrecordcode);
	  return activityrecord; 
  }
  public List<Activityrecord> selectBySectionCode(String sectionCode) {
	  List<Activityrecord> activityrecord=new ArrayList<>();
	  activityrecord=activityMapper.selectBySectionCode(sectionCode);
	  return activityrecord;
  }
}
