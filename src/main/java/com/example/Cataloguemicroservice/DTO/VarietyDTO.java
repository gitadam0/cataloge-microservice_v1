package com.example.Cataloguemicroservice.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class VarietyDTO {
    private Long idVariety;
    private String varietyName;
    private Set<ProductDTO> products;

}
