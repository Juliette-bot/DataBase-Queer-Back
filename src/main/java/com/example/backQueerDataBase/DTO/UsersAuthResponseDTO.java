package com.example.backQueerDataBase.DTO;

public record UsersAuthResponseDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String token
) {}