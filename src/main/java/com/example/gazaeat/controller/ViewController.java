package com.example.gazaeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("food-form")
    public String createViewFood() {
        return "create-food";
    }
    @GetMapping("region-form")
    public String createViewRegion() {
        return "create-region";
    }
    @GetMapping("region-food-form")
    public String createViewRegionFood() {
        return "create-region-food";
    }
}
