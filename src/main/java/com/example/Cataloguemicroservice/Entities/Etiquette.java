package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "etiquettes")
@NoArgsConstructor
public class Etiquette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtiquette;
    private String nomEtiquette;
    @OneToMany
    private List<Produit> produits;
    @Override
    public int hashCode() {
        return Objects.hash(nomEtiquette);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Etiquette etiquette = (Etiquette) obj;
        return Objects.equals(nomEtiquette, etiquette.nomEtiquette);
    }
}
