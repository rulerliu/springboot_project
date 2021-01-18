package com.liuwq.demo.controller;

import com.liuwq.demo.service.ICartService;
import com.liuwq.demo.vo.CartVo;
import com.liuwq.demo.vo.ResponseVo;
import form.CartAddForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 廖师兄
 */
@RestController
public class CartController {
    @Autowired
    ICartService cartService;

    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@RequestBody CartAddForm cartAddForm) {
     //   User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return cartService.add(6, cartAddForm);
    }


}
