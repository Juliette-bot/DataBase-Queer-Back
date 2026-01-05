package com.example.backQueerDataBase.DTO;

import com.example.backQueerDataBase.Entity.Ressources;
import com.example.backQueerDataBase.Entity.SubCategories;

public record RessourcesResponseDTO(
        long id,
        String name,
        String description,
        String url,
        String image_url,
        String creator,
        int release_year,
        int duration_minutes,
        String platform,
        SubCategories sub_category_id) {


    public static RessourcesResponseDTO fromEntity(Ressources ressources) {
        return new RessourcesResponseDTO(

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
