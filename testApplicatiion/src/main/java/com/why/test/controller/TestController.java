package com.why.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/controllers")
    @CrossOrigin
    @ResponseBody
    public List<String> controllers() {
        List<String> controllers = new ArrayList<>();
        controllers.add("orderQuery1");
        controllers.add("orderQuery2");
        controllers.add("orderQuery3");
        controllers.add("orderQuery4");
        return controllers;
    }


    @RequestMapping("/testCase")
    @CrossOrigin
    public List<String> testCase() {
        List<String> controllers = new ArrayList<>();
        controllers.add("orderQuery1");
        controllers.add("orderQuery2");
        controllers.add("orderQuery3");
        controllers.add("orderQuery4");
        return controllers;
    }
}
