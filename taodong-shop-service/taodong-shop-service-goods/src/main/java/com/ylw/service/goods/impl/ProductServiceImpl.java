package com.ylw.service.goods.impl;

import com.ylw.api.product.dto.output.ProductDto;
import com.ylw.common.web.core.api.BaseApiService;
import com.ylw.common.web.core.entity.BaseResponse;
import com.ylw.service.api.goods.ProductService;
import com.ylw.service.goods.mapper.ProductMapper;
import com.ylw.service.goods.mapper.entity.ProductDo;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductServiceImpl extends BaseApiService<List<ProductDto>> implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	@Override
	public BaseResponse<List<ProductDto>> getProductList() {
		List<ProductDo> productDoList = productMapper.getProductList();
		List<ProductDto> productDtoList = mapperFactory.getMapperFacade().mapAsList(productDoList, ProductDto.class);
		return setResultSuccess(productDtoList);
	}

	@Override
	public BaseResponse<ProductDto> getProductDetail(Integer id) {
		ProductDo productDo = productMapper.getProductDetail(id);
		if (productDo == null) {
			return setResultError("商品不存在");
		}
		ProductDto productDto = mapperFactory.getMapperFacade().map(productDo, ProductDto.class);
		return setResultSuccessData(productDto);
	}

}
