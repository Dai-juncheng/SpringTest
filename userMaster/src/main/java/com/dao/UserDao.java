package com.dao;

import com.pojo.User;
import org.springframework.stereotype.Repository;
import com.utils.Dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {



    public int login(String username, String password) throws SQLException, ClassNotFoundException {
        int i=0;
        Connection con= Dbutil.getCon();
        String sql="select * from car_users where username=? and password=?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setString(1,username);
        prep.setString(2,password);
        System.out.println(username);
        System.out.println(password);

        //System.out.println(sql);
        ResultSet rs=prep.executeQuery();
        if(rs.next()){
            i=1;
        }

        return i;
    }

    public List<User> queryAll() throws SQLException, ClassNotFoundException {
        List<User> list=new ArrayList<>();
        Connection con=Dbutil.getCon();
        String sql="select * from car_users";
        PreparedStatement prep=con.prepareStatement(sql);
        ResultSet rs=prep.executeQuery();
        while(rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setTel(rs.getString("tel"));
            user.setRole(rs.getInt("role"));
            list.add(user);

        }
        return  list;

    }

    public int deleteById(int id) throws Exception {
        int row=0;
        Connection con=Dbutil.getCon();
        String sql="delete  from car_users where id =?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setInt(1,id);
        //executeUpdate适用与 selcet
        row=prep.executeUpdate();
        Dbutil.close(con,prep);
        if (row == 1) {

            return row;
        }
        return row;
    }

    public  User getUserById(int id) throws Exception {

        User user=new User();
        Connection con=Dbutil.getCon();
        String sql="select * from car_users where id =?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setInt(1,id);
        ResultSet rs=prep.executeQuery();
        while(rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setTel(rs.getString("tel"));
            user.setRole(rs.getInt("role"));

        }
        Dbutil.close(con,prep);
        return user;
    }

    public int update(User user) throws Exception {
        Connection con=Dbutil.getCon();
        String sql="update car_users set username=?,password=?,tel=?,role=? where id=?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setString(1,user.getUsername());
        prep.setString(2,user.getPassword());
        prep.setString(3,user.getTel());
        prep.setInt(4,user.getRole());
        prep.setInt(5,user.getId());
        int i =prep.executeUpdate();
        Dbutil.close(con,prep);
        return i;
    }
}
