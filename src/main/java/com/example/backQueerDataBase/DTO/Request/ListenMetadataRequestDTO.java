package com.example.backQueerDataBase.DTO.Request;

public record ListenMetadataRequestDTO(
        String creator,
        Integer duration,
        String platform,
        String episodeNumber
) {
}
