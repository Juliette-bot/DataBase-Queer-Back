package com.example.backQueerDataBase.DTO;

public record UsersRegisterRequestDTO(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
