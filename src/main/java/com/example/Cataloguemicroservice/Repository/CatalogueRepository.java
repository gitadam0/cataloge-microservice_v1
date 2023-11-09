package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
}
