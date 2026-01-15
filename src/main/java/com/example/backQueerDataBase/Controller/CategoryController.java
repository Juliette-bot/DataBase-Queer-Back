package com.example.backQueerDataBase.Controller;


import com.example.backQueerDataBase.DTO.CategoryResponseDTO;
import com.example.backQueerDataBase.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryResponseDTO> getAllCategory(){
        System.out.println("Controller all Category call");
        return categoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id){
        Optional<CategoryResponseDTO> categoryResponseDTOList = categoryService.getCategoryById(id);
        return categoryResponseDTOList.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
