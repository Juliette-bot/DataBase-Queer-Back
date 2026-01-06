package com.example.backQueerDataBase.DTO;

public record ResourceRequestDTO(
        long id,
        String name,
        String description,
        String url,
        String image_url,
        String creator,
        int release_year,
        int duration_minutes,
        String platform,
        com.example.backQueerDataBase.Entity.Users sub_category_id) {
}
