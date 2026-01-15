package com.example.backQueerDataBase.Controller;

import com.example.backQueerDataBase.DTO.SubCategoryResponseDTO;
import com.example.backQueerDataBase.Service.SubCategoryService;
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
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @GetMapping("/subCategory")
    public List<SubCategoryResponseDTO> getAllSubCategory(){
        System.out.println("Controller all SubCategory call");
        return subCategoryService.getAllSubCategory();
    }

    @GetMapping("/subCategory/{id}")
    public ResponseEntity<SubCategoryResponseDTO> getCategoryById(@PathVariable Long id){
        Optional<SubCategoryResponseDTO> subCategoryResponseDTOList = subCategoryService.getSubCategoryById(id);
        return subCategoryResponseDTOList.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}