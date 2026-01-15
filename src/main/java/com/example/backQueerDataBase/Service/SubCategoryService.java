package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.SubCategoryResponseDTO;
import com.example.backQueerDataBase.Entity.SubCategory;
import com.example.backQueerDataBase.Repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;

    public Optional<SubCategoryResponseDTO> getSubCategoryById(Long id){
        return subCategoryRepository.findById(id)
                .map(SubCategoryResponseDTO::fromEntity);
    }

    public List<SubCategoryResponseDTO> getAllSubCategory() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        return subCategories.stream()
                .map(SubCategoryResponseDTO::fromEntity)
                .toList();
    }

    public Optional<SubCategoryResponseDTO> getSubCategoryByName(String name) {
        return subCategoryRepository.findByName(name)
                .map(SubCategoryResponseDTO::fromEntity);
    }
}

