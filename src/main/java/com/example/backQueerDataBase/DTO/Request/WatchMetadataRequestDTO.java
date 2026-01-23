package com.example.backQueerDataBase.DTO.Request;

public record WatchMetadataRequestDTO(
        String creator,
        Integer duration,
        String platform,
        String videoType
) {
}
