package com.example.Cataloguemicroservice.Services.Category;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Exceptions.CategoryNotFoundException;
import com.example.Cataloguemicroservice.Exceptions.ProductNotFoundException;
import com.example.Cataloguemicroservice.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByID(long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));

    }

}
