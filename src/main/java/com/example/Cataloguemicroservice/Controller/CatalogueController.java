package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.Catalogue;

import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Services.Catalogue.CatalogueService;
import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Services.Catalogue.CatalogueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalogues")
public class CatalogueController {
    private final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping
    public List<Catalogue> getAllCatalogues() {
        return catalogueService.getCatalogues();
    }

    @GetMapping("/{id}")
    public Catalogue getCatalogueByID(@PathVariable Long id) throws EntityNotFoundException {
        return catalogueService.getCatalogueByID(id);
    }

    @PostMapping
    public Catalogue createCatalogue(@RequestBody Catalogue catalogue) {
        return catalogueService.createCatalogue(catalogue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCatalogue(@PathVariable Long id) {
        catalogueService.deleteCatalogue(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Catalogue updateCatalogue(@PathVariable Long id, @RequestBody Catalogue catalogue) throws EntityNotFoundException {
        return catalogueService.updateCatalogue(id, catalogue);
    }
}
