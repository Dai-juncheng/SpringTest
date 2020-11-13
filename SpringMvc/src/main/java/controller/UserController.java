package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Customer;
import pojo.User;

@Controller
public class UserController {
    @RequestMapping("/login")
    public String login(){
        System.out.println("logining");
        return "success";
    }


    @RequestMapping("/param")
    public String param1(int id){
        System.out.println(id);
        return "success";
    }
    @RequestMapping("/param2")
    public String param2(String username,String password){
        System.out.println("username"+username);
        System.out.println("password"+password);
       return "success";
    }
    @RequestMapping(value = "/param3",params = {"username","age=100"})
    public String param3(){
        return "success";
    }
    @RequestMapping(value = "/param4",headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String param4(){
        return "success";
    }

    @RequestMapping(value = "/param5")
    public String param5(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping(value = "/param6")
    public String param6(Customer customer){
        System.out.println(customer);
        return "success";
    }

}

