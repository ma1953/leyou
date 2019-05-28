package com.leyou.controller;

import com.leyou.service.BrandService;
import dao.Brand;
import leyou.common.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService  brandService;
    @GetMapping ("page")
    public ResponseEntity<ResultPage<Brand>>  queryBrandByPageAndSort(
            @RequestParam(name = "page",defaultValue = "1") Integer page,
            @RequestParam(name = "rows",defaultValue = "5") Integer rows,
            @RequestParam(name = "sortBy",required = false) String sortBy,
            @RequestParam(name = "desc",required = false)   Boolean desc,
            @RequestParam(name = "key",required = false)  String key){
        ResultPage<Brand> brandResultPage = this.brandService.queryBrandByPageAndSort(page, rows, sortBy, desc, key);
        if(brandResultPage==null||brandResultPage.getItems().size()==0){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(brandResultPage.toString());
        return   ResponseEntity.ok(brandResultPage);
    }

    @PostMapping
    public  ResponseEntity<Void> saveBrand(Brand brand,@RequestParam("categories") List<Long> categories){
          brandService.saveBrand(brand,categories);
          return  new  ResponseEntity<>(HttpStatus.CREATED);
    }
}
