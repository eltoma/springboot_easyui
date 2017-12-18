package com.lab.dao;

import java.util.List;
import com.lab.model.Activityrecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ActivityrecordMapper {
    int deleteByPrimaryKey(String activityrecordcode);

    int insert(Activityrecord record);

    int insertSelective(Activityrecord record);

    Activityrecord selectByPrimaryKey(String activityrecordcode);

    int updateByPrimaryKeySelective(Activityrecord record);

    int updateByPrimaryKeyWithBLOBs(Activityrecord record);

    int updateByPrimaryKey(Activityrecord record);
    
    //自定义
    int deleteByName(@Param("activityrecordname") String activityrecordname);
    List<Activityrecord> selectBySectionCode(@Param("sectionCode") String sectionCode);
}