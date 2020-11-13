package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class ResultContriller {
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String get(@PathVariable("id") int id){
        System.out.println("id"+id);
        //获取user
        return "success";
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String update(){
        //更新user
        return "success";
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String add(){
        System.out.println("i am post");
        //添加user
        return "success";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id){
        System.out.println("i am delete"+id);

        //删除user
        return "redirect:/user/redirect";
    }
    @RequestMapping("/redirect")
    public String redirect(){
        System.out.println("i am redirect to success.jsp");
        //添加user
        return "success";
    }
}
