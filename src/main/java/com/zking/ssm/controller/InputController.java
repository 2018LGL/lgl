package com.zking.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 专门用于页面跳转的Controller
 **/
@Controller
@RequestMapping("/input")
public class InputController {

    public InputController() {
        super();
    }

    @RequestMapping("/{page}")
    public String to(@PathVariable String page) {
        return page;
    }

    @RequestMapping("/{dir}/{page}")
    public String to(@PathVariable String dir, @PathVariable String page) {
        String path = dir + "/" + page;
        return path;
    }
}