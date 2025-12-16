package com.example.backQueerDataBase.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ici je pense que log vas pas etre ok

    private String firstName;

    private String lastName;

    private String email;

    private String password;

   // @OneToMany
   // private List<Resources> resources;

    //plus tard on pourra rajouter l'adresse ?

    private LocalDateTime createdAt;

    /* UserDetails */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() { return email; }

    @Override
    public  String getPassword () { return password; }
    // methode obligatoire pour que springsecurity de bloque pas la compilation de java
    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return true; }

}

