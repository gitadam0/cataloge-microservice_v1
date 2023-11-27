package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Services.Variety.VarietyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/varietys")
public class VarietyController {

    private final VarietyService varietyService;

    public VarietyController(VarietyService varietyService) {
        this.varietyService = varietyService;
    }

    @GetMapping
    public List<Variety> getAllCatalogues() {
        return varietyService.getVarietys();
    }

    @GetMapping("/{id}")
    public Variety getCatalogueByID(@PathVariable Long id) throws EntityNotFoundException {
        return varietyService.getVarietyByID(id);
    }

    @PostMapping
    public Variety createCatalogue(@RequestBody Variety variety) {
        return varietyService.createVariety(variety);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCatalogue(@PathVariable Long id) {
        varietyService.deleteVariety(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Variety updateCatalogue(@PathVariable Long id, @RequestBody Variety variety) throws EntityNotFoundException {
        return varietyService.updateVariety(id, variety);
    }
}
