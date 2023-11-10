package com.example.Cataloguemicroservice.Mapper;

import com.example.Cataloguemicroservice.DTO.CategoryDTO;
import com.example.Cataloguemicroservice.DTO.ProduitDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Produit;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDTO entityToDTO(Category category) {
        CategoryDTO catDto = new CategoryDTO();
        catDto.setIdCategory(category.getIdCategory());
        catDto.setNomCategory(category.getNomCategory());


         List<ProduitDTO> produitDTOs = category.getProduits().stream()
            .map(ProduitMapper::entityToDTO) // Assuming you have a ProduitMapper
            .collect(Collectors.toList());
         catDto.setProduits(produitDTOs);


        return catDto;
    }

    public static Category dtoToEntity(CategoryDTO dto) {
        Category categoryDto = new Category();
        categoryDto.setIdCategory(dto.getIdCategory());
        categoryDto.setNomCategory(dto.getNomCategory());

         List<Produit> produits = dto.getProduits().stream()
            .map(ProduitMapper::dtoToEntity) // Assuming you have a ProduitMapper
            .collect(Collectors.toList());
         categoryDto.setProduits(produits);


        return categoryDto;
    }
}
