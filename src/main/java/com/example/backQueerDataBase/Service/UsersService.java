package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.UsersLoginRequestDTO;
import com.example.backQueerDataBase.DTO.UsersProfileResponseDTO;
import com.example.backQueerDataBase.DTO.UsersRegisterRequestDTO;
import com.example.backQueerDataBase.Entity.Users;
import com.example.backQueerDataBase.Repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class UsersService implements UserDetailsService {

    // J'appel mes dépendances
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    // Constructeur pour injecter le repo
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ============================================
    // MÉTHODE 1 : loadUserByUsername
    // ============================================
    // RÔLE : Utilisée par Spring Security pour l'authentification
    // PUBLIQUE : Spring Security l'appelle automatiquement
    // REÇOIT : email (String)
    // RETOURNE : UserDetails (en fait, c'est Users qui implémente UserDetails)
    // TRAVAILLE AVEC : Entity (Users)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur.ice non trouvé.e : " + email));
    }

    // ============================================
    // MÉTHODE 2 : getUserById
    // ============================================
    // RÔLE : Récupérer le profil d'un utilisateur par son ID
    // PUBLIQUE : Le Controller peut l'appeler
    // REÇOIT : userId (Long)
    // RETOURNE : UsersProfileResponseDTO (DTO pour l'extérieur)
    // TRAVAILLE AVEC : Entity en interne, DTO en sortie
    public UsersProfileResponseDTO getUserById(Long userId) {
        // 1. Récupère l'Entity depuis la base
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur.ice non trouvé.e"));

        // 2. Convertit l'Entity en DTO et retourne
        return convertToDTO(user);
    }

    // ============================================
    // MÉTHODE 3 : convertToDTO
    // ============================================
    // RÔLE : Transformer une Entity Users en DTO UsersProfileResponseDTO
    // PRIVÉE : Utilisée UNIQUEMENT en interne par le Service
    // REÇOIT : Users (Entity)
    // RETOURNE : UsersProfileResponseDTO (DTO)
    // POURQUOI PRIVÉE ? C'est un outil interne, personne d'autre n'en a besoin
    private UsersProfileResponseDTO convertToDTO(Users paramuser) {
        return new UsersProfileResponseDTO(
                paramuser.getId(),
                paramuser.getFirstName(),
                paramuser.getLastName(),
                paramuser.getEmail()
        );
    }

    public UsersProfileResponseDTO register(UsersRegisterRequestDTO content){
        if (usersRepository.existsByEmail(content.email())) {
            throw new RuntimeException("Email déjà utilisé");
        };

        Users newUsers = Users.builder()
                .email(content.email())
                .password(passwordEncoder.encode(content.password()))
                .firstName(content.firstName())
                .lastName(content.lastName())
                .createdAt(LocalDateTime.now())
                .build();

        Users savedUser = usersRepository.save(newUsers);
        log.info("User saved");
        return  convertToDTO(savedUser);

    }

    public UsersProfileResponseDTO login(UsersLoginRequestDTO content){

        Users users = usersRepository.findByEmail(content.email())
                .orElseThrow(() -> new RuntimeException("Email or password incorrect"));


        if(!passwordEncoder.matches(content.password(), users.getPassword())) {
            throw new RuntimeException("Email or password incorrect");
        }

        return convertToDTO(users);

    }


}