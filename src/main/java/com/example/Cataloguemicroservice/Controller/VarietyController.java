package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
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
    public List<Variety> getAllVarieties() {
        return varietyService.getVarietys();
    }

    @GetMapping("/{id}")
    public Variety getVarietyByID(@PathVariable Long id) throws MyEntityNotFoundException {
        return varietyService.getVarietyByID(id);
    }

    @PostMapping
    public Variety createVariety(@RequestBody Variety variety) {
        return varietyService.createVariety(variety);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVariety(@PathVariable Long id) {
        varietyService.deleteVariety(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public Variety updateVariety(@PathVariable Long id, @RequestBody Variety variety) throws MyEntityNotFoundException {
        return varietyService.updateVariety(id, variety);
    }
}
