package action;



import dao.CarDao;
import dao.UserDao;
import pojo.Car;
import pojo.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllAction extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uri = req.getRequestURI();
        if ("/list.action".equals(uri)) {
            //1.查询数据库，将所有的用户信息查询出来
            try {
                List<Customer> list = userDao.queryAll();
                req.setAttribute("users", list);
                req.getRequestDispatcher("userList.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //2.将存放用户信息的list放到req中

            //3.跳转到用户展示页面
        }
        if ("/car.action".equals(uri)) {
            //1.查询数据库，将所有的用户信息查询出来
            try {
                List<Car> list = CarDao.queryAll();
                req.setAttribute("cars", list);
                req.getRequestDispatcher("carList.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //2.将存放用户信息的list放到req中

            //3.跳转到用户展示页面
        }
        if ("/updatecar.action".equals(uri)) {
            //1.查询数据库，将所有的用户信息查询出来
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                CarDao carDao = new CarDao();
                Car myCar = carDao.findone(id);


                req.setAttribute("car", myCar);
                req.getRequestDispatcher("updatecar.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if ("/doUpcar.action".equals(uri)) {
            //1.查询数据库，将所有的用户信息查询出来
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                String carid = req.getParameter("carid");
                String brand = req.getParameter("brand");
                CarDao carDao = new CarDao();
                carDao.update(id, carid, brand);

                req.getRequestDispatcher("car.action").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        if ("/deletecar.action".equals(uri)) {
            //1.查询数据库，将所有的用户信息查询出来
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                CarDao car = new CarDao();
                car.deleteById(id);
                req.getRequestDispatcher("car.action").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            //2.将存放用户信息的list放到req中

            //3.跳转到用户展示页面
        }
    }
}

