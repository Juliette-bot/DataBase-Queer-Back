package com.example.backQueerDataBase.DTO.Respons;
import com.example.backQueerDataBase.Entity.Resource;
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
        Long userId,
        String mediaType,
        String categoryName,
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
                resource.getUser() != null ? resource.getUser().getId() : null,
                resource.getMedia() != null ? resource.getMedia().getType() : null,  // ✅ Pas de Long.valueOf(), c'est déjà un String
                resource.getCategory() != null ? resource.getCategory().getName() : null,
                resource.getReadMetadata() != null ? ReadMetadataResponseDTO.fromEntity(resource.getReadMetadata()) : null,  // ✅ Pas de String.valueOf()
                resource.getListenMetadata() != null ? ListenMetadataResponseDTO.fromEntity(resource.getListenMetadata()) : null,
                resource.getWatchMetadata() != null ? WatchMetadataResponseDTO.fromEntity(resource.getWatchMetadata()) : null
        );
    }
}