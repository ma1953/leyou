package com.leyou.mapper;

import dao.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper   extends Mapper<Brand> {
    @Insert("insert into tb_category_brand(category_id, brand_id) values(#{cid},#{bid})")
    int inserCategoryBrand(@Param("cid") Long cid,@Param("bid") Long bid);
}
