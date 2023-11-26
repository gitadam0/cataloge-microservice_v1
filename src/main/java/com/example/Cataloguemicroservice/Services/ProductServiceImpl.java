package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Exceptions.ProductNotFoundException;
import com.example.Cataloguemicroservice.Repository.ProduitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProduitRepository produitRepository;

    public ProductServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit createProduct(Produit product) {
        return produitRepository.save(product);
    }

    @Override
    public Produit updateProduct(Long id, Produit updateProduit) throws ProductNotFoundException {
        Produit existingProduct = produitRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
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
    public Produit getProductById(Long id) throws ProductNotFoundException {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Produit> getProducts() {
        return produitRepository.findAll();
    }
}
