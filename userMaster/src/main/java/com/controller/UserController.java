package com.controller;

import com.dao.UserDao;
import com.pojo.User;
import com.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public String login(String username, String password, Map<String,Object> map) throws SQLException, ClassNotFoundException {
        int i = userDao.login(username,password);
        if (i >= 1) {
            List<User> list = userDao.queryAll();
            map.put("list",list);
            return "list";
        }
        else {
            map.put("msg","username or password was wrong");

            return "login";
        }

    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Map<String,Object> map) throws Exception {
        UserDao userDao=new UserDao();
        int row=userDao.deleteById(id);
        if(row>=1){
            List<User> list = userDao.queryAll();
            map.put("list",list);
            return "list";
        }else{
            map.put("msg","delete happend wrong");
            return "list";
        }

    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") int id, Map<String,Object> map) throws Exception {
        User user =userDao.getUserById(id);
        map.put("user",user);
        return "update";

    }

    @RequestMapping(value = "doUpdate",method = RequestMethod.PUT)
    public String doUpdate(User user) throws Exception {
        int i=userDao.update(user);
        if(i>=1){
            System.out.println("update success");
        }
        else {
            System.out.println("update fail");
        }
        return "redirect:/user/redirect";

    }
    @RequestMapping("/redirect")
    public String redirect( Map<String,Object> map) throws SQLException, ClassNotFoundException {
        map.put("list",userDao.queryAll());
        return "list";
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public UserVo showUser() throws SQLException, ClassNotFoundException {
        UserVo userVo=new UserVo();
        userVo.setCode(0);
        userVo.setCount(1000);
        userVo.setData(userDao.queryAll());
        userVo.setMsh("");
        return userVo;
    }



}
