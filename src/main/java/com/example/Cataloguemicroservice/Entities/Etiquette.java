package com.example.Cataloguemicroservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "etiquettes")
@NoArgsConstructor
public class Etiquette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtiquette;
    private String nomEtiquette;

    @JsonIgnore
    @ManyToMany(mappedBy = "etiquettes")
    private List<Produit> produits;
}
