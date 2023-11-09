package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Variety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarietyRepository extends JpaRepository<Variety, Long> {
}