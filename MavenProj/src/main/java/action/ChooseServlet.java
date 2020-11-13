package action;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import pojo.Car;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseServlet extends HttpServlet {

    static ArrayList<User> list = new ArrayList<>();
    static ArrayList<Car> carList = new ArrayList<>();

    static {
        list.add(new User(1, "admin", "admin"));
        list.add(new User(2, "jju", "123"));
        list.add(new User(3, "seecen", "123"));

        carList.add(new Car(1,"A12341","Passed"));
        carList.add(new Car(2,"A12342","Audi"));
        carList.add(new Car(3,"A12343","Cramy"));
        carList.add(new Car(4,"A12344","Honda"));
        carList.add(new Car(5,"A12345","Bmw"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uri = req.getRequestURI();//得到请求路径的uri

        if (uri.equals("/register.do")) {
//            System.out.println(uri);
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(username);
            System.out.println(password);
            //是否有重名
            Boolean flag = false;
            //判断是否重名
            for (User user : list) {
                if (user.getUsername().equals(username)) {
                    flag = true;
                }

            }
            if (flag) {
                req.setAttribute("msg", "The Username is already to use");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            } else {
                //成功
                list.add(new User(list.size(), username, password));
                resp.sendRedirect("login.jsp");
            }

        }
        if (uri.equals("/login.do")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User myUser=null;
            boolean isLogin=false;
            for (User user:list) {
                if(user.getUsername().equals(username)&&user.getPassword().equals(password)){ isLogin=true;
                myUser=user;

                }
            }




            if(isLogin){
                HttpSession session=req.getSession();
                session.setAttribute("user",myUser);
                req.setAttribute("carList",carList);
               //登录成功
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else {
                req.setAttribute("msg","Username or Password is wrong");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        }
        if (uri.equals("/delete.do")) {
            int id=Integer.parseInt(req.getParameter("id"));
            Car myCar=null;
            for (Car car:carList) {
                if(car.getId()==id){
                    myCar=car;

                }
            }
            carList.remove(myCar);
            req.setAttribute("carList",carList);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

        if (uri.equals("/update.do")) {
            int id=Integer.parseInt(req.getParameter("id"));

            Car myCar=null;
            for (Car car:carList) {
                if(car.getId()==id){
                    myCar=car;
                }
            }
            req.setAttribute("car",myCar);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        } else if (uri.equals("/doUpdate.do")) {

            int id=Integer.parseInt(req.getParameter("id"));
            String newCarNumber=req.getParameter("carNumber");
            String newType=req.getParameter("type");
            Car myCar=null;
            for (Car car :carList) {
                if(car.getId()==id){
                    myCar=car;
                }
            }
            myCar.setCarid(newCarNumber);
            myCar.setType(newType);
            req.setAttribute("carList",carList);
            req.getRequestDispatcher("index.jsp").forward(req,resp);


        }
    }
}


