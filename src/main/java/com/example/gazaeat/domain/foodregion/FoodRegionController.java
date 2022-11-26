package com.example.gazaeat.domain.foodregion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gazaeat.domain.food.FoodRepository;
import com.example.gazaeat.domain.region.RegionRepository;

import lombok.RequiredArgsConstructor;

@Controller @RequestMapping("region-food")
@RequiredArgsConstructor
public class FoodRegionController {

    final FoodRepository foodRepository;
    final RegionRepository regionRepository;
    final FoodRegionRepository relationRepository;

    @GetMapping("")
    public String getByName(@RequestParam(name = "region") String region, Model model) {
        //model.addAttribute("food", food);

        return "/";
    }

    @PostMapping()
    public String save(String regionName, String foodName)
    {

        try{
            var region = regionRepository.findByName(regionName);
            var food = foodRepository.findByName(foodName);
    
            FoodRegionEntity entity = new FoodRegionEntity();
            entity.setRegion(region);
            entity.setFood(food);

            System.out.println(entity);

            relationRepository.save(entity);

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }

}
