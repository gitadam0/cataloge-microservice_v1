package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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

}
