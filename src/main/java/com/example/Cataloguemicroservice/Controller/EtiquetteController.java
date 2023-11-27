package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Services.Etiquette.EtiquetteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquettes")
public class EtiquetteController {
    private final EtiquetteService etiquetteService;

    public EtiquetteController(EtiquetteService etiquetteService) {
        this.etiquetteService = etiquetteService;
    }

    @GetMapping
    public List<Etiquette> getAllEtiquettes() {
        return etiquetteService.getEtiquettes();
    }

    @GetMapping("/{id}")
    public Etiquette getEtiquetteById(@PathVariable Long id) throws EntityNotFoundException {
        return etiquetteService.getEtiquetteByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEtiquette(@PathVariable Long id) {
        etiquetteService.deleteEtiquette(id);
    }

    @PostMapping
    public Etiquette createEtiquette(@RequestBody Etiquette etiquette) {
        return etiquetteService.createEtiquette(etiquette);
    }

    @PutMapping("/{id}")
    public Etiquette updateEtiquette(@PathVariable Long id, @RequestBody Etiquette etiquette) throws EntityNotFoundException {
        return etiquetteService.updateEtiquette(id, etiquette);
    }
}
