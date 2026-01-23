package com.example.backQueerDataBase.DTO.Respons;

import com.example.backQueerDataBase.Entity.WatchMetadata;

public record WatchMetadataResponseDTO(
        Long id,
        String creator,
        Integer duration,
        String platform,
        String videoType
) {
    public static WatchMetadataResponseDTO fromEntity(WatchMetadata metadata) {
        return new WatchMetadataResponseDTO(
                metadata.getId(),
                metadata.getCreator(),
                metadata.getDuration(),
                metadata.getPlatform(),
                metadata.getVideoType()
        );
    }
}
