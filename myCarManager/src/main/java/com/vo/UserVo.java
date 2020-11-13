package com.vo;


import com.pojo.User;

import java.util.List;

/**
 * @program: myCarManager
 * @Author: Jim Chan
 * @Description:
 * @create: 2020-11-09 11:03
 */
public class UserVo {
    private int code;
    private int count;
    private String msg;
    private List<User> data;

    public UserVo() {
    }

    public UserVo(int code, int count, String msg, List<User> data) {
        this.code = code;
        this.count = count;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
