package com.lab.model;

import java.util.Date;

public class Activityrecord {
    private String activityrecordcode;

    private String sectioncode;

    private Integer userid;

    private String activityrecordname;

    private Date publishtime;

    private Date lastmodefiedtime;

    private Boolean isdeleted;

    private String text;

    public String getActivityrecordcode() {
        return activityrecordcode;
    }

    public void setActivityrecordcode(String activityrecordcode) {
        this.activityrecordcode = activityrecordcode == null ? null : activityrecordcode.trim();
    }

    public String getSectioncode() {
        return sectioncode;
    }

    public void setSectioncode(String sectioncode) {
        this.sectioncode = sectioncode == null ? null : sectioncode.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getActivityrecordname() {
        return activityrecordname;
    }

    public void setActivityrecordname(String activityrecordname) {
        this.activityrecordname = activityrecordname == null ? null : activityrecordname.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Date getLastmodefiedtime() {
        return lastmodefiedtime;
    }

    public void setLastmodefiedtime(Date lastmodefiedtime) {
        this.lastmodefiedtime = lastmodefiedtime;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    @Override
    public String toString()
    {
        return "Activityrecord{" + "activityrecordcode='" + activityrecordcode + '\'' + ", sectioncode='" + sectioncode + '\'' + ", userid=" + userid + ", activityrecordname='" + activityrecordname + '\'' + ", publishtime=" + publishtime + ", lastmodefiedtime=" + lastmodefiedtime + ", isdeleted=" + isdeleted + ", text='" + text + '\'' + '}';
    }
}