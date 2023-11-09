package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "etiquettes")
public class Etiquette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtiquette;
    private String nomEtiquette;
    @OneToMany
    private List<Produit> produits;

}
