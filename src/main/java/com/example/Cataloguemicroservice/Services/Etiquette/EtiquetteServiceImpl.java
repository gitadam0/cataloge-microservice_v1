package com.example.Cataloguemicroservice.Services.Etiquette;

import com.example.Cataloguemicroservice.Entities.Catalogue;
import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Exceptions.CatalogueNotFoundException;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.CatalogueRepository;
import com.example.Cataloguemicroservice.Repository.EtiquetteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EtiquetteServiceImpl implements EtiquetteService{

    private EtiquetteRepository etiquetteRepository;
    @Autowired
    public EtiquetteServiceImpl(EtiquetteRepository etiquetteRepository) {
        this.etiquetteRepository = etiquetteRepository;
    }

    @Override
    public List<Etiquette> getEtiquettes() {
        return etiquetteRepository.findAll();
    }
    @Override
    public void deleteEtiquette(Long id) {
        etiquetteRepository.deleteById(id);
    }

    public Etiquette getEtiquetteByID(long id) throws EntityNotFoundException {
        Optional<Etiquette> optionalEtiquette = etiquetteRepository.findById(id);
        return optionalEtiquette.orElseThrow(() -> new EntityNotFoundException("Etiquette not found for ID: " + id));
    }
    @Override
    public Etiquette updateEtiquette(long id,Etiquette newEtiquette) throws EntityNotFoundException {
        Etiquette etiquette = etiquetteRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Etiquette not found to update for ID: " + id));
        etiquette.setNomEtiquette(newEtiquette.getNomEtiquette());
        etiquette.setProduits(newEtiquette.getProduits());

        return etiquetteRepository.save(etiquette);
    }

    @Override
    public Etiquette createEtiquette(Etiquette etiquette) {
        return etiquetteRepository.save(etiquette);
    }

}
