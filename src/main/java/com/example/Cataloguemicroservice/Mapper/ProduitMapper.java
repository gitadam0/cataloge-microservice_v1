package com.example.Cataloguemicroservice.Mapper;

import com.example.Cataloguemicroservice.DTO.CategoryDTO;
import com.example.Cataloguemicroservice.DTO.EtiquetteDTO;
import com.example.Cataloguemicroservice.DTO.ProduitDTO;
import com.example.Cataloguemicroservice.DTO.VarietyDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Entities.Produit;
import com.example.Cataloguemicroservice.Entities.Variety;

import java.util.Set;
import java.util.stream.Collectors;

public class ProduitMapper {
    public static ProduitDTO entityToDTO(Produit produit) {
        ProduitDTO dto = new ProduitDTO();
        dto.setIdProduit(produit.getIdProduit());
        dto.setNomProduit(produit.getNomProduit());
        dto.setPrixProduit(produit.getPrixProduit());

        // Convert the Set<Variety> to Set<VarietyDTO>
        Set<VarietyDTO> varietyDTOs = produit.getVarieties().stream()
                .map(VarietyMapper::entityToDTO) // Use your mapping method for Variety
                .collect(Collectors.toSet());

        dto.setVarieties(varietyDTOs);

        // Map Etiquette to EtiquetteDTO using EtiquetteMapper
        EtiquetteDTO etiquetteDTO = EtiquetteMapper.entityToDTO(produit.getEtiquette());
        dto.setEtiquette(etiquetteDTO);

        // Map Category to CategoryDTO using CategoryMapper
        CategoryDTO categoryDTO = CategoryMapper.entityToDTO(produit.getCategory());
        dto.setCategory(categoryDTO);
        return dto;
    }


    public static Produit dtoToEntity(ProduitDTO dto) {
        Produit produit = new Produit();
        produit.setIdProduit(dto.getIdProduit());
        produit.setNomProduit(dto.getNomProduit());
        produit.setPrixProduit(dto.getPrixProduit());

        // Convert the Set<VarietyDTO> to Set<Variety>
        Set<Variety> varieties = dto.getVarieties().stream()
                .map(VarietyMapper::dtoToEntity) // Use your mapping method for Variety
                .collect(Collectors.toSet());
        produit.setVarieties(varieties);

        Etiquette etiquette = EtiquetteMapper.dtoToEntity(dto.getEtiquette());
        produit.setEtiquette(etiquette);
        Category category = CategoryMapper.dtoToEntity(dto.getCategory());
        produit.setCategory(category);
        return produit;
    }

}
