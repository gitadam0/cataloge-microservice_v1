package com.example.Cataloguemicroservice.Mapper;

import com.example.Cataloguemicroservice.DTO.EtiquetteDTO;
import com.example.Cataloguemicroservice.DTO.ProduitDTO;
import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Entities.Produit;

import java.util.List;
import java.util.stream.Collectors;

public class EtiquetteMapper {

    public static EtiquetteDTO entityToDTO(Etiquette etiquette) {
        EtiquetteDTO dto = new EtiquetteDTO();
        dto.setIdEtiquette(etiquette.getIdEtiquette());
        dto.setNomEtiquette(etiquette.getNomEtiquette());

        // You may need to handle the conversion of List<Produit> to List<ProduitDTO> here if needed
        // Example:
         List<ProduitDTO> produitDTOs = etiquette.getProduits().stream()
            .map(ProduitMapper::entityToDTO) // Assuming you have a ProduitMapper
            .collect(Collectors.toList());

         dto.setProduits(produitDTOs);


        return dto;
    }

    public static Etiquette dtoToEntity(EtiquetteDTO dto) {
        Etiquette etiquette = new Etiquette();
        etiquette.setIdEtiquette(dto.getIdEtiquette());
        etiquette.setNomEtiquette(dto.getNomEtiquette());

        // You may need to handle the conversion of List<ProduitDTO> to List<Produit> here if needed
        // Example:
         List<Produit> produits = dto.getProduits().stream()
            .map(ProduitMapper::dtoToEntity) // Assuming you have a ProduitMapper
            .collect(Collectors.toList());
         etiquette.setProduits(produits);

        return etiquette;
    }
}
