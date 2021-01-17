package com.liuwq.demo.controller;


import com.liuwq.demo.service.ICategoryService;
import com.liuwq.demo.vo.CategoryVo;
import com.liuwq.demo.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	private ICategoryService icategoryService;

	@GetMapping("all")
	public ResponseVo<List<CategoryVo>> selectAll() {
		return icategoryService.selectAll();
	}

//	@GetMapping("all2")
//	public Set<Integer>  selectAll2() {
//		Set<Integer> sl = new HashSet();
//		icategoryService.findSubCategoryId(100001,sl);
//		return sl;
//	}

}
