package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.Media;
import com.example.backQueerDataBase.Service.MediaService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Long> {
    Optional<Media> findByType(String type);
}
