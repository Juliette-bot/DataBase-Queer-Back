package com.example.backQueerDataBase.DTO.Respons;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayMetadataResponseDTO {

    private Long id;
    private String creator;
    private String gameGenre;
    private Integer playerNumber;
}