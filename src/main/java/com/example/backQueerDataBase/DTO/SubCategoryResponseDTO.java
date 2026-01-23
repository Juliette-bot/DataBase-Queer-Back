package com.example.backQueerDataBase.DTO;

import com.example.backQueerDataBase.Entity.Category;
import com.example.backQueerDataBase.Entity.SubCategory;

public record SubCategoryResponseDTO(
        Long id,
        String name,
        Long categoryId,
        String categoryName
) {
    public static SubCategoryResponseDTO fromEntity(SubCategory subCategory){
        return new SubCategoryResponseDTO(
                subCategory.getId(),
                subCategory.getName(),
                subCategory.getCategory().getId(),
                subCategory.getCategory().getName()
        );
    }
}

