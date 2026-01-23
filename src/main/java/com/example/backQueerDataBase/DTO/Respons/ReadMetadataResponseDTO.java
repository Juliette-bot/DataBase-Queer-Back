package com.example.backQueerDataBase.DTO.Respons;

import com.example.backQueerDataBase.Entity.ReadMetadata;

import java.time.LocalDate;

public record ReadMetadataResponseDTO(
        Long id,
        String author,
        LocalDate publicationDate,
        Integer pageCount,
        String format
) {
    public static ReadMetadataResponseDTO fromEntity(ReadMetadata metadata) {
        return new ReadMetadataResponseDTO(
                metadata.getId(),
                metadata.getAuthor(),
                metadata.getPublicationDate(),
                metadata.getPageCount(),
                metadata.getFormat()
        );
    }
}
