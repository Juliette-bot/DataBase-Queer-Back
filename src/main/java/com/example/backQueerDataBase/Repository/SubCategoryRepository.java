package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.SubCategory;
import com.example.backQueerDataBase.Service.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByCategory(CategoryService category_id);
    Optional<SubCategory> findByName(String name);

}
