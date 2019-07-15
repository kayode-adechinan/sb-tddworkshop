package com.adechinan.dev.sbtddworkshop;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;



public class CategoryControllerTests {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        categoryController = new CategoryController(categoryService);
    }

    @Test
    public void addShouldReturnCategoryResponse(){

        CategoryResponse categoryResponse = new CategoryResponse();
        CategoryRequest categoryRequest = new CategoryRequest();

        when(categoryService.save(categoryRequest)).thenReturn(categoryResponse);

        assertThat(categoryController.add(categoryRequest)).isInstanceOf(CategoryResponse.class);


    }

}
