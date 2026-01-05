package com.example.backQueerDataBase.Controller;


import com.example.backQueerDataBase.DTO.RessourcesResponseDTO;
import com.example.backQueerDataBase.Service.RessourcesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RessourcesController {
    private final RessourcesService ressourcesService;

    @GetMapping("/ressources")
    public List<RessourcesResponseDTO> getAllRessources(){
        System.out.println("Controller All Ressources call");
        List<RessourcesResponseDTO> ressourcesList = ressourcesService.getRessourcesBySubCategory(ressourcesService);
                return ressourcesList;
    }

    @GetMapping("/ressources/{id}")
    public Optional<RessourcesResponseDTO> qetRessourcesById(long id) {
        System.out.println("Controller Ressources Id call");
        Optional<RessourcesResponseDTO> ressourcesResponseDTOList = ressourcesService.getRessourcesById(id);
        return ressourcesResponseDTOList;
    }
}
