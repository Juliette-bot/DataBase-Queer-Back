package com.example.backQueerDataBase.DTO.Request;

import com.example.backQueerDataBase.Entity.Category;

public record SubCategoryRequestDTO(
        Long id,
        String name,
        Category category
) {
}
