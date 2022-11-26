package com.example.gazaeat.domain.region;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("region")
public class RegionController {
    private final RegionRepository regionRepository;

    @PostMapping
    public String save(RegionEntity region, MultipartFile img) throws IOException {

        String path = System.getProperty("user.dir") + "/src/main/resources/static/test/";
        String file = UUID.randomUUID() + img.getOriginalFilename();

        //File saveFile = new File(path, uuid.toString());
       // img.transferTo(saveFile);
        Path path2 = Paths.get(path+file);
        Files.copy(img.getInputStream(), path2, StandardCopyOption.REPLACE_EXISTING);
        region.setImageUrl( "test/"+ file);
        regionRepository.save(region);
        return "redirect:/";
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
