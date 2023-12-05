package com.example.Cataloguemicroservice.Services.Etiquette;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.EtiquetteRepository;
import com.example.Cataloguemicroservice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetteServiceImpl implements EtiquetteService{

    private EtiquetteRepository etiquetteRepository;
    private ProductRepository productRepository;

    @Autowired
    public EtiquetteServiceImpl(EtiquetteRepository etiquetteRepository, ProductRepository productRepository) {
        this.etiquetteRepository = etiquetteRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Etiquette> getEtiquettes() {
        return etiquetteRepository.findAll();
    }
    @Override
    public void deleteEtiquette(Long id) {
        etiquetteRepository.deleteById(id);
    }

    @Override
    public void deleteEtiquetteIfNotUsed(Long id) throws MyEntityNotFoundException {
        Etiquette etiquette = etiquetteRepository.findById(id).orElseThrow(()->new MyEntityNotFoundException("ettiquet not found for id :"+id));
        if (etiquette != null && etiquette.getProducts().isEmpty()) {
            etiquetteRepository.delete(etiquette);
        } else {
            System.out.println("Etiquette is associated with products. Cannot delete.");
        }
    }

    public Etiquette getEtiquetteByID(long id) throws MyEntityNotFoundException {
        Optional<Etiquette> optionalEtiquette = etiquetteRepository.findById(id);
        return optionalEtiquette.orElseThrow(() -> new MyEntityNotFoundException("Etiquette not found for ID: " + id));
    }
    @Override
    public Etiquette updateEtiquette(long id,Etiquette newEtiquette) throws MyEntityNotFoundException {
        Etiquette etiquette = etiquetteRepository.findById(id).orElseThrow(()->
                new MyEntityNotFoundException("Etiquette not found to update for ID: " + id));
        etiquette.setNomEtiquette(newEtiquette.getNomEtiquette());
        etiquette.setProducts(newEtiquette.getProducts());

        return etiquetteRepository.save(etiquette);
    }

    @Override
    public Etiquette createEtiquette(Etiquette etiquette) {
        return etiquetteRepository.save(etiquette);
    }

}
