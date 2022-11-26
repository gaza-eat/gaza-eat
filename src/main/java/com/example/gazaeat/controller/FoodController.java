package com.example.gazaeat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.gazaeat.domain.food.FoodEntity;
import com.example.gazaeat.domain.food.FoodRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("food")
public class FoodController {
    private final FoodRepository foodRepository;

    @PostMapping
    public String save(FoodEntity food) {
        foodRepository.save(food);

        return "redirect:/food";
    }

    @GetMapping("{name}")
    public String getByName(@PathVariable String name, Model model) {
        FoodEntity food = foodRepository.findByName(name);
        model.addAttribute("food", food);

        return "/";
    }
}
