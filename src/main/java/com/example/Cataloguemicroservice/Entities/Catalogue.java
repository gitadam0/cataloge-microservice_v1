package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "catalogue")
@NoArgsConstructor
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalogue;
    private String nomCatalogue;
}




