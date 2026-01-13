package com.example.backQueerDataBase.DTO;

import com.example.backQueerDataBase.Entity.Resource;

public record ResourceResponseDTO(
        Long id,
        String name,
        String description,
        String url,
        String image_url,
        String creator,
        int release_year,
        int duration_minutes,
        String platform,
        Long sub_category_id,
        Long category_id,
        Long media) {


    public static ResourceResponseDTO fromEntity(Resource ressources) {
        return new ResourceResponseDTO(

                ressources.getId(),
                ressources.getName(),
                ressources.getDescription(),
                ressources.getUrl(),
                ressources.getImage_url(),
                ressources.getCreator(),
                ressources.getRelease_year(),
                ressources.getDuration_minutes(),
                ressources.getPlatform(),
                ressources.getSubCategory().getId(),
                ressources.getCategory().getId(),
                ressources.getMedia().getId()
        );
    }

}
