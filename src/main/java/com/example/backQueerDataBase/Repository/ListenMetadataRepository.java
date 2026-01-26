package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.ListenMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListenMetadataRepository extends JpaRepository<ListenMetadata, Long> {
    Optional<ListenMetadata> findByResourceId(Long resourceId);
}