package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtiquetteRepository extends JpaRepository<Etiquette,Long> {


}
