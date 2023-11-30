package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "produits")
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nomProduit;
    private String description;
    private double prixProduit;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "produit_etiquette",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "etiquette_id"))
    private Set<Etiquette> etiquettes;


    @ManyToMany
    @JoinTable(
            name = "produit_variety",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "variety_id"))
    private Set<Variety> varieties;

}
