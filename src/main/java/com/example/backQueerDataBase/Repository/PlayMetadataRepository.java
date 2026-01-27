package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.PlayMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayMetadataRepository extends JpaRepository<PlayMetadata, Long> {
    Optional<PlayMetadata> findByResourceId(Long resourceId);
}