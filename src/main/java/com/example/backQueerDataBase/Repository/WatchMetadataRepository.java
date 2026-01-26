package com.example.backQueerDataBase.Repository;


import com.example.backQueerDataBase.Entity.WatchMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WatchMetadataRepository extends JpaRepository<WatchMetadata, Long> {
    Optional<WatchMetadata> findByResourceId(Long resourceId);
}