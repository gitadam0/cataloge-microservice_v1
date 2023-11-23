package com.example.Cataloguemicroservice.Services.Variety;

import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;

import java.util.List;

public interface VarietyService {
    List<Variety> getVarietys();
    void deleteVariety(Long id);
    Variety getVarietyByID(long id) throws EntityNotFoundException;
    Variety updateVariety(long id,Variety newVariety) throws EntityNotFoundException;
    Variety createVariety(Variety Variety);
}