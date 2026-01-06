package com.example.backQueerDataBase.DTO;

import com.example.backQueerDataBase.Entity.SubCategory;

public record SubCategoryResponseDTO(
        Long id,
        String name
) {
    public  static   SubCategoryResponseDTO fromEntity(SubCategory subCategories){
        return new SubCategoryResponseDTO(
                subCategories.getId(),
                subCategories.getName()
        );
    }
}
