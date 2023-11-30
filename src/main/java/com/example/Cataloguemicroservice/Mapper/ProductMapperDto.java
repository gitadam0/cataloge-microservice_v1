package com.example.Cataloguemicroservice.Mapper;


import com.example.Cataloguemicroservice.DTO.request.EtiquetteRequestDto;
import com.example.Cataloguemicroservice.DTO.request.ProductRequestDto;
import com.example.Cataloguemicroservice.DTO.response.EtiquetteResponseDTO;
import com.example.Cataloguemicroservice.DTO.response.ProductResponseDTO;
import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Entities.Product;
import org.springframework.beans.BeanUtils;

public class ProductMapperDto {
    public Product toDao(ProductRequestDto productRequestDto){
        Product product =new Product();
        BeanUtils.copyProperties(productRequestDto,product);
        return product;

    }
    public ProductResponseDTO productResponseDTO (Product product){
        ProductResponseDTO productResponseDTO =new ProductResponseDTO();
        BeanUtils.copyProperties(product,productResponseDTO);
        return productResponseDTO;

    }

}
