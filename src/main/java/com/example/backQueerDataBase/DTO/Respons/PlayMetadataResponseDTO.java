package com.example.backQueerDataBase.DTO.Respons;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public record PlayMetadataResponseDTO (
         Long id;
         String creator;
         String gameGenre;
         Integer playerNumber;){


}