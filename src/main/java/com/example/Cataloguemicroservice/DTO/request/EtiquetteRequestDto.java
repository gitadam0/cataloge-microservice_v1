package com.example.Cataloguemicroservice.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EtiquetteRequestDto {
    private Long idEtiquette;
    private String nomEtiquette;

}
