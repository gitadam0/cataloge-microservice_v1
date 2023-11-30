package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;
import com.example.Cataloguemicroservice.Mapper.CategoryMapperDto;
import com.example.Cataloguemicroservice.Services.Category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapperDto categoryMapperDto;

    public CategoryController(CategoryService categoryService,CategoryMapperDto categoryMapperDto) {

        this.categoryService = categoryService;
        this.categoryMapperDto=categoryMapperDto;
    }

    @GetMapping
    public List<Category> getAllCategorys() {
        return categoryService.getCategorys();
    }

    @GetMapping("/{id}")
    public Category getCategoryByID(@PathVariable Long id) throws EntityNotFoundException {
        return categoryService.getCategoryByID(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category catalogue) {
        return categoryService.createCategory(catalogue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("id")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category catalogue) throws EntityNotFoundException {
        return categoryService.updateCategory(id, catalogue);
    }
}
