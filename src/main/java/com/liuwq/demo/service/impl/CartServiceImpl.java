package com.liuwq.demo.service.impl;


import com.google.gson.Gson;
import com.liuwq.demo.dao.ProductMapper;
import com.liuwq.demo.entity.Cart;
import com.liuwq.demo.entity.Product;
import com.liuwq.demo.enums.ProductStatusEnum;
import com.liuwq.demo.enums.ResponseEnum;
import com.liuwq.demo.service.ICartService;
import com.liuwq.demo.vo.CartVo;
import com.liuwq.demo.vo.ResponseVo;
import form.CartAddForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements ICartService {
	private final static String CART_REDIS_KEY_TEMPLATE = "cart_%d";


	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private StringRedisTemplate redisTemplate;


    private Gson gson = new Gson();

	@Override
	public ResponseVo<CartVo> add(Integer uid, CartAddForm form) {

		Integer quantity = 1;
		Product product = productMapper.selectByPrimaryKey(form.getProductId());

		//商品是否存在
		if (product == null) {
			return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
		}

		//商品是否正常在售
		if (!product.getStatus().equals(ProductStatusEnum.ON_SALE.getCode())) {
			return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
		}

		//商品库存是否充足
		if (product.getStock() <= 0) {
			return ResponseVo.error(ResponseEnum.PROODUCT_STOCK_ERROR);
		}
        String redisKey= String.format(CART_REDIS_KEY_TEMPLATE,uid);

		HashOperations<String,String,String> opsForHash = redisTemplate.opsForHash();

		String value = opsForHash.get(redisKey,
				String.valueOf(product.getId())
		);

		Cart cart;

		if(StringUtils.isEmpty(value)){

			//没有该商品, 新增
			cart = new Cart(product.getId(), quantity, form.getSelected());
		//	System.out.println("cart.getQuantity()111==="+cart.getQuantity());
		} else{
			cart = gson.fromJson(value,Cart.class);
			cart.setQuantity(cart.getQuantity()+quantity);
		//	System.out.println("cart.getQuantity(222==="+cart.getQuantity());
		}


		 opsForHash.put(redisKey,
				 String.valueOf(product.getId()),
				 gson.toJson(cart));

		return null;
	}
}
