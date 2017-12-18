package com.lab.controller;

import com.lab.model.Activityrecord;
import com.lab.model.SubmitResult;
import com.lab.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by april on 2017/12/18.
 */

@Controller
@RequestMapping("/ActivityRecorder")
public class ActivityRecorderController
{
    @Autowired
    ActivityService activityService;

    //	新建活动记录
    @RequestMapping(value="/insertyActiviSelective",method= RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public SubmitResult inserssstyActiviSelective(@RequestBody Map<String,Object> args, ModelMap modelMap, HttpServletRequest request) throws ParseException
    {
        Activityrecord activityRecord=new Activityrecord();

        String activityRecordName = (String)args.get("activityRecordName");
        String activityRecordCode = (String)args.get("activityRecordCode");
        String sectionCode = (String)args.get("sectionCode");
        String time =  (String)args.get("date");
        String content = (String)args.get("content");

        System.out.println(args.size());

        Date activityTime = new SimpleDateFormat("yyyy-MM-dd").parse(time);

        activityRecord.setActivityrecordname(activityRecordName);
        activityRecord.setActivityrecordcode(activityRecordCode);
        activityRecord.setSectioncode(sectionCode);
        activityRecord.setPublishtime(activityTime);
        activityRecord.setText(content);

        System.out.printf(activityRecord.toString());

        int i = activityService.insertSelective(activityRecord);

        SubmitResult res = new SubmitResult();
        res.setMsg("添加成功！" + i);
        res.setSuccess(true);

        return res;
    }

    //	新建活动记录
    @RequestMapping(value="/insertActivityRecorder",method= RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public SubmitResult insertActivityRecorder(HttpServletRequest req) throws ParseException
    {
        System.out.printf("lllll");

        Activityrecord activityRecord = new Activityrecord();

        String activityRecordName = req.getParameter("activityRecordName");
        String activityRecordCode = req.getParameter("activityRecordCode");


        System.out.println(activityRecordName + "," + activityRecordCode);


  /*      activityRecord.setActivityrecordname(activityRecordName);
        activityRecord.setActivityrecordcode(activityRecordCode);
        activityRecord.setSectioncode(sectionCode);

        Date activityTime = new SimpleDateFormat("yyyy-MM-dd").parse(time);
        activityRecord.setPublishtime(activityTime);

        activityRecord.setText(content);

        int i = activityService.insertSelective(activityRecord);*/

        SubmitResult res = new SubmitResult();
        res.setMsg("添加成功！" + 1);
        res.setSuccess(true);

        return res;
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public int test(){

        return 1;
    }
}
