package com.example.Cataloguemicroservice.Controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Cataloguemicroservice.DTO.ProductDTO;
import com.example.Cataloguemicroservice.Services.MessagingService.YourMessagingService;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.jms.MessageSender;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
class ProductControllerDiffblueTest {
    @MockBean
    private MessageSender messageSender;

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @MockBean
    private YourMessagingService yourMessagingService;

    /**
     * Method under test:  {@link ProductController#getProductById(Long)}
     */
    @Test
    void testGetProductById() throws Exception {
        when(productService.getProductById(Mockito.<Long>any())).thenReturn(new ProductDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/products/{id}", 1L);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"idProduct\":null,\"name\":null,\"description\":null,\"prixProduct\":0.0,\"categoryID\":null}"));
    }

    /**
     * Method under test: {@link ProductController#createProductInStock(ProductDTO)}
     */
    @Test
    void testCreateProductInStock() throws Exception {
        doNothing().when(messageSender).sendProduct(Mockito.<ProductDTO>any());
        when(productService.createProduct(Mockito.<ProductDTO>any())).thenReturn(new ProductDTO());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryID(1L);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setIdProduct(1L);
        productDTO.setName("Name");
        productDTO.setPrixProduct(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(productDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/products/createProductInStock")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"idProduct\":null,\"name\":null,\"description\":null,\"prixProduct\":0.0,\"categoryID\":null}"));
    }

    /**
     * Method under test:  {@link ProductController#updateProduct(Long, ProductDTO)}
     */
    @Test
    void testUpdateProduct() throws Exception {
        when(productService.updateProduct(Mockito.<Long>any(), Mockito.<ProductDTO>any())).thenReturn(new ProductDTO());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryID(1L);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setIdProduct(1L);
        productDTO.setName("Name");
        productDTO.setPrixProduct(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(productDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/products/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"idProduct\":null,\"name\":null,\"description\":null,\"prixProduct\":0.0,\"categoryID\":null}"));
    }

    /**
     * Method under test:  {@link ProductController#addEtiquette(Long, Long)}
     */
    @Test
    void testAddEtiquette() throws Exception {
        when(productService.addEtiquette(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(new ProductDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/products/addEtiquette/{id}/{idEtiquette}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"idProduct\":null,\"name\":null,\"description\":null,\"prixProduct\":0.0,\"categoryID\":null}"));
    }

    /**
     * Method under test:  {@link ProductController#addVariety(Long, Long)}
     */
    @Test
    void testAddVariety() throws Exception {
        when(productService.addVariety(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(new ProductDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/products/addVariety/{id}/{idVariety}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"idProduct\":null,\"name\":null,\"description\":null,\"prixProduct\":0.0,\"categoryID\":null}"));
    }

    /**
     * Method under test: {@link ProductController#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct() throws Exception {
        doNothing().when(productService).deleteProduct(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/products/{id}", 1L);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ProductController#deleteProduct(Long)}
     */
    @Test
    void testDeleteProduct2() throws Exception {
        doNothing().when(productService).deleteProduct(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/products/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test:  {@link ProductController#createMultiProduct(List)}
     */
    @Test
    void testCreateMultiProduct() throws Exception {
        when(productService.createProducts(Mockito.<List<ProductDTO>>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/api/products/createMultiProduct")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ArrayList<>()));
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:  {@link ProductController#createProduct(ProductDTO)}
     */
    @Test
    void testCreateProduct() throws Exception {
        when(productService.getProducts()).thenReturn(new ArrayList<>());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategoryID(1L);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setIdProduct(1L);
        productDTO.setName("Name");
        productDTO.setPrixProduct(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(productDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:  {@link ProductController#getAllProducts()}
     */
    @Test
    void testGetAllProducts() throws Exception {
        when(productService.getProducts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/products");
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
