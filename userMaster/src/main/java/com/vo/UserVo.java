package com.vo;

import com.pojo.User;

import java.util.List;

public class UserVo {
    int code;
    String msh;
    int count;
    List<User> data;

    public UserVo() {
    }

    public UserVo(int code, String msh, int count, List<User> data) {
        this.code = code;
        this.msh = msh;
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsh() {
        return msh;
    }

    public void setMsh(String msh) {
        this.msh = msh;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
