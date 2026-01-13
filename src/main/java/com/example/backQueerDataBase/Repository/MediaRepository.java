package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.Media;
import com.example.backQueerDataBase.Entity.SubCategory;
import com.example.backQueerDataBase.Service.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Long> {
    Optional<Media> findByName(String name);

}
