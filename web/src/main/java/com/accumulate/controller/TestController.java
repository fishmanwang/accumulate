package com.accumulate.controller;

import com.accumulate.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by Administrator on 2016/7/26.
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/body.html", method = RequestMethod.POST)
    public String testRequestBody(@RequestBody @Valid TestDto dto) {
        System.out.println(dto.toString());
        return "hello";
    }

    /**
     * 测试Controller层统一异常捕获
     * 测试方式，使用chrome控制台
     * var data = JSON.stringify({name:"wang", age:30, inner:{company:"", locate:"chengdu"}});
     * $.ajax({url:"/test/validate.html", type:"POST", contentType:"application/json", data:data, dataType:"json"}, function(json){console.log(json)} );
     * @param dto
     */
    @ResponseBody
    @RequestMapping(value = "/validate.html", method = RequestMethod.POST)
    public void test(@RequestBody @Valid TestDto dto) {
        System.out.println("/login/test.html");
    }


}
