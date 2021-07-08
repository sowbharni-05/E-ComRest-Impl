package com.banfico.EcomApplication.mapper;

import com.banfico.EcomApplication.entity.CategoryEntity;
import com.banfico.EcomApplication.model.Category;


public class CategoryMapper {
    public static CategoryEntity DtoToEntity(Category category) {
        return new CategoryEntity()
                .setCategoryName(category.getCategoryName())
                .setProducts(category.getProducts());
    }
    public static Category EntityToDto(CategoryEntity categoryEntity) {
        return new Category().setCategoryId(categoryEntity.getCategoryId())
                .setCategoryName(categoryEntity.getCategoryName())
                .setProducts(categoryEntity.getProducts());

    }
}
