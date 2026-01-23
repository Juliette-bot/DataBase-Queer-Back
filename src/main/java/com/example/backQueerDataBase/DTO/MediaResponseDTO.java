package com.example.backQueerDataBase.DTO;

import com.example.backQueerDataBase.Entity.Media;

public record MediaResponseDTO(
        Long id,
        String type
) {
    public static MediaResponseDTO fromEntity(Media medias){
        return new MediaResponseDTO(
                medias.getId(),
                medias.getType()
        );
    }
}
