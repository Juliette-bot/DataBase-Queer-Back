package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

    public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
        @Query("SELECT s FROM SubCategory s WHERE s.category.id = :categoryId")
        List<SubCategory> findByCategoryId(@Param("categoryId") Long categoryId);
    }
