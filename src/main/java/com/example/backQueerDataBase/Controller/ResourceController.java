package com.example.backQueerDataBase.Controller;


import com.example.backQueerDataBase.DTO.ResourceResponseDTO;
import com.example.backQueerDataBase.Service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService ressourcesService;

    @GetMapping("/ressources")
    public List<ResourceResponseDTO> getAllRessources(){
        System.out.println("Controller All Ressources call");
        List<ResourceResponseDTO> ressourcesList = ressourcesService.getRessourcesBySubCategory(ressourcesService);
                return ressourcesList;
    }

    @GetMapping("/ressources/{id}")
    public Optional<ResourceResponseDTO> qetRessourcesById(long id) {
        System.out.println("Controller Ressources Id call");
        Optional<ResourceResponseDTO> ressourcesResponseDTOList = ressourcesService.getRessourcesById(id);
        return ressourcesResponseDTOList;
    }
}
