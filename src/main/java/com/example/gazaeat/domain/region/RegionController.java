package com.example.gazaeat.domain.region;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("region")
public class RegionController {
    private final RegionRepository regionRepository;

    @PostMapping
    public String save(RegionEntity region){
        regionRepository.save(region);

        return "/";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable Long id, Model model){
        RegionEntity region = regionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("region", region);

        return "/";
    }

    @GetMapping
    public String getAll(Model model){
        List<RegionEntity> regions = regionRepository.findAll();
        model.addAttribute("regions", regions);
        return "/";
    }
}
