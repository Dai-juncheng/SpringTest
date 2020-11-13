package dao;

import pojo.Customer;
import utils.Dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<Customer> queryAll() throws SQLException, ClassNotFoundException {
        List<Customer> list = new ArrayList<>();
        Connection con = Dbutil.getCon();
        String sql = "select * from car_users";
        PreparedStatement prep = con.prepareStatement(sql);
        ResultSet rs = prep.executeQuery();
        while (rs.next()){
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setTel(rs.getString("tel"));
            customer.setRole(rs.getInt("role"));
            list.add(customer);
        }
        return list;
    }

    public int deleteById(int id){

        return 1;
    }
}
