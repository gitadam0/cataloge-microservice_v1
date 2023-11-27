package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.Catalogue;
import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Exceptions.ProductNotFoundException;
import com.example.Cataloguemicroservice.Services.Catalogue.CatalogueService;
import com.example.Cataloguemicroservice.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogue")

public class CatalogueController {

    private final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping
    public List<Catalogue> getAllCatalogue() {
        return catalogueService.getCatalogues();
    }

    @GetMapping("/{id}")
    public Catalogue getProductById(@PathVariable Long id) throws EntityNotFoundException {
        return catalogueService.getCatalogueByID(id);
    }



}
