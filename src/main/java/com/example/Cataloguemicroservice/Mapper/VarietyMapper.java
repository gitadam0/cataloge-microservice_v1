package com.example.Cataloguemicroservice.Mapper;

import com.example.Cataloguemicroservice.DTO.ProduitDTO;
import com.example.Cataloguemicroservice.DTO.VarietyDTO;
import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Entities.Variety;

import java.util.Set;
import java.util.stream.Collectors;

public class VarietyMapper {

    public static VarietyDTO entityToDTO(Variety variety) {
        VarietyDTO dto = new VarietyDTO();
        dto.setIdVariety(variety.getIdVariety());
        dto.setVarietyName(variety.getVarietyName());

        // You may need to handle the Set<Produit> to Set<ProduitDTO> conversion here if needed
        // Example:
         Set<ProduitDTO> produitDTOs = variety.getProduits().stream()
            .map(ProduitMapper::entityToDTO) // Assuming you have a ProduitMapper
            .collect(Collectors.toSet());
         dto.setProduits(produitDTOs);

        return dto;
    }
    public static Variety dtoToEntity(VarietyDTO dto) {
        Variety variety = new Variety();
        variety.setIdVariety(dto.getIdVariety());
        variety.setVarietyName(dto.getVarietyName());

        // You may need to handle the conversion of Set<ProduitDTO> to Set<Produit> here if needed
        // Example:
        Set<Produit> produits = dto.getProduits().stream()
            .map(ProduitMapper::dtoToEntity)
            .collect(Collectors.toSet());
         variety.setProduits(produits);

        return variety;
    }
}
