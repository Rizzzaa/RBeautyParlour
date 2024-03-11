package com.example.demoa;


import com.example.demoa.entity.Order;
import com.example.demoa.enums.Status;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.exception.OrderNotFoundException;
import com.example.demoa.serviceimplementation.OrderServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
class OrderTests {
	@Autowired
	private OrderServiceImp orderServiceImp;

//	----------------------ADD----------------------
	@Test
	void testAddOrderForValidArgument(){
		System.out.println("test case for Adding Order if Valid Data Passed");
		Order order = new Order( 1, 3, LocalDate.EPOCH, Status.BOOKED,2000.0, 3);
		Assertions.assertEquals("Order successful", orderServiceImp.addOrder(order));
	}
	@Test
	void testAddOrderForNullArgument(){
		System.out.println("test case for Adding Item in Cart if 'null' is Passed as an argument");
		Assertions.assertThrows(InvalidArgumentException.class, ()-> orderServiceImp.addOrder(null));
	}

//  ----------------------UPDATE----------------------

	@Test
	void testUpdateOrderForValidArgument(){
		System.out.println("test case for Updating Order if Valid Data Passed");
		Integer id = 4;
		Order order = new Order( 3, LocalDate.EPOCH, Status.BOOKED,2000.0, 3);
		Assertions.assertEquals("Order Updated", orderServiceImp.updateOrder(id, order));
	}
	@Test
	void testUpdateOrderForIdNotPresent(){
		System.out.println("test case for Updating Order when order with id not present");
		Integer id = 1002;
		Order order = new Order();
		Assertions.assertThrows(OrderNotFoundException.class, ()-> orderServiceImp.updateOrder(id, order));
	}
	@Test
	void testUpdateOrderForNullArgument(){
		System.out.println("test case for Updating Order if 'null' is Passed as an argument");
		Integer id = 6;
		Assertions.assertThrows(InvalidArgumentException.class, ()-> orderServiceImp.updateOrder(id, null));
	}


//	----------------------DELETE----------------------
	@Test
	void testDeleteOrderForValidArgument(){
		System.out.println("test case for Deleting Order when Valid id is passed");
		Integer id = 12;
		Assertions.assertEquals("Order Deleted", orderServiceImp.deleteOrder(id));
	}
	@Test
	void testDeleteOrderForInvalidArgument(){
		System.out.println("test case for Deleting Order when Invalid id is passed");
		Integer id = 1005;
		Assertions.assertThrows(OrderNotFoundException.class, ()-> orderServiceImp.deleteOrder(id));
	}

//	----------------------READ----------------------
	@Test
	void testReadOrderForValidArgument(){
		System.out.println("test case for Reading Order when Valid id is passed");
		Integer id = 9;
		Order order = orderServiceImp.readOrder(id);
		Assertions.assertEquals(order.getId(), orderServiceImp.readOrder(id).getId());
		Assertions.assertEquals(order.getTotalCost(), orderServiceImp.readOrder(id).getTotalCost());
	}


	@Test
	void testReadOrderForInvalidArgument(){
		System.out.println("test case for Reading Order when Invalid id is passed");
		Integer id = 10005;
		Assertions.assertThrows(OrderNotFoundException.class, ()-> orderServiceImp.readOrder(id));
	}

// 	----------------------READALL----------------------

}
