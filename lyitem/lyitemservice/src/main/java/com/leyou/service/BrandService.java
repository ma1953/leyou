package com.leyou.service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.mapper.BrandMapper;
import dao.Brand;
import leyou.common.ResultPage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandMapper   brandMapper;
public ResultPage<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc, String key){
    PageHelper.startPage(page,rows);
      Example  example  =new Example(Brand.class);
    if(StringUtils.isNotBlank(key)){
        example.createCriteria().andLike("name","%"+key +"%").orEqualTo("letter");
    }
    if(StringUtils.isNotBlank(sortBy)){
       String  orderByClass= sortBy+(desc ? " DESC":" ASC");
       example.setOrderByClause(orderByClass);
    }
     Page<Brand> pageInfo= (Page<Brand>) brandMapper.selectByExample(example);
     return  new ResultPage<>(pageInfo.getTotal(),pageInfo);
}
    @Transactional
    public void saveBrand(Brand brand,List<Long> cids) {
        this.brandMapper.insertSelective(brand);
        for (Long cid : cids) {
            this.brandMapper.inserCategoryBrand(cid,brand.getId());
        }
    }
}
