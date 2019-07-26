package com.demo.springboot.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//RestController= Controller

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}

//@RestController
//public class HelloController {
//    @RequestMapping("/hello")
//    public String hello(){
//        return "Hello World!";
//    }
//}
