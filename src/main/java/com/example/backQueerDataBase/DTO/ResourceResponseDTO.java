package com.example.backQueerDataBase.DTO;

import com.example.backQueerDataBase.Entity.Resource;
import com.example.backQueerDataBase.Entity.SubCategory;

public record ResourceResponseDTO(
        long id,
        String name,
        String description,
        String url,
        String image_url,
        String creator,
        int release_year,
        int duration_minutes,
        String platform,
        SubCategory sub_category_id) {


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
                ressources.getSubCategory()
        );
    }

}
