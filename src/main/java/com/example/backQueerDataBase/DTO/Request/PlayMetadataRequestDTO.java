package com.example.backQueerDataBase.DTO.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayMetadataRequestDTO {

    private String creator;
    private String gameGenre;
    private Integer playerNumber;
}