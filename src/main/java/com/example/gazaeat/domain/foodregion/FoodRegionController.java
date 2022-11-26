package com.example.gazaeat.domain.foodregion;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FoodRegionController {

    @GetMapping("")
    public String getByName(@RequestParam(name = "region") String region, Model model) {
        //model.addAttribute("food", food);

        return "/";
    }
}
