package com.lab.service;
import java.util.List;
import com.lab.model.Activityrecord;

public interface ActivityService {

    int insertSelective(Activityrecord record);
	String deleteByName(String activityrecordname);
    Activityrecord selectByPrimaryKey(String activityrecordcode);
    List<Activityrecord> selectBySectionCode(String sectionCode);
}
