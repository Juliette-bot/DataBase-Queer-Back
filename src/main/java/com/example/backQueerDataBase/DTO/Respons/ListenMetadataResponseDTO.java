package com.example.backQueerDataBase.DTO.Respons;

import com.example.backQueerDataBase.Entity.ListenMetadata;

public record ListenMetadataResponseDTO(
        Long id,
        String creator,
        Integer duration,
        String platform,
        String episodeNumber
) {
    public static ListenMetadataResponseDTO fromEntity(ListenMetadata metadata) {
        return new ListenMetadataResponseDTO(
                metadata.getId(),
                metadata.getCreator(),
                metadata.getDuration(),
                metadata.getPlatform(),
                metadata.getEpisodeNumber()
        );
    }
}
