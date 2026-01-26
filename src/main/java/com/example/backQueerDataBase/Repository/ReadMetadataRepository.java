package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.ReadMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReadMetadataRepository extends JpaRepository<ReadMetadata, Long> {

    Optional<ReadMetadata> findByResourceId(Long resourceId);
}