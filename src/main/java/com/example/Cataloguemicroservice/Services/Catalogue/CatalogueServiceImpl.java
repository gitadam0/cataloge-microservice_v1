package com.example.Cataloguemicroservice.Services.Catalogue;

import com.example.Cataloguemicroservice.Entities.Catalogue;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    private CatalogueRepository catalogueRepository;
    @Autowired
    public CatalogueServiceImpl(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }
    @Override
    public List<Catalogue> getCatalogues() {
        return catalogueRepository.findAll();
    }
    @Override
    public void deleteCatalogue(Long id) {
        catalogueRepository.deleteById(id);
    }
    public Catalogue getCatalogueByID(long id) throws EntityNotFoundException {
        Optional<Catalogue> optionalCatalogue = catalogueRepository.findById(id);
        return optionalCatalogue.orElseThrow(() -> new EntityNotFoundException("Catalogue not found for ID: " + id));
    }
    @Override
    public Catalogue updateCatalogue(long id,Catalogue newCatalogue) throws EntityNotFoundException {
        Catalogue catalogue = catalogueRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Catalogue not found to update for ID: " + id));
        catalogue.setNomCatalogue(newCatalogue.getNomCatalogue());
        catalogue.setCategories(newCatalogue.getCategories());

        return catalogueRepository.save(catalogue);
    }

    @Override
    public Catalogue createCatalogue(Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
    }


}
