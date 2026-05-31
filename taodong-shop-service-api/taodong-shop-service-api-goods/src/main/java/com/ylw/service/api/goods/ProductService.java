package com.ylw.service.api.goods;

import com.ylw.api.product.dto.output.ProductDto;
import com.ylw.common.web.core.entity.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/product")
public interface ProductService {

	@GetMapping("/list")
	BaseResponse<List<ProductDto>> getProductList();

	@GetMapping("/detail/{id}")
	BaseResponse<ProductDto> getProductDetail(@PathVariable("id") Integer id);

}
