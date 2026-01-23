package com.example.backQueerDataBase.DTO.Respons;

import com.example.backQueerDataBase.Entity.Category;

public record CategoryResponseDTO(
        Long id,
        String name,
        Long mediaId

) {
    public static CategoryResponseDTO fromEntity(Category categories) {
        return new CategoryResponseDTO(
                categories.getId(),
                categories.getName(),
                categories.getMedia().getId()
        );
    }
}
