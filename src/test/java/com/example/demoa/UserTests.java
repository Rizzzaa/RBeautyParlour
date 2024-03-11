package com.example.demoa;


import com.example.demoa.entity.User;
import com.example.demoa.enums.Role;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.exception.UserNotFoundException;
import com.example.demoa.serviceimplementation.UserServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class UserTests {
	@Autowired
	private UserServiceImp userService;

//	----------------------ADD----------------------
	@Test
	void testAddUserForValidArgument(){
		System.out.println("test case for Adding User if Valid Data Passed");
		User user = new User("smyle@mail.com", "Smyle", "smyle", Role.STAFF);
		Assertions.assertEquals("User added successfully", userService.add(user));
	}
	@Test
	void testAddUserForNullArgument(){
		System.out.println("test case for Adding User if 'null' is Passed as an argument");
		Assertions.assertThrows(InvalidArgumentException.class, ()-> userService.add(null));
	}

//  ----------------------UPDATE----------------------

	@Test
	void testUpdateUserForValidArgument(){
		System.out.println("test case for Updating User if Valid Data Passed");
		Integer id = 4;
		User user = new User("smyle@mail.com", "Smyle", "smyle", Role.STAFF);
		Assertions.assertEquals("User Updated", userService.update(id, user));
	}
	@Test
	void testUpdateUserForIdNotPresent(){
		System.out.println("test case for Updating User when user with id is not present");
		Integer id = 1002;
		User user = new User();
		Assertions.assertThrows(UserNotFoundException.class, ()-> userService.update(id, user));
	}
	@Test
	void testUpdateUserForNullArgument(){
		System.out.println("test case for Updating User if 'null' is Passed as an argument");
		Integer id = 6;
		Assertions.assertThrows(InvalidArgumentException.class, ()-> userService.update(id, null));
	}


//	----------------------DELETE----------------------
	@Test
	void testDeleteUserForValidArgument(){
		System.out.println("test case for Deleting User when Valid id is passed");
		Integer id = 19;
		Assertions.assertEquals("User Deleted", userService.delete(id));
	}
	@Test
	void testDeleteUserForInvalidArgument(){
		System.out.println("test case for Deleting User when Invalid id is passed");
		Integer id = 1005;
		Assertions.assertThrows(UserNotFoundException.class, ()-> userService.delete(id));
	}

//	----------------------READ----------------------
	@Test
	void testReadUserForValidArgument(){
		System.out.println("test case for Reading User when Valid id is passed");
		Integer id = 9;
		User user = userService.read(id);
		Assertions.assertEquals(user.getUserId(), userService.read(id).getUserId());
		Assertions.assertEquals(user.getEmail(), userService.read(id).getEmail());
	}


	@Test
	void testReadUserForInvalidArgument(){
		System.out.println("test case for Reading User when Invalid id is passed");
		Integer id = 10005;
		Assertions.assertThrows(UserNotFoundException.class, ()-> userService.read(id));
	}

// 	----------------------READALL----------------------

}
