package com.example.backQueerDataBase.DTO.Request;

import java.time.LocalDate;

public record ReadMetadataRequestDTO(
        String author,
        LocalDate publicationDate,
        Integer pageCount,
        String format
) {
}
