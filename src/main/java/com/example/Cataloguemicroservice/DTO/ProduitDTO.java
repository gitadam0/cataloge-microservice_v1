package com.example.Cataloguemicroservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProduitDTO {
    private Long idProduit;

    @NotBlank(message = "Product name is required")
    private String nomProduit;

    @NotNull(message = "Price is required")
    private Double prixProduit;

    private Set<VarietyDTO> varieties;

    private List<EtiquetteDTO> etiquette;

    private CategoryDTO category;

    // Constructors, builder pattern, and additional validation can be added here
}
