package com.example.Cataloguemicroservice.Mapper;

import com.example.Cataloguemicroservice.DTO.ProduitDTO;
import com.example.Cataloguemicroservice.Entities.Produit;

public class ProductMapper {
    public static ProduitDTO entityToDTO(Produit produit) {
        ProduitDTO dto = new ProduitDTO();
        dto.setId(produit.getIdProduit());
        dto.setNomProduit(produit.getNomProduit());
        dto.setPrixProduit(produit.getPrixProduit());
        dto.setVarieties(produit.getVarieties());
        dto.setEtiquette(produit.getEtiquette());
        dto.setCategory(produit.getCategory());
        return dto;
    }

    public static Produit dtoToEntity(ProduitDTO dto) {
        Produit produit = new Produit();
        produit.setIdProduit(dto.getId());
        produit.setNomProduit(dto.getNomProduit());
        produit.setPrixProduit(dto.getPrixProduit());
        produit.setVarieties(dto.getVarieties());
        produit.setEtiquette(dto.getEtiquette());
        produit.setCategory(dto.getCategory());
        return produit;
    }
}
