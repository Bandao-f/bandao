package com.ccsu.controller;

import com.ccsu.dal.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class TransController {

    /**
     *
     */
    @GetMapping("/reportAlipay")
    public @ResponseBody String handleRequest(@RequestParam String param) {
        System.out.println(param);

        // 处理请求参数
        return "Received parameter: "+param;
    }
}
