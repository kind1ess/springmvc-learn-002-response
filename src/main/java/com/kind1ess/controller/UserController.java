package com.kind1ess.controller;


import com.kind1ess.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString...");
        //模拟查数据
        User user = new User("张三","123456",26);
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid...");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView...");
        ModelAndView modelAndView = new ModelAndView();
        //把user对象存到modelAndView对象中，也会存到request的域对象中
        modelAndView.addObject("user",new User("李四","364614",34));  //存入对象
        modelAndView.setViewName("success");    //设置跳转页面
        return modelAndView;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String  testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect...");
//        return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping(value = "/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax...");
        System.out.println(user);
        //做相应，假装查询了数据库
        user.setUserName("李四");
        user.setAge(100);
        //做响应
        return user;
    }

}
