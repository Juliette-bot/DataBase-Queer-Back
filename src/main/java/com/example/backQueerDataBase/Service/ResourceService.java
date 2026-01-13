package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.ResourceRequestDTO;
import com.example.backQueerDataBase.DTO.ResourceResponseDTO;
import com.example.backQueerDataBase.Entity.Category;
import com.example.backQueerDataBase.Entity.Media;
import com.example.backQueerDataBase.Entity.Resource;
import com.example.backQueerDataBase.Entity.SubCategory;
import com.example.backQueerDataBase.Repository.CategoryRepository;
import com.example.backQueerDataBase.Repository.MediaRepository;
import com.example.backQueerDataBase.Repository.ResourceRepository;
import com.example.backQueerDataBase.Repository.SubCategoryRepository;
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
        SubCategory subCategory = SubCategoryRepository.findById(resource.subCategoryId())
                .orElseThrow(() -> new RuntimeException("SubCategory not found"));
        Category category = CategoryRepository.findById(resource.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Media media = MediaRepository.findById(resource.media_id())
                .orElseThrow(() -> new RuntimeException("Media not found"));

        Resource newResource = Resource.builder()
                .name(resource.name())
                .description(resource.description())
                .url(resource.url())
                .image_url(resource.image_url())
                .creator(resource.creator())
                .duration_minutes(resource.duration_minutes())
                .release_year(resource.release_year())
                .platform(resource.platform())
                .subCategory()
                .category()
                .build();

        Resource savedResource = ressourcesRepository.save(newResource);
        log.info("Resource added OK");
        return ResourceResponseDTO.fromEntity(savedResource);
    }
}