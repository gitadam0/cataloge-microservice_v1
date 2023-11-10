package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//import java.util.Objects;

@Entity
@Data
@Table(name = "catalogue")
@NoArgsConstructor
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalogue;
    private String nomCatalogue;
    @OneToMany
    private List <Category> categories;
//    @Override
//    public int hashCode() {
//        return Objects.hash(nomCatalogue);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Catalogue catalogue = (Catalogue) obj;
//        return Objects.equals(nomCatalogue, catalogue.nomCatalogue);
//    }
}




