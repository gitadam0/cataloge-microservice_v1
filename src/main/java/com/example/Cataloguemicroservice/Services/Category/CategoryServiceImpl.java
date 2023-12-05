package com.example.Cataloguemicroservice.Services.Category;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    @Autowired
    public  CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }
    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    public Category getCategoryByID(long id) throws MyEntityNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new MyEntityNotFoundException("Category not found for ID: " + id));
    }
    @Override
    public Category updateCategory(long id,Category newCategory) throws MyEntityNotFoundException {
        Category category = categoryRepository.findById(id).orElseThrow(()->
                new MyEntityNotFoundException("Category not found to update for ID: " + id));
        category.setNomCategory(newCategory.getNomCategory());
        return categoryRepository.save(category);
    }

    @Override
    public Category createCategory(Category catalogue) {
        return categoryRepository.save(catalogue);
    }

}
