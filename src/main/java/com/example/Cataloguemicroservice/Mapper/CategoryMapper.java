package com.example.Cataloguemicroservice.Mapper;

import com.example.Cataloguemicroservice.DTO.CategoryDTO;
import com.example.Cataloguemicroservice.DTO.ProduitDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Produit;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDTO entityToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setIdCategory(category.getIdCategory());
        dto.setNomCategory(category.getNomCategory());

        // You may need to handle the conversion of List<Produit> to List<ProduitDTO> here if needed
        // Example:
         List<ProduitDTO> produitDTOs = category.getProduits().stream()
            .map(ProduitMapper::entityToDTO) // Assuming you have a ProduitMapper
            .collect(Collectors.toList());
         dto.setProduits(produitDTOs);

        // You can also set the CatalogueDTO in a similar manner if needed

        return dto;
    }

    public static Category dtoToEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setIdCategory(dto.getIdCategory());
        category.setNomCategory(dto.getNomCategory());

        // You may need to handle the conversion of List<ProduitDTO> to List<Produit> here if needed
        // Example:
         List<Produit> produits = dto.getProduits().stream()
            .map(ProduitMapper::dtoToEntity) // Assuming you have a ProduitMapper
            .collect(Collectors.toList());
         category.setProduits(produits);

        // You can also set the Catalogue entity in a similar manner if needed

        return category;
    }
}
