package com.example.backQueerDataBase.DTO.Respons;

public record UsersAuthResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String token
) {}