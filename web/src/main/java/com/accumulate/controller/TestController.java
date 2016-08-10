package com.accumulate.controller;

import com.accumulate.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
