package com.leyou.mapper;

import dao.Category;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface CategoryMapper extends Mapper<Category> ,SelectByIdListMapper<Category,Long> {
}
