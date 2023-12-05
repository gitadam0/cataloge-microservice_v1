package com.example.Cataloguemicroservice.Services.Category;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;

import java.util.List;

public interface CategoryService {

    public List<Category> getCategorys();

    public void deleteCategory(Long id);
    public Category getCategoryByID(long id) throws MyEntityNotFoundException;

    public Category updateCategory(long id,Category newCategory) throws MyEntityNotFoundException;


    public Category createCategory(Category catalogue);
}
