package com.example.Cataloguemicroservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class CatalogueDTO {
    private Long idCatalogue;
    private String nomCatalogue;
    private List<CategoryDTO> categories;

}
