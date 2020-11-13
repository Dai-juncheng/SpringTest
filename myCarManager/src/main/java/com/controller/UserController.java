package com.controller;

import com.dao.UserDao;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.pojo.User;
import com.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Array;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Controller

public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/login")
    public String login(String userName,String password) throws SQLException, ClassNotFoundException {
        int i = userDao.login(userName,password);

        System.out.println(i);
        if (i>=1){
            return "redirect:resources/index.jsp";
        }else {
            return "redirect:login.jsp";
        }
    }

    @RequestMapping("/userList")
    @ResponseBody
    public UserVo userList(int page,int limit) throws Exception {
        //page：当前页          limit：每页显示数据   count：总记录数   
        UserVo userVo = new UserVo();
        userVo.setMsg("");
        List<User> users = userDao.queryAll();
        userVo.setCount(users.size());

        int start =(page-1)*limit;
        int end=page*limit;
        int count=users.size();

        List<User> contentUsers=null;
        if(end>count){
            //算出来的结尾索引 减去 数据总数
            if(end-count==limit){
                contentUsers=users.subList(start-limit,count);
            }else {
                contentUsers=users.subList(start,count);
            }
        }else {
            contentUsers=users.subList(start,end);
        }
        userVo.setData(contentUsers);

        return userVo;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user) throws Exception {
        int i =userDao.insert(user);
        if(i>=1){
            return "insert success";
        }else {
            return " insert fail";
        }

    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(int id ) throws SQLException, ClassNotFoundException {
        int i=userDao.deleteById(id);
        if(i>=1){
            return "delete success";
        }else{
            return "delete fail";
        }

    }

    @RequestMapping("/editUser")
    @ResponseBody
    public String editUser(User user) throws SQLException, ClassNotFoundException {
        int i=userDao.editUser(user);
        if(i>=1){
            return "edit success";
        }else {
            return "edit fail";
        }

    }

    @RequestMapping("/deleteUsers")
    @ResponseBody
    public String deleteUsers(int[] ids) throws SQLException, ClassNotFoundException {
        if(ids==null){
            return "please check which line you want to delete";
        }
        String res="(";
        for (int i=0;i<ids.length;i++){
            if(i==ids.length-1){
                res+=ids[i]+")";
            }else{
                res+=ids[i]+",";
            }
        }
        int i =userDao.deleteUsers(res);
        if(i>=1){
            return "delete success!" ;
        }else {
            return "delete fail!" ;
        }

    }


    @RequestMapping("/getUsers")
    @ResponseBody
    public UserVo getUsers(Integer id,String username,int page,int limit) throws Exception {
        // 没有传id的情况下 id->null
        //在没有传username的情况下 username->""
        //Integer.parseInt(req.getParamter("id"))
        //select * from car_users where id = ?
        //select * from car_users where username = ?
        //select * from car_users where id=? and username=?
        //select * from car_users
        System.out.println(username);
        UserVo userVo = null;
        if (id==null){
            userVo = userDao.getUsersByName(username);
        }else if(username.equals("")){
            userVo = userDao.getUsersById(id);
        }else if (id!=null&&!username.equals("")){
            userVo = userDao.getUsersByNameAndId(username,id);
        }else {
            List<User> users= userDao.queryAll();
            userVo.setCount(users.size());
            //page   limit    start   end   count
            // 2      4         4      8    4
            int start = (page-1)*limit;
            int end = page * limit;
            int count = users.size();
            List<User> contentUsers = null;
            if (end>count){
                //算出来的结尾索引 减去 数据总数 会等于 一页的数据量
                if (end-count==limit){
                    //page--;
                    contentUsers = users.subList(start-limit,count);
                }else {
                    contentUsers = users.subList(start,count);
                }
            }else{
                contentUsers = users.subList(start,end);
            }
            userVo.setData(contentUsers);
        }
        return userVo;
    }

}