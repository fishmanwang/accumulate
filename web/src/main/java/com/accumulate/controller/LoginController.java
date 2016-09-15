package com.accumulate.controller;

import com.accumulate.dto.TestDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Administrator on 2016/7/26.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String doLogin(String name, String password, RedirectAttributes redirectAttributes) {
        try {
            System.out.println(name + " : " + password);
            SecurityUtils.getSubject().login(new UsernamePasswordToken(name, password));


            return "hello";
        } catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("error", "用户名密码错误");
            return "redirect:/login.html";
        }
    }

}
