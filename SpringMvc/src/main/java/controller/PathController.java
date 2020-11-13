package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
    *一级目录
    **堆积目录
    ?后面字符数量,优先级更高

 */


@Controller
//@RequestMapping("/user")
public class PathController {
    @RequestMapping("/*")
    public String pathTest1(){
        System.out.println("i ma pathtest1");
        return "success";
    }
    @RequestMapping("/**")
    public String pathTest2(){
        System.out.println("匹配多级目录");
        return "success";
    }

    @RequestMapping("/createUser/?")
    public String pathTest3(){
        System.out.println("i am pathtest3");
        return "success";
    }

    @RequestMapping("/?")
    public String pathTest4(){
        System.out.println("i am pathtest4");
        return "success";
    }
}
