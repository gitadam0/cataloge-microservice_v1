package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.Entities.Catalogue;
import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Exceptions.CatalogueNotFoundException;
import com.example.Cataloguemicroservice.Exceptions.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CatalogueService {
    List<Catalogue> getCatalogues();
    void deleteCatalogue(Long id);
    Catalogue getCatalogueByID(long id) throws CatalogueNotFoundException;
    Catalogue updateCatalogue(long id,Catalogue newCatalogue) throws CatalogueNotFoundException;
    Catalogue createCatalogue(Catalogue catalogue);
}
