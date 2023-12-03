package com.example.Cataloguemicroservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EtiquetteDTO {
    private Long idEtiquette;
    private String nomEtiquette;
    // Add more fields as needed
    private List<ProductDTO> products; // Add the list of ProductDTO objects

}

