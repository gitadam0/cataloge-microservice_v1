package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "varieties")
@NoArgsConstructor
public class Variety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVariety;
    private String varietyName;

    @ManyToMany(mappedBy = "varieties")
    private Set<Produit> produits;
//    @Override
//    public int hashCode() {
//        return Objects.hash(varietyName);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Variety variety = (Variety) obj;
//        return Objects.equals(varietyName, variety.varietyName);
//    }
}
