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

}
