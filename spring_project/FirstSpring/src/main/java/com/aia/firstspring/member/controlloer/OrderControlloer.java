package com.aia.firstspring.member.controlloer;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.firstspring.domain.OrderCommand;

@Controller
@RequestMapping("/order/order")
public class OrderControlloer {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getOrderForm() {
		return "order/orderForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String orderComplete(OrderCommand order) {
		System.out.println("order: " + order);
		
		return "order/orderComplete";
	}

}
