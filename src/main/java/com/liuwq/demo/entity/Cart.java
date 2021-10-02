package com.liuwq.demo.entity;

import com.google.common.util.concurrent.RateLimiter;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 廖师兄
 */
@Data
public class Cart {

	private Integer productId;

	private Integer quantity;

	private Boolean productSelected;

	public Cart() {
	}

	public Cart(Integer productId, Integer quantity, Boolean productSelected) {
		this.productId = productId;
		this.quantity = quantity;
		this.productSelected = productSelected;
	}

	public static void main(String[] args) {
		String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		RateLimiter limiter = RateLimiter.create(3.0); // 这里的1表示每秒允许处理的量为1个
		for (int i = 1; i <= 10; i++) {
			double waitTime = limiter.acquire(i);// 请求RateLimiter, 超过permits会被阻塞
			System.out.println("cutTime=" + System.currentTimeMillis() + " call execute:" + i + " waitTime:" + waitTime);
		}
		String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println("start time:" + start);
		System.out.println("end time:" + end);
	}
}
