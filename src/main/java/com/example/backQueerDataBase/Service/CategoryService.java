package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.CategoryResponseDTO;
import com.example.backQueerDataBase.DTO.MediaResponseDTO;
import com.example.backQueerDataBase.Entity.Category;
import com.example.backQueerDataBase.Entity.Media;
import com.example.backQueerDataBase.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<CategoryResponseDTO> getCategoryById(Long id){
        return categoryRepository.findById(id)
                .map(CategoryResponseDTO::fromEntity);
    }

    public List<CategoryResponseDTO> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(CategoryResponseDTO::fromEntity)
                .toList();
    }

    public Optional<CategoryResponseDTO> getCategoryByName(String name) {
        return categoryRepository.findByName(name)
                .map(CategoryResponseDTO::fromEntity);
    }


}
