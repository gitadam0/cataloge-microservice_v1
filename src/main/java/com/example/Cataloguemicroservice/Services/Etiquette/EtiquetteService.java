package com.example.Cataloguemicroservice.Services.Etiquette;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;

import java.util.List;

public interface EtiquetteService {
    List<Etiquette> getEtiquettes();
    void deleteEtiquette(Long id);
    Etiquette getEtiquetteByID(long id) throws EntityNotFoundException;
    Etiquette updateEtiquette(long id,Etiquette newEtiquette) throws EntityNotFoundException;
    Etiquette createEtiquette(Etiquette Etiquette);
}
