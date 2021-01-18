package com.liuwq.demo.service;


import com.liuwq.demo.entity.Cart;
import com.liuwq.demo.vo.CartVo;
import com.liuwq.demo.vo.ResponseVo;
import form.CartAddForm;
import form.CartUpdateForm;

import java.util.List;

/**
 * Created by 廖师兄
 */
public interface ICartService {

	ResponseVo<CartVo> add(Integer uid, CartAddForm form);

	ResponseVo<CartVo> list(Integer uid);

	ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

	ResponseVo<CartVo> delete(Integer uid, Integer productId);

	ResponseVo<CartVo> selectAll(Integer uid);

	ResponseVo<CartVo> unSelectAll(Integer uid);

	ResponseVo<Integer> sum(Integer uid);

	List<Cart> listForCart(Integer uid);

}
