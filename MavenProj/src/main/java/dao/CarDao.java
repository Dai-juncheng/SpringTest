package dao;

import pojo.Car;
import utils.Dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {


    public static List<Car> queryAll() throws SQLException, ClassNotFoundException {
        List<Car> list = new ArrayList<>();
        Connection con = Dbutil.getCon();
        String sql = "select * from car ";
        PreparedStatement prep = con.prepareStatement(sql);
        ResultSet rs = prep.executeQuery();
        while (rs.next()){
            Car car = new Car();
            car.setId(rs.getInt("id"));
            car.setCarid(rs.getString("carid"));
            car.setType(rs.getString("brand"));

            list.add(car);
        }
        return list;
    }

    public void deleteById(int id) throws SQLException, ClassNotFoundException {
        Connection con = Dbutil.getCon();
        String sql = "DELETE FROM car WHERE id = ?";
        PreparedStatement prep = con.prepareStatement(sql);
        prep.setInt(1,id);
        int i=prep.executeUpdate();

        System.out.println("影响了..."+i+"行");

        prep.close();
        con.commit();































    }

    public Car findone(int id) throws SQLException, ClassNotFoundException {

        Connection con = Dbutil.getCon();
        String sql = "select * from car where id =?";
        PreparedStatement prep = con.prepareStatement(sql);
        prep.setInt(1,id);
        ResultSet rs=prep.executeQuery();
        while (rs.next()){
            Car car=new Car();
            car.setId(rs.getInt("id"));
            car.setCarid(rs.getString("carid"));
            car.setType(rs.getString("brand"));
            return car;
        }
        return null;
   }

   public void update(int id,String carid, String brand) throws SQLException, ClassNotFoundException {

       Connection con = Dbutil.getCon();
       String sql = "update car set carid = ?,brand = ? where id =?";
       PreparedStatement prep = con.prepareStatement(sql);
       System.out.println(sql);
       prep.setString(1,carid);
       prep.setString(2,brand);
       prep.setInt(3,id);
       int i=prep.executeUpdate();

       System.out.println("影响了..."+i+"行");

       prep.close();
       con.commit();
   }



}