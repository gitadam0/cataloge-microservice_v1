package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.Entities.Catalogue;
import com.example.Cataloguemicroservice.Exceptions.CatalogueNotFoundException;
import com.example.Cataloguemicroservice.Repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogueServiceImpl implements CatalogueService {
    @Autowired
    private CatalogueRepository catalogueRepository;


    @Override
    public List<Catalogue> getCatalogues() {
        return catalogueRepository.findAll();
    }
    public Catalogue getCatalogueByID(long id) {
        Optional<Catalogue> optionalCatalogue = catalogueRepository.findById(id);
        return optionalCatalogue.orElseThrow(() -> new CatalogueNotFoundException("Catalogue not found for ID: " + id));
    }


}
