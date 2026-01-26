package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.Request.ResourceRequestDTO;
import com.example.backQueerDataBase.DTO.Respons.ResourceResponseDTO;
import com.example.backQueerDataBase.Entity.*;
import com.example.backQueerDataBase.Repository.*;
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
    private final MediaRepository mediaRepository;
    private final CategoryRepository categoryRepository;
    private final UsersRepository usersRepository;
    private final ReadMetadataRepository readMetadataRepository;
    private final ListenMetadataRepository listenMetadataRepository;
    private final WatchMetadataRepository watchMetadataRepository;

    public List<ResourceResponseDTO> getAllResources() {
        return ressourcesRepository.findAll()
                .stream()
                .map(ResourceResponseDTO::fromEntity)
                .toList();
    }

    public Optional<ResourceResponseDTO> getRessourcesById(Long id) {
        return ressourcesRepository.findById(id)
                .map(ResourceResponseDTO::fromEntity);
    }


    public Optional<ResourceResponseDTO> getResourceByTitle(String title) {
        return ressourcesRepository.findByTitle(title)
                .map(ResourceResponseDTO::fromEntity);
    }

    public ResourceResponseDTO addResource(ResourceRequestDTO request, String userEmail) {

        Media media = mediaRepository.findById(request.mediaId())
                .orElseThrow(() -> new RuntimeException("Media not found"));
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Users users = usersRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));


        Resource newResource = Resource.builder()
                .title(request.title())
                .description(request.description())
                .url(request.url())
                .tags(request.tags())
                .language(request.language())
                .media(media)
                .category(category)
                .user(users)
                .build();

        Resource savedResource = ressourcesRepository.save(newResource);


        String mediaType = media.getType();

        switch (mediaType.toLowerCase()) {
            case "read":
                if (request.readMetadata() != null) {
                    ReadMetadata readMetadata = new ReadMetadata();
                    readMetadata.setResource(savedResource);
                    readMetadata.setAuthor(request.readMetadata().author());
                    readMetadata.setPublicationDate(request.readMetadata().publicationDate());
                    readMetadata.setPageCount(request.readMetadata().pageCount());
                    readMetadata.setFormat(request.readMetadata().format());
                    readMetadataRepository.save(readMetadata);
                    log.info("ReadMetadata created for resource: {}", savedResource.getId());
                }
                break;

            case "listen":
                if (request.listenMetadata() != null) {
                    ListenMetadata listenMetadata = new ListenMetadata();
                    listenMetadata.setResource(savedResource);
                    listenMetadata.setCreator(request.listenMetadata().creator());
                    listenMetadata.setDuration(request.listenMetadata().duration());
                    listenMetadata.setPlatform(request.listenMetadata().platform());
                    listenMetadata.setEpisodeNumber(request.listenMetadata().episodeNumber());
                    listenMetadataRepository.save(listenMetadata);
                    log.info("ListenMetadata created for resource: {}", savedResource.getId());
                }
                break;

            case "watch":
                if (request.watchMetadata() != null) {
                    WatchMetadata watchMetadata = new WatchMetadata();
                    watchMetadata.setResource(savedResource);
                    watchMetadata.setCreator(request.watchMetadata().creator());
                    watchMetadata.setDuration(request.watchMetadata().duration());
                    watchMetadata.setPlatform(request.watchMetadata().platform());
                    watchMetadata.setVideoType(request.watchMetadata().videoType());
                    watchMetadataRepository.save(watchMetadata);
                    log.info("WatchMetadata created for resource: {}", savedResource.getId());
                }
                break;

            default:
                log.warn("Unknown media type: {}", mediaType);
        }

        log.info("Resource added successfully by user: {}", users.getEmail());


        Resource resourceWithMetadata = ressourcesRepository.findById(savedResource.getId())
                .orElseThrow(() -> new RuntimeException("Resource not found after save"));

        return ResourceResponseDTO.fromEntity(resourceWithMetadata);
    }
}