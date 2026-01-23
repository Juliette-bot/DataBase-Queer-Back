package com.example.backQueerDataBase.DTO;

import com.example.backQueerDataBase.Entity.Category;

public record SubCategoryRequestDTO(
        Long id,
        String name,
        Category category
) {
}
