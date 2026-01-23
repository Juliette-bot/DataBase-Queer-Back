package com.example.backQueerDataBase.dto.response;

import com.example.backQueerDataBase.model.*;
import java.time.LocalDateTime;

public record ResourceResponseDTO(
        Long id,
        String title,
        String description,
        String url,
        String[] tags,
        String language,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long mediaId,
        Long categoryId,
        Long subcategoryId,
        Long userId,
        String mediaType,
        String categoryName,
        String subcategoryName,
        ReadMetadataResponseDTO readMetadata,
        ListenMetadataResponseDTO listenMetadata,
        WatchMetadataResponseDTO watchMetadata
) {

    public static ResourceResponseDTO fromEntity(Resource resource) {
        return new ResourceResponseDTO(
                resource.getId(),
                resource.getTitle(),
                resource.getDescription(),
                resource.getUrl(),
                resource.getTags(),
                resource.getLanguage(),
                resource.getCreatedAt(),
                resource.getUpdatedAt(),
                resource.getMedia() != null ? resource.getMedia().getId() : null,
                resource.getCategory() != null ? resource.getCategory().getId() : null,
                resource.getSubcategory() != null ? resource.getSubcategory().getId() : null,
                resource.getUser() != null ? resource.getUser().getId() : null,
                resource.getMedia() != null ? resource.getMedia().getType() : null,
                resource.getCategory() != null ? resource.getCategory().getName() : null,
                resource.getSubcategory() != null ? resource.getSubcategory().getName() : null,
                resource.getReadMetadata() != null ? ReadMetadataResponseDTO.fromEntity(resource.getReadMetadata()) : null,
                resource.getListenMetadata() != null ? ListenMetadataResponseDTO.fromEntity(resource.getListenMetadata()) : null,
                resource.getWatchMetadata() != null ? WatchMetadataResponseDTO.fromEntity(resource.getWatchMetadata()) : null
        );
    }
}