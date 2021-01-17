package com.liuwq.demo.service;


import com.github.pagehelper.PageInfo;
import com.liuwq.demo.vo.ProductDetailVo;
import com.liuwq.demo.vo.ResponseVo;

public interface IProductService {

//	ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);
//
	ResponseVo<ProductDetailVo> detail(Integer productId);
	ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);
}
