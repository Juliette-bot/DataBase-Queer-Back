package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.Category;
import com.example.backQueerDataBase.Service.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    Optional<Category> findById(CategoryService id);
}
