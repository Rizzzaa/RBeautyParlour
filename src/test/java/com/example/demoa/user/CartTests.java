package com.example.demoa.user;


import com.example.demoa.entity.user.Cart;
import com.example.demoa.enums.Category;
import com.example.demoa.enums.Company;
import com.example.demoa.exception.CartItemNotFoundException;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.serviceimplementation.CartServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CartTests {

	@Autowired
	private CartServiceImp cartServiceImp;


//  ----------------------ADD----------------------

	@Test
	void testAddCartItemForValidArgument(){
		System.out.println("test case for Adding Item in Cart if Valid Data Passed");
		Cart item = new Cart( 1, "facial", Company.NATURES, Category.FACIAL,2000.0);
		Assertions.assertEquals("Item Added", cartServiceImp.addCartItem(item));
	}
	@Test
	void testAddCartItemForNullArgument(){
		System.out.println("test case for Adding Item in Cart if 'null' is Passed as an argument");
//		InvalidArgumentException exceptionObject = new InvalidArgumentException();
//		Assertions.assertThrows(exceptionObject.getClass(), ()->cartService.addCartItem(item));
		Assertions.assertThrows(InvalidArgumentException.class, ()-> cartServiceImp.addCartItem(null));
	}




//  ----------------------UPDATE----------------------

	@Test
	void testUpdateCartItemForValidArgument(){
		System.out.println("test case for Updating Cart item if Valid Data Passed");
		Integer id = 4;
		Cart item = new Cart( 3, "facial", Company.NATURES, Category.FACIAL,2000.0);
		Assertions.assertEquals("Item Updated", cartServiceImp.updateCartItem(id, item));
	}
	@Test
	void testUpdateCartItemForIdNotPresent(){
		System.out.println("test case for Updating Cart item when item with id not present");
		Integer id = 1002;
		Cart item = new Cart();
		Assertions.assertThrows(CartItemNotFoundException.class, ()-> cartServiceImp.updateCartItem(id, item));
	}
	@Test
	void testUpdateCartItemForNullArgument(){
		System.out.println("test case for Updating Cart item if 'null' is Passed as an argument");
		Integer id = 6;
		Assertions.assertThrows(InvalidArgumentException.class, ()-> cartServiceImp.updateCartItem(id, null));
	}


	//	----------------------DELETE----------------------
	@Test
	void testDeleteCartItemForValidArgument(){
		System.out.println("test case for Deleting Cart item when Valid id is passed");
		Integer id = 2;
		Assertions.assertEquals("Item Deleted", cartServiceImp.deleteCartItem(id));
	}
	@Test
	void testDeleteCartItemForInvalidArgument(){
		System.out.println("test case for Deleting Cart item when item with id is not present");
		Integer id = 1005;
		Assertions.assertThrows(CartItemNotFoundException.class, ()-> cartServiceImp.deleteCartItem(id));
	}

	//	----------------------READ----------------------
	@Test
	void testReadCartItemForValidArgument(){
		System.out.println("test case for Reading Cart item when Valid id is passed");
		Integer id = 4;
		Cart item = cartServiceImp.readCartItem(id);
		Assertions.assertEquals(item.getId(), cartServiceImp.readCartItem(id).getId());
		Assertions.assertEquals(item.getItemCost(), cartServiceImp.readCartItem(id).getItemCost());
	}


	@Test
	void testReadCartItemForInvalidArgument(){
		System.out.println("test case for Reading Cart item when item with id is not present");
		Integer id = 106705;
		Assertions.assertThrows(CartItemNotFoundException.class, ()-> cartServiceImp.readCartItem(id));
	}




// 	----------------------READALL----------------------

	@Test
	void testReadAllCartItemForInvalidArgument(){
		System.out.println("test case for Reading Cart item when Invalid id is passed");
		Integer id = 106705;
		Assertions.assertThrows(CartItemNotFoundException.class, ()-> cartServiceImp.deleteCartItem(id));
	}

}
