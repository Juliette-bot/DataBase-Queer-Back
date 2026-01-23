package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.Category;
import com.example.backQueerDataBase.Service.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    @Query("SELECT c FROM Category c WHERE c.media.id = :mediaId")
    List<Category> findByMediaId(@Param("mediaId") Long mediaId);
}
