package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.ResourceResponseDTO;
import com.example.backQueerDataBase.Repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResourceService {
    
    private final ResourceRepository ressourcesRepository;


    public Optional<ResourceResponseDTO> getRessourcesById(Long id) {
        return ressourcesRepository.findById(id)
                .map(ResourceResponseDTO::fromEntity);
    }

    public List<ResourceResponseDTO> getRessourcesBySubCategory(ResourceService id) {
        return ressourcesRepository.findBySubCategory(id)
                .stream().map(ResourceResponseDTO::fromEntity).toList();
    }

    public Optional<ResourceResponseDTO> getRessourcesByName(String name) {
        return ressourcesRepository.findByName(name)
                .map(ResourceResponseDTO::fromEntity);
    }
}
