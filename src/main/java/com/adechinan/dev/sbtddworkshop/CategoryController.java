package com.adechinan.dev.sbtddworkshop;

import java.util.Arrays;
import java.util.List;

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    public List<CategoryResponse> list() {
        return Arrays.asList();
    }

    public CategoryResponse add(CategoryRequest categoryRequest){
        return categoryService.save(categoryRequest);
    }

    public CategoryResponse get(int categoryId) {
        return new CategoryResponse();
    }

    public CategoryResponse edit(int categoryId) {
        return new CategoryResponse();
    }

    public String delete(int categoryId) {
        return "...";
    }
}
