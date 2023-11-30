package com.example.Cataloguemicroservice.Mapper;


import com.example.Cataloguemicroservice.DTO.request.VarietyRequestDto;
import com.example.Cataloguemicroservice.DTO.response.VarietyResponseDTO;
import com.example.Cataloguemicroservice.Entities.Variety;
import org.springframework.beans.BeanUtils;

import java.lang.invoke.VarHandle;

public class VarietyMapperDto {
public Variety toDao(VarietyRequestDto varietyRequestDto){
    Variety variety= new Variety();
    BeanUtils.copyProperties(varietyRequestDto,variety);
    return variety;
}
public VarietyResponseDTO formDao(Variety variety){
    VarietyResponseDTO varietyResponseDTO=new VarietyResponseDTO();
    BeanUtils.copyProperties(variety,varietyResponseDTO);
    return varietyResponseDTO;
}

}
