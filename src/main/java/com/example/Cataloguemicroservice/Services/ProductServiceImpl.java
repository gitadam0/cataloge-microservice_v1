package com.example.Cataloguemicroservice.Services;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Etiquette;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.EtiquetteRepository;
import com.example.Cataloguemicroservice.Repository.ProductRepository;
import com.example.Cataloguemicroservice.Repository.VarietyRepository;
import com.example.Cataloguemicroservice.Services.Category.CategoryService;
import com.example.Cataloguemicroservice.transformers.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final EtiquetteRepository etiquetteRepository;
    private final CategoryService categoryService;
    private final VarietyRepository varietyRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, EtiquetteRepository etiquetteRepository, CategoryService categoryService, VarietyRepository varietyRepository) {
        this.productRepository = productRepository;
        this.etiquetteRepository = etiquetteRepository;
        this.categoryService = categoryService;
        this.varietyRepository = varietyRepository;
    }
//    @Override
//    public ProductDTO createProduct(ProductDTO product) throws EntityNotFoundException {
//        //solution for the category object name raltion with the product
//       Product producto =  productRepository.save(ProductTransformer.transformToEntity(product));
//       producto.setCategory(categoryService.getCategoryByID(product.getCategoryID()));
//        return product;
//    }
@Override
public ProductDTO createProduct(ProductDTO product) throws MyEntityNotFoundException {
    Product producto = ProductTransformer.transformToEntity(product);
    producto.setCategory(categoryService.getCategoryByID(product.getCategoryID()));

    return ProductTransformer.transformToDTO(productRepository.save(producto));
}

    @Override
    public List<ProductDTO> createProducts(List<ProductDTO> products) {
        productRepository.saveAll(ProductTransformer.transformListToEntityList(products));
        return products;
    }
    @Override
    public ProductDTO updateProduct(Long id, ProductDTO updatedProductDTO) throws MyEntityNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new MyEntityNotFoundException("Product not found with id: " + id));
        Product updatedProduct = ProductTransformer.transformToEntity(updatedProductDTO);
        existingProduct.setNomProduct(updatedProduct.getNomProduct());
        existingProduct.setPrixProduct(updatedProduct.getPrixProduct());
        existingProduct.setVarieties(updatedProduct.getVarieties());
        existingProduct.setEtiquettes(updatedProduct.getEtiquettes());
        existingProduct.setCategory(updatedProduct.getCategory());
        productRepository.save(existingProduct);
        return updatedProductDTO;
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public ProductDTO getProductById(Long id) throws MyEntityNotFoundException {
        Product p = productRepository.findById(id)
                .orElseThrow(() -> new MyEntityNotFoundException("Product not found with id: " + id));
        return ProductTransformer.transformToDTO(p);
    }
    @Override
    public List<Product> getProducts() {
        //return ProductTransformer.transformListToDTOList(productRepository.findAll()) ;
        return productRepository.findAll() ;
    }
    @Override
    public ProductDTO addEtiquette(Long id, Long idEtiquette) throws MyEntityNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new MyEntityNotFoundException("Product not found with id: " + id));
        Etiquette existingEtiquette = etiquetteRepository.findById(idEtiquette)
                .orElseThrow(() -> new MyEntityNotFoundException("Etiquette not found with id: " + idEtiquette));
        existingProduct.getEtiquettes().add(existingEtiquette);
        productRepository.save(existingProduct);
        return ProductTransformer.transformToDTO(existingProduct);
    }
    @Override
    public ProductDTO addVariety(Long id, Long idVariety) throws MyEntityNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new MyEntityNotFoundException("Product not found with id: " + id));
        Variety existingVariety = varietyRepository.findById(idVariety)
                .orElseThrow(() -> new MyEntityNotFoundException("Variety not found with id: " + idVariety));
        existingProduct.getVarieties().add(existingVariety);
        return ProductTransformer.transformToDTO(productRepository.save(existingProduct));
    }

    @Override
    public Product findProductByNom(String productName) {

        return productRepository.findProductBynomProduct(productName);
    }
}