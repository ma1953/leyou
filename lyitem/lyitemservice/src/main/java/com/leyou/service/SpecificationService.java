package com.leyou.service;

import com.leyou.mapper.SpecificationMapper;
import dao.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationService {
    @Autowired
    SpecificationMapper  specificationMapper;
    public Specification querySpecificationByCategoryId(Long id) {

            return   specificationMapper.selectByPrimaryKey(id);
    }
}
