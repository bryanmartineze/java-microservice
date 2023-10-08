package com.example.CRUDApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontPage {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}