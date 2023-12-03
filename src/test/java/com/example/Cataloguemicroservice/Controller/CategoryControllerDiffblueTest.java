package com.example.Cataloguemicroservice.Controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Services.Category.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CategoryController.class})
@ExtendWith(SpringExtension.class)
class CategoryControllerDiffblueTest {
    @Autowired
    private CategoryController categoryController;

    @MockBean
    private CategoryService categoryService;

    /**
     * Method under test: {@link CategoryController#getCategoryByID(Long)}
     */
    @Test
    void testGetCategoryByID() throws Exception {
        Category category = new Category();
        category.setIdCategory(1L);
        category.setNomCategory("Nom Category");
        category.setProducts(new ArrayList<>());
        when(categoryService.getCategoryByID(anyLong())).thenReturn(category);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/categories/{id}", 1L);
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"idCategory\":1,\"nomCategory\":\"Nom Category\"}"));
    }

    /**
     * Method under test:  {@link CategoryController#createCategory(Category)}
     */
    @Test
    void testCreateCategory() throws Exception {
        when(categoryService.getCategorys()).thenReturn(new ArrayList<>());

        Category category = new Category();
        category.setIdCategory(1L);
        category.setNomCategory("Nom Category");
        category.setProducts(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(category);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CategoryController#deleteCategory(Long)}
     */
    @Test
    void testDeleteCategory() throws Exception {
        doNothing().when(categoryService).deleteCategory(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/categories/{id}", 1L);
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CategoryController#deleteCategory(Long)}
     */
    @Test
    void testDeleteCategory2() throws Exception {
        doNothing().when(categoryService).deleteCategory(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/categories/{id}", 1L);
        requestBuilder.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test:  {@link CategoryController#getAllCategorys()}
     */
    @Test
    void testGetAllCategorys() throws Exception {
        when(categoryService.getCategorys()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/categories");
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CategoryController#updateCategory(Long, Category)}
     */
    @Test
    void testUpdateCategory() throws Exception {
        Category category = new Category();
        category.setIdCategory(1L);
        category.setNomCategory("Nom Category");
        category.setProducts(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(category);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/categories/id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }
}
