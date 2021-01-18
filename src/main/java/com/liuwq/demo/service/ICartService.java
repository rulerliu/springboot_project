package com.liuwq.demo.service;


import com.liuwq.demo.vo.CartVo;
import com.liuwq.demo.vo.ResponseVo;
import form.CartAddForm;

/**
 * Created by 廖师兄
 */
public interface ICartService {

	ResponseVo<CartVo> add(Integer uid, CartAddForm form);

}
