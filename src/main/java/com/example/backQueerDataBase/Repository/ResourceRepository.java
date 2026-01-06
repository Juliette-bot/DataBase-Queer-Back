package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.Resource;
import com.example.backQueerDataBase.Service.ResourceService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
     List<Resource> findBySubCategory(ResourceService sub_category_id);
     List<Resource> findById(Resource id);

}
