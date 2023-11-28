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
@Table(name = "varieties")
@NoArgsConstructor
public class Variety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVariety;
    private String varietyName;

    @JsonIgnore
    @ManyToMany(mappedBy = "varieties")
    private List<Produit> produits;
}
