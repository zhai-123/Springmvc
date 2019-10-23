package com.dz.controller;

import com.dz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    /*请求转发*/
    @RequestMapping("/index")
    public String index(){
        System.out.println("index...");
        return "index";
    }
    /*表单传值*/
    @RequestMapping(value = "/index1", method = RequestMethod.POST)//只接受post请求
    public String index1(User user){
        System.out.println("用户名："+user.getUsername());
        System.out.println("密码："+user.getPwd());
        return "success";

    }
    /*重定向 传值*/
    @RequestMapping("/del")
    public String del(){
        System.out.println("del...");
        int pageNo = 1;
        return "redirect:/index2?pageNo="+pageNo;
    }
    @RequestMapping("/index2")
    public String index2( String  pageNo){
        System.out.println("pageNo:"+pageNo);
        return "success";

    }
    /*根据url传值*/
    @RequestMapping("/index3/{pageNo}")
    public String index3(@PathVariable String  pageNo){
        System.out.println("pageNo:"+pageNo);
        return "success";

    }
    /*页面传值*/
    @RequestMapping("/findAll")
    public String findAll(Model model){    //Model带参跳转到相应文件夹下的jsp
        System.out.println("findAll...");
        User user = new User();
        user.setUsername("alex");
        user.setPwd("012");
        user.setId(1);
        model.addAttribute("user",user);
        model.addAttribute("username","fa");
        return "user/userlist";
    }
    @RequestMapping("update")
    public String update(RedirectAttributes redirectAttributes){
       // Flash attributes 的到来就是为了处理这一情况. Flash attributes 为一个请求存储意图为另外一个请求所使用的属性提供了一条途径. Flash attributes 在对请求的重定向生效之前被临时存储（通常是在session)中，并且在重定向之后被立即移除.
        redirectAttributes.addFlashAttribute("msg","修改成功");
        return "redirect:findAll";

    }
    @RequestMapping(value = "/json" ,produces = "application/json;charset=utf-8")
    public @ResponseBody List<User> getJson(){
        User user = new User();
        user.setUsername("Jerry");
        user.setPwd("123");
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        return userList;
    }


}
