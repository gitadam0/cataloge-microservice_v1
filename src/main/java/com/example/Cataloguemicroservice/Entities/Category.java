package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "categories")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    private String nomCategory;
    @OneToMany
    private List<Produit> produits;
    @ManyToOne
    private Catalogue catalogue;
    @Override
    public int hashCode() {
        return Objects.hash(nomCategory);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Category category = (Category) obj;
        return Objects.equals(nomCategory, category.nomCategory);
    }
}
