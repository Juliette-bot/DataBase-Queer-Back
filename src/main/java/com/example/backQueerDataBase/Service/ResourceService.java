package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.ResourceRequestDTO;
import com.example.backQueerDataBase.DTO.ResourceResponseDTO;
import com.example.backQueerDataBase.Entity.Resource;
import com.example.backQueerDataBase.Repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    public ResourceResponseDTO addResource(ResourceRequestDTO resource) {
        Resource newResource = Resource.builder()
                .name(resource.name())
                .description(resource.description())
                .url(resource.url())
                .image_url(resource.image_url())
                .creator(resource.creator())
                .duration_minutes(resource.duration_minutes())
                .release_year(resource.release_year())
                .platform(resource.platform())
                .build();

        Resource savedResource = ressourcesRepository.save(newResource);
        log.info("Resource added OK");
        return ResourceResponseDTO.fromEntity(savedResource);
    }
}