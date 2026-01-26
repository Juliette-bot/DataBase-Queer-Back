package com.example.backQueerDataBase.DTO.Request;

public record ResourceRequestDTO(
        String title,
        String description,
        String url,
        String[] tags,
        String language,
        Long mediaId,
        Long categoryId,
        ReadMetadataRequestDTO readMetadata,
        ListenMetadataRequestDTO listenMetadata,
        WatchMetadataRequestDTO watchMetadata
) {}