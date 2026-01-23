package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.MediaResponseDTO;
import com.example.backQueerDataBase.Entity.Media;
import com.example.backQueerDataBase.Repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaService {
    public final MediaRepository mediaRepository;

    public Optional<MediaResponseDTO> getMediaById(Long id){
        return mediaRepository.findById(id)
                .map(MediaResponseDTO::fromEntity);
    }

    public List<MediaResponseDTO> getAllMedia() {
        List<Media> mediaList = mediaRepository.findAll();
        return mediaList.stream()
                .map(MediaResponseDTO::fromEntity)
                .toList();
    }

    public Optional<MediaResponseDTO> getMediaByName(String name) {
        return mediaRepository.findByType(name)
                .map((MediaResponseDTO::fromEntity));
    }
}
