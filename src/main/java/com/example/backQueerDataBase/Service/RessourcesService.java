package com.example.backQueerDataBase.Service;

import com.example.backQueerDataBase.DTO.RessourcesResponseDTO;
import com.example.backQueerDataBase.Repository.RessourcesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RessourcesService {
    
    private final RessourcesRepository ressourcesRepository;


    public Optional<RessourcesResponseDTO> getRessourcesById(long id) {
        return ressourcesRepository.findById(id)
                .map(RessourcesResponseDTO::fromEntity);
    }

    public List<RessourcesResponseDTO> getRessourcesBySubCategory(RessourcesService id) {
        return ressourcesRepository.findBySubCategory(id)
                .stream().map(RessourcesResponseDTO::fromEntity).toList();
    }
}
