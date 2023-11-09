package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "etiquettes")
public class Etequette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtiquette;
    private String nameEtiquette;
}
