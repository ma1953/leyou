package com.leyou.service;

import com.leyou.mapper.CategoryMapper;
import dao.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByParentId(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return this.categoryMapper.select(category);
    }

    public List<String> queryNamesByIds(List<Long> ids) {
        List<Category> list = this.categoryMapper.selectByIdList(ids);
//        List<String> names = new ArrayList<>();
//        for (Category category : list) {
//            names.add(category.getName());
//        }
//        return names;
        return list.stream().map(category -> category.getName()).collect(Collectors.toList());
    }
}