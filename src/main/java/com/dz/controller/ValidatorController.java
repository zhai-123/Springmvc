package com.dz.controller;

import com.dz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/form/")
public class ValidatorController {
    @RequestMapping("form")
    public String form(Model model){
        model.addAttribute("user",new User());
        return "validator/form";
    }
    @RequestMapping("save")
    public String save(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "validator/form";
        }
       return "success";
    }

}
