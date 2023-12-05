package com.example.Cataloguemicroservice.Services.Etiquette;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;

import java.util.List;

public interface EtiquetteService {
    List<Etiquette> getEtiquettes();
    void deleteEtiquette(Long id);
    void deleteEtiquetteIfNotUsed(Long ids) throws MyEntityNotFoundException;
    Etiquette getEtiquetteByID(long id) throws MyEntityNotFoundException;
    Etiquette updateEtiquette(long id,Etiquette newEtiquette) throws MyEntityNotFoundException;
    Etiquette createEtiquette(Etiquette Etiquette);
}
