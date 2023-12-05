package com.example.Cataloguemicroservice.Services.Variety;

import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;

import java.util.List;

public interface VarietyService {
    void delVarietys(List<Long> ids);

    List<Variety> getVarietys();
    void deleteVariety(Long id);
    Variety getVarietyByID(long id) throws MyEntityNotFoundException;
    Variety updateVariety(long id,Variety newVariety) throws MyEntityNotFoundException;
    Variety createVariety(Variety Variety);
}