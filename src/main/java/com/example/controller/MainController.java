package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Seryang on 2016. 10. 30..
 */
@Controller
public class MainController {

    @RequestMapping(value="")
    public String main(Model model) {
        return "index";
    }
}
