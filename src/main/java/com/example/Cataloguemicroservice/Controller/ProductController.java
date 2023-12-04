package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Services.MessagingService.YourMessagingService;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.jms.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    private YourMessagingService messagingService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) throws EntityNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO product) throws EntityNotFoundException {
        return productService.createProduct(product);
    }

    @PostMapping("/createMultiProduct")
    public List<ProductDTO> createMultiProduct(@RequestBody List<ProductDTO> products) {
        return productService.createProducts(products);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO product) throws EntityNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addEtiquette/{id}/{idEtiquette}")
    public ProductDTO addEtiquette(@PathVariable Long id, @PathVariable Long idEtiquette) throws EntityNotFoundException {
        return productService.addEtiquette(id, idEtiquette);
    }

    @PostMapping("/addVariety/{id}/{idVariety}")
    public ProductDTO addVariety(@PathVariable Long id, @PathVariable Long idVariety) throws EntityNotFoundException {
        return productService.addVariety(id, idVariety);
    }

    @Autowired
    MessageSender messageSender;


    /*   @GetMapping("/Test")
       public String Test() throws EntityNotFoundException {
           messageSender.sendProduct(new ProductDTO(productService.getProductById(1L)) );

           return "OK";
       }
   */
/*    @PostMapping("/createProductInStock")
    public Product createProductInStock(@RequestBody Product product) throws EntityNotFoundException {
        Product p = productService.createProduct(product);
        messageSender.sendProduct(new ProductDTO(p));
        System.out.println(p.getCategory().getNomCategory());
        return p;
    }*/
    @PostMapping("/createProductInStock")
    public ProductDTO createProductInStock(@RequestBody ProductDTO productDTO) throws EntityNotFoundException {
        ProductDTO productdto = productService.createProduct(productDTO);
        messageSender.sendProduct(productdto);
        System.out.println(productdto.getName());
        return productdto;
    }


}
