package com.example.backQueerDataBase.DTO;

import com.example.backQueerDataBase.Entity.Category;

public record CategoryResponseDTO(
        Long id,
        String name
) {
    public static CategoryResponseDTO fromEntity(Category categories) {
        return new CategoryResponseDTO(
                categories.getId(),
                categories.getName()
        );
    }
}
