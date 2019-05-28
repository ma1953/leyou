package com.leyou.controller;

import com.leyou.service.SpecificationService;
import dao.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spec")
public class SpecificationController {
    @Autowired
    SpecificationService  specificationService;
    public ResponseEntity<String> querySpecificationByCategoryId(@RequestParam(value = "id") Long id){
        Specification spec=      specificationService.querySpecificationByCategoryId(id);
        if(spec==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok(spec.getSpecifications());
    }
}
