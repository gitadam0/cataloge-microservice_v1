package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "produits")
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nomProduit;
    private double prixProduit;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Etiquette etiquette;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "produit_variety",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "variety_id"))
    private Set<Variety> varieties;
//test
//    @Override
//    public int hashCode() {
//        return Objects.hash(nomProduit, prixProduit, etiquette, varieties);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Produit produit = (Produit) obj;
//        return Objects.equals(nomProduit, produit.nomProduit) &&
//                Objects.equals(prixProduit, produit.prixProduit) &&
//                Objects.equals(etiquette, produit.etiquette) &&
//                Objects.equals(varieties, produit.varieties);
//    }
}
