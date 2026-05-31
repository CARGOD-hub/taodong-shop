package com.ylw.service.goods.mapper;

import com.ylw.service.goods.mapper.entity.ProductDo;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductMapper {

	@Select("SELECT ID AS id, CATEGORY_ID AS categoryId, NAME AS name, SUBTITLE AS subtitle, MAIN_IMAGE AS mainImage, SUB_IMAGES AS subImages, DETAIL AS detail, ATTRIBUTE_LIST AS attributeList, PRICE AS price, STOCK AS stock, STATUS AS status FROM product WHERE STATUS=1")
	List<ProductDo> getProductList();

	@Select("SELECT ID AS id, CATEGORY_ID AS categoryId, NAME AS name, SUBTITLE AS subtitle, MAIN_IMAGE AS mainImage, SUB_IMAGES AS subImages, DETAIL AS detail, ATTRIBUTE_LIST AS attributeList, PRICE AS price, STOCK AS stock, STATUS AS status FROM product WHERE ID=#{id}")
	ProductDo getProductDetail(@Param("id") Integer id);

}
