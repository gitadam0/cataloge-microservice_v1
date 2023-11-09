package com.example.Cataloguemicroservice.Repository;

import com.example.Cataloguemicroservice.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
