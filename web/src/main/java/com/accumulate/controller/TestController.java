package com.accumulate.controller;

import com.accumulate.dto.TestDto;
import org.hibernate.validator.constraints.NotBlank;
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
        System.out.println(dto.toString());
    }

    /**
     * 测试方法
     * var data = {name:"wang", age:30, "inner.company":"uec", "inner.locate":"chengdu"}; 注意inner对象的传值方式。
     * $.ajax({url:"/test/validate2.html", type:"GET", data:data, dataType:"json"}, function(json){console.log(json)} );
     * @param dto
     */
    @ResponseBody
    @RequestMapping(value = "/validate2.html", method = RequestMethod.GET)
    public void validate2(@Valid TestDto dto) {
        System.out.println(dto.toString());
    }

    // 无效，证明@Valid只对POJO对象有用。
//    @ResponseBody
//    @RequestMapping(value = "/validate3.html", method = RequestMethod.GET)
//    public void validate3(@Valid @NotBlank String name) {
//        System.out.println(name);
//    }


}
