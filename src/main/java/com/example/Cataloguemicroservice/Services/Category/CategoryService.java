package com.example.Cataloguemicroservice.Services.Category;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Exceptions.EntityNotFoundException;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryByID(long id) throws EntityNotFoundException;
}
