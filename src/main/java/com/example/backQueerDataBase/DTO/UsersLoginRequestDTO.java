package com.example.backQueerDataBase.DTO;

public record UsersLoginRequestDTO (
        String email,
        String password
){}




// record permet cette magie de ne pas avoir besoin d'écrire tout cela :
// conviens bien pour les DTO sans logique métier
/*public class UsersLoginRequestDTO {
    private final String mail;      // final = immuable
    private final String password;  // final = immuable

    // Constructeur
    public UsersLoginRequestDTO(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    // Getters (pas de "get", juste le nom du champ)
    public String mail() { return mail; }
    public String password() { return password; }

    // equals() automatique (compare les valeurs)
    @Override
    public boolean equals(Object o) { ... }

    // hashCode() automatique
    @Override
    public int hashCode() { ... }

    // toString() automatique
    @Override
    public String toString() {
        return "UsersLoginRequestDTO[mail=" + mail + ", password=" + password + "]";
    }
}*/