package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Optional<Resource> findByTitle(String title);

}
