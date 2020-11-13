package doTest;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.sql.*;

public class JdbcTest {
    Connection myCon=null;
    PreparedStatement prep=null;
    ResultSet rs=null;

    @Before
    public void before() throws ClassNotFoundException, SQLException {
        System.out.println("before...");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2.获取连接
        myCon=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE"
                ,"SYSTEM"
                ,"123456"
        );
    }
    @After
    public void after() throws SQLException {
        if (rs!=null){
            rs.close();
        }
        prep.close();
        myCon.close();
    }
    //添加数据的方法
    @Test
    public void  insert() throws ClassNotFoundException, SQLException {

        //3.预编译SQL语句
        String sql="insert into car_users values(seq_users.nextval,'user','123456','12345678910',3)";
        //System.out.println("Testing...");
        PreparedStatement prep=myCon.prepareStatement(sql);
        //4.将指令发送到数据库
        int i = prep.executeUpdate();
        System.out.println("受影响的行:"+i);
        //5.关闭连接

    }

    //删除数据的方法

    //查询数据的方法
    @Test
    public void  select() throws ClassNotFoundException, SQLException {

        //3预编译sql
        String sql="select * from car_users";
        PreparedStatement prep=myCon.prepareStatement(sql);
        ResultSet rs =prep.executeQuery();


        //遍及结果集
        while(rs.next()){
            int id=rs.getInt("id");
            String username=rs.getString("username");
            String password=rs.getString("password");
            int role=rs.getInt("role");
            System.out.println(id+" "+username+" "+password+" "+role);
        }
        int i = prep.executeUpdate();
        System.out.println("受影响的行:"+i);

    }
    @Test
    public void  delete() throws SQLException {
        String sql="delete from car_users where username='user'";
        PreparedStatement prep=myCon.prepareStatement(sql);
        int i=prep.executeUpdate();

        System.out.println("影响了..."+i+"行");
    }

    //更新数据的方法
    @Test
    public void update() throws SQLException {
        String username = "Admin";
        String password = "123456";
        int id = 41;
        String  sql = "update car_users set username = ?,password = ? where id =?";
        prep = myCon.prepareStatement(sql);
        prep.setString(1,username);
        prep.setString(2,password);
        prep.setInt(3,id);
        System.out.println(sql);
        int i = prep.executeUpdate();
        System.out.println("修改了"+i+"行数据！");
    }
//    public static void main(String[] args) {
//        JdbcTest jdbcTest = new JdbcTest();
//
//    }
}