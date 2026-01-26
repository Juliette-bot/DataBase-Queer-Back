package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.Respons.UsersAuthResponseDTO;
import com.example.backQueerDataBase.DTO.Request.UsersLoginRequestDTO;
import com.example.backQueerDataBase.DTO.Respons.UsersProfileResponseDTO;
import com.example.backQueerDataBase.DTO.Request.UsersRegisterRequestDTO;
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

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur.ice non trouvé.e : " + email));
    }

    public UsersProfileResponseDTO getUserById(Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur.ice non trouvé.e"));
        return convertToDTO(user);
    }

    private UsersProfileResponseDTO convertToDTO(Users paramuser) {
        return new UsersProfileResponseDTO(
                paramuser.getId(),
                paramuser.getFirstName(),
                paramuser.getLastName(),
                paramuser.getEmail()
        );
    }

    public UsersAuthResponseDTO register(UsersRegisterRequestDTO content){
        if (usersRepository.existsByEmail(content.email())) {
            throw new RuntimeException("Email déjà utilisé");
        }

        Users newUsers = Users.builder()
                .email(content.email())
                .password(passwordEncoder.encode(content.password()))
                .firstName(content.firstName())
                .lastName(content.lastName())
                .createdAt(LocalDateTime.now())
                .build();

        Users savedUser = usersRepository.save(newUsers);

        String token = jwtService.generateToken(savedUser);

        log.info("User saved");

        return new UsersAuthResponseDTO(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail(),
                token
        );
    }

    public UsersAuthResponseDTO login(UsersLoginRequestDTO content){
        Users users = usersRepository.findByEmail(content.email())
                .orElseThrow(() -> new RuntimeException("Email or password incorrect"));

        if(!passwordEncoder.matches(content.password(), users.getPassword())) {
            throw new RuntimeException("Email or password incorrect");
        }

        String token = jwtService.generateToken(users);

        return new UsersAuthResponseDTO(
                users.getId(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                token  
        );
    }
}