package com.lab.model;

/**
 * Created by elotoma on 2017/12/1.
 * 提交类接口的返回结构
 */
public class SubmitResult {
    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
