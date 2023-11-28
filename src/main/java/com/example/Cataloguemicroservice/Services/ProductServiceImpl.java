package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.EtiquetteRepository;
import com.example.Cataloguemicroservice.Repository.ProduitRepository;
import com.example.Cataloguemicroservice.Repository.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProduitRepository produitRepository;
    private final EtiquetteRepository etiquetteRepository;
    private final VarietyRepository varietyRepository;

    @Autowired
    public ProductServiceImpl(ProduitRepository produitRepository,EtiquetteRepository etiquetteRepository,VarietyRepository varietyRepository) {
        this.produitRepository = produitRepository;
        this.etiquetteRepository = etiquetteRepository;
        this.varietyRepository = varietyRepository;
    }

    @Override
    public Produit createProduct(Produit product) {
        return produitRepository.save(product);
    }

    @Override
    public Produit updateProduct(Long id, Produit updateProduit) throws EntityNotFoundException {
        Produit existingProduct = produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        existingProduct.setNomProduit(updateProduit.getNomProduit());
        existingProduct.setPrixProduit(updateProduit.getPrixProduit());
        existingProduct.setVarieties(updateProduit.getVarieties());
        existingProduct.setEtiquettes(updateProduit.getEtiquettes());
        existingProduct.setCategory(updateProduit.getCategory());

        return produitRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        produitRepository.deleteById(id);

    }

    @Override
    public Produit getProductById(Long id) throws EntityNotFoundException {
        return produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Produit> getProducts() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addEtiquette(Long id,Long idEtiquette) throws EntityNotFoundException {
        Produit existingProduct = produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        Etiquette existingEtiquette = etiquetteRepository.findById(idEtiquette)
                .orElseThrow(() -> new EntityNotFoundException("Etiquette not found with id: " + idEtiquette));

        existingProduct.getEtiquettes().add(existingEtiquette);
        return produitRepository.save(existingProduct);
    }

    @Override
    public Produit addVariety(Long id,Long idVariety) throws EntityNotFoundException {
        Produit existingProduct = produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        Variety existingVariety = varietyRepository.findById(idVariety)
                .orElseThrow(() -> new EntityNotFoundException("Variety not found with id: " + idVariety));

        existingProduct.getVarieties().add(existingVariety);
        return produitRepository.save(existingProduct);
    }


}
