package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
