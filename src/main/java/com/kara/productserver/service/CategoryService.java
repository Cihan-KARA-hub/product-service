package com.kara.productserver.service;

import com.kara.productserver.entity.Category;

public interface CategoryService {
    Category getCategory(Integer id);
    void saveCategory(Category category);
}
