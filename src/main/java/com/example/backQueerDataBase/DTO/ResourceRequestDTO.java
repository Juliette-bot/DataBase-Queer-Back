package com.example.backQueerDataBase.DTO;

public record ResourceRequestDTO(
        Long id,
        String name,
        String description,
        String url,
        String image_url,
        String creator,
        int release_year,
        int duration_minutes,
        String platform,
        String sub_category_id) {
}
