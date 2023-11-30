package com.example.Cataloguemicroservice.DTO.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EtiquetteResponseDTO {
    private Long idEtiquette;
    private String nomEtiquette;
    // Add more fields as needed
    private List<ProductResponseDTO> produits; // Add the list of ProduitDTO objects

}

