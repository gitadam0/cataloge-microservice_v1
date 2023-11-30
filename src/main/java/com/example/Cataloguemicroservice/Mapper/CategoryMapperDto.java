package com.example.Cataloguemicroservice.Mapper;


import com.example.Cataloguemicroservice.DTO.request.CategoryRequestDto;
import com.example.Cataloguemicroservice.DTO.response.CategoryResponseDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import org.springframework.beans.BeanUtils;

public class CategoryMapperDto {
    public Category toDao(CategoryRequestDto categoryRequestDto){
        Category category=new Category();
        BeanUtils.copyProperties(categoryRequestDto,category);
        return category;
    }
    public CategoryResponseDTO fromDao(Category category){
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        BeanUtils.copyProperties(category,categoryResponseDTO);
        return categoryResponseDTO;

    }

}
