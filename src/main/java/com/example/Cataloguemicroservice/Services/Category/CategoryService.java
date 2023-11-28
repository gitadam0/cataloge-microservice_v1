package com.example.Cataloguemicroservice.Services.Category;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public List<Category> getCategorys();

    public void deleteCategory(Long id);
    public Category getCategoryByID(long id) throws EntityNotFoundException;

    public Category updateCategory(long id,Category newCategory) throws EntityNotFoundException;


    public Category createCategory(Category catalogue);
}
