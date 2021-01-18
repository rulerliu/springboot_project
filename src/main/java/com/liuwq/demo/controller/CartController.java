package com.liuwq.demo.controller;

import com.liuwq.demo.service.ICartService;
import com.liuwq.demo.vo.CartVo;
import com.liuwq.demo.vo.ResponseVo;
import form.CartAddForm;
import form.CartUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 廖师兄
 */
@RestController
public class CartController {
    @Autowired
    ICartService cartService;

    @PostMapping("/add")
    public ResponseVo<CartVo> add(@RequestBody CartAddForm cartAddForm) {
     //   User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return cartService.add(6, cartAddForm);
    }

    @GetMapping("/carts")
    public ResponseVo<CartVo> list() {
        return cartService.list(6);
    }

    @PutMapping("/carts/{productId}")
    public ResponseVo<CartVo> update(@PathVariable Integer productId,
                                     @RequestBody CartUpdateForm form
                                     ) {

        return cartService.update(6, productId, form);
    }

    @DeleteMapping("/cartsdelete/{productId}")
    public ResponseVo<CartVo> delete(@PathVariable Integer productId) {

        return cartService.delete(6, productId);
    }

    @PutMapping("/carts/selectAll")
    public ResponseVo<CartVo> selectAll() {

        return cartService.selectAll(6);
    }

    @PutMapping("/carts/unSelectAll")
    public ResponseVo<CartVo> unSelectAll() {
        return cartService.unSelectAll(6);
    }

    @GetMapping("/carts/products/sum")
    public ResponseVo<Integer> sum() {

        return cartService.sum(6);
    }


}
