package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
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
    public Etiquette getEtiquetteById(@PathVariable Long id) throws MyEntityNotFoundException {
        return etiquetteService.getEtiquetteByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEtiquette(@PathVariable Long id) {
        etiquetteService.deleteEtiquette(id);
    }
    @DeleteMapping("/ids")
    public void deleteEtiquettes(@RequestBody List<Long> ids) {

        try {
            etiquetteService.deleteEtiquetteIfNotUsed(ids.get(0));
        } catch (MyEntityNotFoundException e) {
            throw new RuntimeException(e);
        }


        //etiquetteService.deleteEtiquettes(ids);
    }

    @PostMapping
    public Etiquette createEtiquette(@RequestBody Etiquette etiquette) {
        return etiquetteService.createEtiquette(etiquette);
    }

    @PutMapping("/{id}")
    public Etiquette updateEtiquette(@PathVariable Long id, @RequestBody Etiquette etiquette) throws MyEntityNotFoundException {
        return etiquetteService.updateEtiquette(id, etiquette);
    }
}
