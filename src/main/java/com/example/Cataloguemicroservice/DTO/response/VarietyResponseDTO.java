package com.example.Cataloguemicroservice.DTO.response;


import lombok.*;

import java.util.Set;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class VarietyResponseDTO {
    private Long idVariety;
    private String varietyName;
    private Set<ProductResponseDTO> produits;

}
