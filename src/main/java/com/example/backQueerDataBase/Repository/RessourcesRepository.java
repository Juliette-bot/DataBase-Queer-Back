package com.example.backQueerDataBase.Repository;

import com.example.backQueerDataBase.Entity.Ressources;
import com.example.backQueerDataBase.Service.RessourcesService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RessourcesRepository extends JpaRepository<Ressources, Long> {
     List<Ressources> findBySubCategory(RessourcesService sub_category_id);
     List<Ressources> findById(Ressources id);

}
