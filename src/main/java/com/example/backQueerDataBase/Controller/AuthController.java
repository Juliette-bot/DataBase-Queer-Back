package com.example.backQueerDataBase.Controller;

import com.example.backQueerDataBase.DTO.UsersLoginRequestDTO;
import com.example.backQueerDataBase.DTO.UsersProfileResponseDTO;
import com.example.backQueerDataBase.DTO.UsersRegisterRequestDTO;
import com.example.backQueerDataBase.Service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    //j'appel mon service pour utliser toutes les methode que j'ai créé
    private final UsersService usersService;

    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public UsersProfileResponseDTO register(@RequestBody UsersRegisterRequestDTO content){
        return usersService.register(content);
    }

    @PostMapping("/login")
    public UsersProfileResponseDTO login(@RequestBody UsersLoginRequestDTO content) {
        return usersService.login(content);
    }
}
