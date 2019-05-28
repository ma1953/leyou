package com.leyou.controller;

import com.leyou.service.CategoryService;
import dao.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService  categoryService;
    @GetMapping("list")
    public ResponseEntity<List<Category>>  queryCategoryListByParentId(@RequestParam("pid") Long pid ){
        List<Category> list = this.categoryService.queryCategoryListByParentId(pid);
        if (list == null) {
            // 没找到，返回404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
          // 找到返回200
        return ResponseEntity.ok(list);
    }
}
