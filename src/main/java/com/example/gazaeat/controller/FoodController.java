package com.example.gazaeat.controller;

import com.example.gazaeat.domain.food.FoodEntity;
import com.example.gazaeat.domain.food.FoodRepository;
import com.example.gazaeat.domain.foodregion.FoodRegionEntity;
import com.example.gazaeat.domain.foodregion.FoodRegionRepository;
import com.example.gazaeat.domain.region.RegionEntity;
import com.example.gazaeat.domain.region.RegionRepository;
import com.example.gazaeat.domain.user.UserEntity;
import com.example.gazaeat.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("food")
public class FoodController {
    private final FoodRepository foodRepository;
    private final FoodRegionRepository relationRepository;
    private final RegionRepository regionRepository;
    private final UserRepository userRepository;

    
    @PostMapping("search") // /food/search/음식명/몇번째 지역
    public String searchByName(String food,
                               @RequestParam(name = "location", required = false) Integer location,
                               Model model)
    {
        try{
            if(location == null) {
                location = 0;
            }
            System.out.println(food);
            // 음식
            FoodEntity foodEntity = foodRepository.findByName(food);
            List<FoodRegionEntity> relationListByFoodNo = relationRepository.findByFoodNo(foodEntity.getFoodNo());

            // 그 음식의 지역 리스트
            List<RegionEntity> regionList = new ArrayList<>();
            for(var e : relationListByFoodNo)
            {
                regionList.add(e.getRegion());
            }
            
            // 지역
            var regionEntity = regionList.get(location);
            List<FoodRegionEntity> relListByRegionNo = relationRepository.findByRegionNo(regionEntity.getId());

            List<FoodEntity> foodList = new ArrayList<>();
            for(var e : relListByRegionNo)
            {
                foodList.add(e.getFood());
            }

            model.addAttribute("food", foodEntity);
            model.addAttribute("regionList", regionList);

            model.addAttribute("region", regionEntity);
            model.addAttribute("foodList", foodList);

            return "location-list";

        }catch(Exception e)
        {
            e.printStackTrace();

            return "redirect:/";
        }

    }

    @GetMapping("{food}/{location}") // /food/search/음식명/몇번째 지역
    public String searchByName2(@PathVariable String food,
                                @PathVariable Integer location,
                               Model model)
    {
        try{
            if(location == null) {
                location = 0;
            }

            // 음식
            FoodEntity foodEntity = foodRepository.findByName(food);
            System.out.println(food);
            List<FoodRegionEntity> relationListByFoodNo = relationRepository.findByFoodNo(foodEntity.getFoodNo());

            // 그 음식의 지역 리스트
            List<RegionEntity> regionList = new ArrayList<>();
            for(var e : relationListByFoodNo)
            {
                regionList.add(e.getRegion());
            }

            // 지역
            var regionEntity = regionList.get(location);
            List<FoodRegionEntity> relListByRegionNo = relationRepository.findByRegionNo(regionEntity.getId());

            List<FoodEntity> foodList = new ArrayList<>();
            for(var e : relListByRegionNo)
            {
                foodList.add(e.getFood());
            }

            model.addAttribute("food", foodEntity);
            model.addAttribute("regionList", regionList);

            model.addAttribute("region", regionEntity);
            model.addAttribute("foodList", foodList);

            return "location-list";

        }catch(Exception e)
        {


            return "redirect:/";
        }

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

    @GetMapping("/test")
    @ResponseBody
    public String test()
    {
            UserEntity user = new UserEntity(1L);
            user.setAccountId("더미");
            user.setPassword("비밀번호");
            userRepository.save(user);

            //  음식
            FoodEntity fe = new FoodEntity();
            fe.setName("불고기");
            fe.setRegister(new UserEntity(1L));
            fe.setDescription("마시써요!! 마시써!!");
            foodRepository.save(fe);
        
            fe = new FoodEntity();
            fe.setName("회");
            fe.setRegister(new UserEntity(1L));
            fe.setDescription("쐬주 ㄱ");
            foodRepository.save(fe);

            fe = new FoodEntity();
            fe.setName("비빔밥");
            fe.setRegister(new UserEntity(1L));
            fe.setDescription("ㅁㄴㅇㄹ");
            foodRepository.save(fe);

            fe = new FoodEntity();
            fe.setName("매운탕");
            fe.setRegister(new UserEntity(1L));
            fe.setDescription("ㅁㄴㅇㄹ");
            foodRepository.save(fe);

            fe = new FoodEntity();
            fe.setName("김치볶음밥");
            fe.setRegister(new UserEntity(1L));
            fe.setDescription("ㅁㄴㅇㄹ");
            foodRepository.save(fe);
            
        
            // 지역
            RegionEntity re = new RegionEntity();
            re.setName("전남 전주");
            re.setDescription("전남으로 놀러오슈~");
            re.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fkr.hotels.com%2Fgo%2Fsouth-korea%2Fkr-best-things-to-do-jeonju&psig=AOvVaw0dfJNsscRK8EqnA7u1HJzc&ust=1669524058373000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLCS4vSDy_sCFQAAAAAdAAAAABAE");
            regionRepository.save(re);

            re = new RegionEntity();
            re.setName("경상 경기");
            re.setDescription("역사의 도시");
            re.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fkr.hotels.com%2Fgo%2Fsouth-korea%2Fkr-best-things-to-do-jeonju&psig=AOvVaw0dfJNsscRK8EqnA7u1HJzc&ust=1669524058373000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLCS4vSDy_sCFQAAAAAdAAAAABAE");
            regionRepository.save(re);

            re = new RegionEntity();
            re.setName("전북 나주");
            re.setDescription("나주는 그릇");
            re.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fkr.hotels.com%2Fgo%2Fsouth-korea%2Fkr-best-things-to-do-jeonju&psig=AOvVaw0dfJNsscRK8EqnA7u1HJzc&ust=1669524058373000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLCS4vSDy_sCFQAAAAAdAAAAABAE");
            regionRepository.save(re);

            re = new RegionEntity();
            re.setName("충북 충주");
            re.setDescription("충주 충주 충주 충주");
            re.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fkr.hotels.com%2Fgo%2Fsouth-korea%2Fkr-best-things-to-do-jeonju&psig=AOvVaw0dfJNsscRK8EqnA7u1HJzc&ust=1669524058373000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLCS4vSDy_sCFQAAAAAdAAAAABAE");
            regionRepository.save(re);


            // 지역-음식
            FoodRegionEntity fre = new FoodRegionEntity();
            fre.setFood(new FoodEntity(2L));
            fre.setRegion(new RegionEntity(2));
            relationRepository.save(fre);

            fre = new FoodRegionEntity();
            fre.setFood(new FoodEntity(2L));
            fre.setRegion(new RegionEntity(3));
            relationRepository.save(fre);

            fre = new FoodRegionEntity();
            fre.setFood(new FoodEntity(2L));
            fre.setRegion(new RegionEntity(4));
            relationRepository.save(fre);

        
        return "success";
    }


}
