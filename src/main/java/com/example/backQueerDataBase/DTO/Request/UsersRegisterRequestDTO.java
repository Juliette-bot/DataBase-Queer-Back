package com.example.backQueerDataBase.DTO.Request;

public record UsersRegisterRequestDTO(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
