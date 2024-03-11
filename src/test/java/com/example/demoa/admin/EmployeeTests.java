package com.example.demoa.admin;


import com.example.demoa.entity.admin.Employee;
import com.example.demoa.enums.Availability;
import com.example.demoa.enums.Category;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.exception.EmployeeNotFoundException;
import com.example.demoa.serviceimplementation.EmployeeServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class EmployeeTests {
	@Autowired
	private EmployeeServiceImp employeeServiceImp;

//	----------------------ADD----------------------
	@Test
	void testAddEmployeeForValidArgument(){
		System.out.println("test case for Adding Employee if Valid Data Passed");
		Employee employee = new Employee("Radha", Category.HAIR, Availability.FREE);
		Assertions.assertEquals("Employee Added", employeeServiceImp.addEmployee(employee));
	}
	@Test
	void testAddEmployeeForNullArgument(){
		System.out.println("test case for Adding Employee if 'null' is Passed as an argument");
		Assertions.assertThrows(InvalidArgumentException.class, ()-> employeeServiceImp.addEmployee(null));
	}


//  ----------------------UPDATE----------------------
	@Test
	void testUpdateEmployeeForValidArgument(){
		System.out.println("test case for Updating Employee if Valid Data Passed");
		Integer id = 4;
		Employee employee = new Employee("Radha", Category.HAIR, Availability.FREE);
		Assertions.assertEquals("Employee Updated", employeeServiceImp.updateEmployee(id, employee));
	}


	@Test
	void testUpdateEmployeeForIdNotPresent(){
		System.out.println("test case for Updating Employee when employee with id is not present");
		Integer id = 1002;
		Employee employee = new Employee();
		Assertions.assertThrows(EmployeeNotFoundException.class, ()-> employeeServiceImp.updateEmployee(id, employee));
	}
	@Test
	void testUpdateEmployeeForNullArgument(){
		System.out.println("test case for Updating Employee if 'null' is Passed as an argument");
		Integer id = 6;
//		Employee employee = null;
//		Assertions.assertThrows(InvalidArgumentException.class, ()-> employeeServiceImp.updateEmployee(id, employee));
		Assertions.assertThrows(InvalidArgumentException.class, ()-> employeeServiceImp.updateEmployee(id, null));
	}




//	----------------------DELETE----------------------
	@Test
	void testDeleteEmployeeForValidArgument(){
		System.out.println("test case for Deleting Employee when Valid id is passed");
		Integer id = 2;
		Assertions.assertEquals("Employee Deleted", employeeServiceImp.deleteEmployee(id));
	}
	@Test
	void testDeleteEmployeeForIdNotPresent(){
		System.out.println("test case for Deleting Employee when employee with id is not present");
		Integer id = 1005;
		Assertions.assertThrows(EmployeeNotFoundException.class, ()-> employeeServiceImp.deleteEmployee(id));
	}

//	----------------------READ----------------------
	@Test
	void testReadEmployeeForValidArgument(){
		System.out.println("test case for Reading Employee when Valid arguments passed");
		Integer id = 4;
		Employee employee = employeeServiceImp.readEmployee(id);
		Assertions.assertEquals(employee.getEmployeeName(), employeeServiceImp.readEmployee(id).getEmployeeName());
		Assertions.assertEquals(employee.getSpeciality(), employeeServiceImp.readEmployee(id).getSpeciality());
	}


	@Test
	void testReadEmployeeForIdNotPresent(){
		System.out.println("test case for Reading Employee when employee with id is not present");
		Integer id = 10005;
		Assertions.assertThrows(EmployeeNotFoundException.class, ()-> employeeServiceImp.readEmployee(id));
	}

// 	----------------------READALL----------------------


}
