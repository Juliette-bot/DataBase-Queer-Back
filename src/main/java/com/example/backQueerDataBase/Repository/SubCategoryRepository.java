package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.SubCategory;
import com.example.backQueerDataBase.Service.SubCategoryService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    Optional<SubCategory> findByName(String name);

}
