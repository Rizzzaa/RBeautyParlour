package com.example.demoa.admin;


import com.example.demoa.entity.admin.Service;
import com.example.demoa.enums.Category;
import com.example.demoa.enums.Company;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.exception.ServiceNotFoundException;
import com.example.demoa.serviceimplementation.ServicesServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ServiceTests {
	@Autowired
	private ServicesServiceImp servicesServiceImp;

	//	----------------------ADD----------------------
	@Test
	void testAddServiceForValidArgument(){
		System.out.println("test case for Adding Service if Valid Data Passed");
		Service service = new Service("Makeup", Company.MAYBELLINE, Category.MAKEUP, 20000.0);
		Assertions.assertEquals("Service Added", servicesServiceImp.addService(service));
	}

	@Test
	void testAddServiceForNullArgument(){
		System.out.println("test case for Adding Service if 'null' is Passed as an argument");
		Assertions.assertThrows(InvalidArgumentException.class, ()-> servicesServiceImp.addService(null));
	}


//  ----------------------UPDATE----------------------

	@Test
	void testUpdateServiceForValidArgument(){
		System.out.println("test case for Updating Service if Valid Data Passed");
		Integer id = 4;
		Service service = new Service("MakeUp", Company.MAYBELLINE, Category.MAKEUP, 20000.0);
		Assertions.assertEquals("Service Updated", servicesServiceImp.updateService(id, service));
	}
	@Test
	void testUpdateServiceForIdNotPresent(){
		System.out.println("test case for Updating Service when order with id not present");
		Integer id = 1002;
		Service service = new Service();
		Assertions.assertThrows(ServiceNotFoundException.class, ()-> servicesServiceImp.updateService(id, service));
	}
	@Test
	void testUpdateServiceForNullArgument(){
		System.out.println("test case for Updating Service if null is passed as an argument");
		Integer id = 6;
		Assertions.assertThrows(InvalidArgumentException.class, ()-> servicesServiceImp.updateService(id, null));
	}


	//	----------------------DELETE----------------------
	@Test
	void testDeleteServiceForValidArgument(){
		System.out.println("test case for Deleting Service when Valid id is passed");
		Integer id = 12;
		Assertions.assertEquals("Service Deleted", servicesServiceImp.deleteService(id));
	}
	@Test
	void testDeleteServiceForInvalidArgument(){
		System.out.println("test case for Deleting Service when Invalid id is passed");
		Integer id = 1005;
		Assertions.assertThrows(ServiceNotFoundException.class, ()-> servicesServiceImp.deleteService(id));
	}

	//	----------------------READ----------------------
	@Test
	void testReadServiceForValidArgument(){
		System.out.println("test case for Reading Service when Valid id is passed");
		Integer id = 9;
		Service service = servicesServiceImp.readService(id);
		Assertions.assertEquals(service.getServiceName(), servicesServiceImp.readService(id).getServiceName());
		Assertions.assertEquals(service.getServiceCost(), servicesServiceImp.readService(id).getServiceCost());
	}


	@Test
	void testReadServiceForInvalidArgument(){
		System.out.println("test case for Reading Service when Invalid id is passed");
		Integer id = 10005;
		Assertions.assertThrows(ServiceNotFoundException.class, ()-> servicesServiceImp.readService(id));
	}

// 	----------------------READALL----------------------

}
