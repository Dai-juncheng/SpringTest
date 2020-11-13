package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@SessionAttributes(value = "msg3")
public class ResponseController {
    @RequestMapping("/responseTest1")
    public ModelAndView responseTest1(){
        ModelAndView mv=new ModelAndView("success");
        mv.addObject("msg","hello world");
        return  mv;
    }

    @RequestMapping("/responseTest2")
    public String responseTest2(Map<String,Object> map){
       map.put("msg2","Hello JJU");
       map.put("msg3","Hello SCEEN");
       return "success";
    }
}
