package com.dao;

import com.pojo.User;
import com.utils.Dbutil;
import com.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    public int login(String username,String password) throws SQLException, ClassNotFoundException {
        int i=0;
        Connection  con= Dbutil.getCon();
        String sql="select * from car_users where username=? and password=?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setString(1,username);
        prep.setString(2,password);
        System.out.println(username);
        System.out.println(password);
        ResultSet rs=prep.executeQuery();
        if(rs.next()){
            i=1;
        }

        return i;

    }

    public List<User> queryAll() throws Exception {
        List<User> data = new ArrayList<>();
        Connection con =Dbutil.getCon();
        String sql = "select * from car_users order by id";
        PreparedStatement prep = con.prepareStatement(sql);
        ResultSet rs = prep.executeQuery();
        while (rs.next()){
            User user = new User(rs.getInt("id")
                    ,rs.getString("username")
                    ,rs.getString("password")
                    ,rs.getString("tel")
                    ,rs.getString("role"));

            data.add(user);
        }
        Dbutil.close(con,prep,rs);
        return data;


    }

    public int insert(User user) throws Exception {

        Connection con =Dbutil.getCon();
        String sql="insert into  car_users values(?,?,?,?,?)";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setInt(1,user.getId());
        prep.setString(2,user.getUsername());
        prep.setString(3,user.getPassword());
        prep.setString(4,user.getTel());
        prep.setString(5,user.getRole());
        int i =prep.executeUpdate();
        Dbutil.close(con,prep);
        return i;


    }

    public int deleteById(int id) throws SQLException, ClassNotFoundException {
        Connection con=Dbutil.getCon();
        String sql="delete from car_users where id=?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setInt(1,id);
        int i =prep.executeUpdate();
        return i;
    }

    public int editUser(User user) throws SQLException, ClassNotFoundException {
        Connection con=Dbutil.getCon();
        String sql="update car_users set username=? " +
                ",password=?,tel=?, role=? where id =?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setString(1,user.getUsername());
        prep.setString(2,user.getPassword());
        prep.setString(3,user.getTel());
        prep.setString(4,user.getRole());
        prep.setInt(5,user.getId());
        int i =prep.executeUpdate();
        return i;


    }

    public int deleteUsers(String res) throws SQLException, ClassNotFoundException {
        Connection con=Dbutil.getCon();
        String sql="delete from car_users where id in "+res;
        PreparedStatement prep=con.prepareStatement(sql);
        int i=prep.executeUpdate();
        System.out.println(sql);
        return i;
    }

    public UserVo getUsersByName(String username) throws SQLException, ClassNotFoundException {

        UserVo userVo=new UserVo();
        List<User> data =new ArrayList<>();
        Connection con=Dbutil.getCon();
        String sql="select * from car_users where username like ?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setString(1,"%"+username+"%");
        ResultSet rs=prep.executeQuery();
        while (rs.next()){
            User user = new User(rs.getInt("id")
                    ,rs.getString("username")
                    ,rs.getString("password")
                    ,rs.getString("tel")
                    ,rs.getString("role"));

            data.add(user);

        }
        userVo.setMsg("");
        userVo.setCount(data.size());
        userVo.setCode(0);
        userVo.setData(data);
        return userVo;
    }

    public UserVo getUsersById(int id) throws SQLException, ClassNotFoundException {
        UserVo userVo=new UserVo();
        List<User> data =new ArrayList<>();
        Connection con=Dbutil.getCon();
        String sql="select * from car_users where id like ?";
        PreparedStatement prep=con.prepareStatement(sql);
        prep.setInt(1, id);
        ResultSet rs=prep.executeQuery();
        while (rs.next()){
            User user = new User(rs.getInt("id")
                    ,rs.getString("username")
                    ,rs.getString("password")
                    ,rs.getString("tel")
                    ,rs.getString("role"));

            data.add(user);

        }
        userVo.setMsg("");
        userVo.setCount(data.size());
        userVo.setCode(0);
        userVo.setData(data);
        return userVo;
    }

    public UserVo getUsersByNameAndId(String username, Integer id) throws SQLException, ClassNotFoundException {
        UserVo userVo = new UserVo();
        List<User> data = new ArrayList<>();
        Connection con = Dbutil.getCon();
        String sql = "select * from car_users " +
                "where username like ? and id like ?";
        PreparedStatement prep = con.prepareStatement(sql);
        prep.setString(1,"%"+username+"%");
        prep.setString(2,"%"+id+"%");
        ResultSet rs = prep.executeQuery();
        while (rs.next()){
            User user = new User(rs.getInt("id")
                    ,rs.getString("username")
                    ,rs.getString("password")
                    ,rs.getString("tel")
                    ,rs.getString("role"));
            data.add(user);

        }
        userVo.setMsg("");
        userVo.setCount(data.size());
        userVo.setCode(0);
        userVo.setData(data);
        return userVo;
    }
}
