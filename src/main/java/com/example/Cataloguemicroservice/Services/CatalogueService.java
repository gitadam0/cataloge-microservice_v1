package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.Entities.Catalogue;

import java.util.List;
import java.util.Optional;

public interface CatalogueService {
    List<Catalogue> getCatalogues();
    Catalogue getCatalogueByID(long id);
}
