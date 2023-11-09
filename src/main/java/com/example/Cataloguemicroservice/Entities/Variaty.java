package com.example.Cataloguemicroservice.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@Table(name = "variaties")
public class Variaty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVariaty;
    private String nomVariaty;
}
