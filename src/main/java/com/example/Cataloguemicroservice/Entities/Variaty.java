package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "variaties")
@Getter
@Setter
@NoArgsConstructor
public class Variaty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVariaty;
    private String nomVariaty;
}
