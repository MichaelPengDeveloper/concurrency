package com.demo.concurrency.controller;

import com.demo.concurrency.example.threadLocal.RequestHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Wangpeng on 2018/6/14.
 */
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @ResponseBody
    @RequestMapping("/test")
    public Long test(){
        return RequestHolder.getId();
    }

}
