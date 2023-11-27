package com.example.Cataloguemicroservice.Services.Catalogue;

import com.example.Cataloguemicroservice.Entities.Catalogue;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;

import java.util.List;

public interface CatalogueService {
    List<Catalogue> getCatalogues();
    void deleteCatalogue(Long id);
    Catalogue getCatalogueByID(long id) throws EntityNotFoundException;
    Catalogue updateCatalogue(long id,Catalogue newCatalogue) throws EntityNotFoundException;
    Catalogue createCatalogue(Catalogue catalogue);
}
