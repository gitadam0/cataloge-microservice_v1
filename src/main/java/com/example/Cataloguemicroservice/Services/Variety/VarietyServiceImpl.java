
package com.example.Cataloguemicroservice.Services.Variety;

import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.VarietyRepository;
import com.example.Cataloguemicroservice.Repository.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VarietyServiceImpl implements VarietyService{

    private VarietyRepository varietyRepository;
    @Autowired
    public VarietyServiceImpl(VarietyRepository varietyRepository) {
        this.varietyRepository = varietyRepository;
    }


    @Override
    public List<Variety> getVarietys() {
        return varietyRepository.findAll();
    }

    @Override
    public void deleteVariety(Long id) {
        varietyRepository.deleteById(id);
    }

    @Override
    public Variety getVarietyByID(long id) throws EntityNotFoundException {
        return varietyRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Variaty not found for id:"+id));
    }

    public Variety updateVariety(long id, Variety newVariety) throws EntityNotFoundException {
        Variety variety = varietyRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Variety not found to update for ID: " + id));
        variety.setVarietyName(newVariety.getVarietyName());
        variety.setProduits(newVariety.getProduits());

        return varietyRepository.save(variety);
    }

    @Override
    public Variety createVariety(Variety variety) {
        return varietyRepository.save(variety);
    }
}
