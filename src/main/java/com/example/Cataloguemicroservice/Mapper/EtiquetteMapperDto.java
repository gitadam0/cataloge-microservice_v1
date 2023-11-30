package com.example.Cataloguemicroservice.Mapper;

import com.example.Cataloguemicroservice.DTO.request.EtiquetteRequestDto;
import com.example.Cataloguemicroservice.DTO.response.EtiquetteResponseDTO;
import com.example.Cataloguemicroservice.Entities.Etiquette;
import org.springframework.beans.BeanUtils;

public class EtiquetteMapperDto {
    public Etiquette toDao(EtiquetteRequestDto etiquetteRequestDto){
        Etiquette etiquette =new Etiquette();
        BeanUtils.copyProperties(etiquetteRequestDto,etiquette);
        return etiquette;
    }
    public EtiquetteResponseDTO etiquetteResponseDTO (Etiquette etiquette){
    EtiquetteResponseDTO etiquetteResponseDTO =new EtiquetteResponseDTO();
    BeanUtils.copyProperties(etiquette,etiquetteResponseDTO);
    return etiquetteResponseDTO;

    }

}
