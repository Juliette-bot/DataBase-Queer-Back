package com.example.backQueerDataBase.Controller;


import com.example.backQueerDataBase.DTO.Request.ResourceRequestDTO;
import com.example.backQueerDataBase.DTO.Respons.ResourceResponseDTO;
import com.example.backQueerDataBase.Service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService ressourcesService;

    @GetMapping("/resource")
    public List<ResourceResponseDTO> getAllRessources(){
        System.out.println("Controller All Resources call");
        return ressourcesService.getAllResources();
    }

    @GetMapping("/ressources/{id}")
    public Optional<ResourceResponseDTO> qetRessourcesById(long id) {
        System.out.println("Controller Ressources Id call");
        Optional<ResourceResponseDTO> ressourcesResponseDTOList = ressourcesService.getRessourcesById(id);
        return ressourcesResponseDTOList;
    }

    @PostMapping("/resource/add")
    public ResourceResponseDTO addNewResource(
            @RequestBody ResourceRequestDTO newResource,
            @AuthenticationPrincipal UserDetails userDetails) {

        System.out.println("Controller Add Resource call");
        String userEmail = userDetails.getUsername();
        return ressourcesService.addResource(newResource, userEmail);
    }
}
