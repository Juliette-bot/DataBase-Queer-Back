package com.example.backQueerDataBase.Controller;


import com.example.backQueerDataBase.DTO.MediaResponseDTO;
import com.example.backQueerDataBase.Service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MediaController {
    private final MediaService mediaService;

    @GetMapping("/media")
    public List<MediaResponseDTO> getAllMedia(){
        System.out.println("Controller all Media call");
        return mediaService.getAllMedia();
    }

    @GetMapping("/media/{id}")
    public ResponseEntity<MediaResponseDTO> getMediaById(@PathVariable Long id){
        Optional<MediaResponseDTO> media = mediaService.getMediaById(id);
        return media.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
