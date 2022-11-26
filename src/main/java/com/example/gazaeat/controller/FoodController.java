package com.example.gazaeat.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.gazaeat.domain.food.FoodEntity;
import com.example.gazaeat.domain.food.FoodRepository;
import com.example.gazaeat.domain.foodregion.FoodRegionEntity;
import com.example.gazaeat.domain.foodregion.FoodRegionRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("food")
public class FoodController {
    private final FoodRepository foodRepository;
    private final FoodRegionRepository relationRepository;
    
    @GetMapping("/search/{food}/{location}") // /food/search/음식명/몇번째 지역
    public String searchByName(@PathVariable String food, @PathVariable Integer location, Model model)
    {
        var foodNo = foodRepository.findByName(food).getFoodNo();
        List<FoodRegionEntity> entity = relationRepository.findByFoodName(foodNo);

        model.addAttribute("", "");
        model.addAttribute("", "");
        
        return "/location-list";
    }

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
