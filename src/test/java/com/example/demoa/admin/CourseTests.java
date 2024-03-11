package com.example.demoa.admin;


import com.example.demoa.entity.admin.Course;
import com.example.demoa.enums.Category;
import com.example.demoa.enums.Level;
import com.example.demoa.exception.CourseNotFoundException;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.serviceimplementation.CourseServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseTests {
	@Autowired
	private CourseServiceImp courseServiceImp;

//	----------------------ADD----------------------
	@Test
	void testAddCourseForRightArgument(){
		System.out.println("test case for Adding Course if Right Data Passed");
		Course course = new Course( "Beauty Parlour", "Basic Beauty Parlour Course", 2, Level.BASIC, Category.COURSE, 14000.0);
		Assertions.assertEquals("Course added successfully", courseServiceImp.add(course));
	}
	@Test
	void testAddCourseForNullArgument(){
		System.out.println("test case for Adding Course if 'null' is Passed as an argument");
		Assertions.assertThrows(InvalidArgumentException.class, ()-> courseServiceImp.add(null));
	}

//  ----------------------UPDATE----------------------

	@Test
	void testUpdateCourseForRightArgument(){
		System.out.println("test case for Updating Course if Right Data Passed");
		Integer id = 4;
		Course course = new Course( "Beauty Parlour", "Basic Beauty Parlour Course", 2, Level.BASIC, Category.COURSE, 14000.0);
		Assertions.assertEquals("Course Updated", courseServiceImp.update(id, course));
	}
	@Test
	void testUpdateCourseForIdNotPresent(){
		System.out.println("test case for Updating Course when order with id not present");
		Integer id = 1002;
		Course course = new Course( "Beauty Parlour", "Basic Beauty Parlour Course", 2, Level.BASIC, Category.COURSE, 14000.0);
		Assertions.assertThrows(CourseNotFoundException.class, ()-> courseServiceImp.update(id, course));
	}
	@Test
	void testUpdateCourseForNullArgument(){
		System.out.println("test case for Updating Course if null object is passed");
		Integer id = 6;
		Assertions.assertThrows(InvalidArgumentException.class, ()-> courseServiceImp.update(id, null));
	}


//	----------------------DELETE----------------------
	@Test
	void testDeleteCourseForRightArgument(){
		System.out.println("test case for Deleting Course when right id is passed");
		Integer id = 6;
		Assertions.assertEquals("Deleted", courseServiceImp.delete(id));
	}
	@Test
	void testDeleteCourseForWrongArgument(){
		System.out.println("test case for Deleting Course when wrong id is passed");
		Integer id = 1005;
		Assertions.assertThrows(CourseNotFoundException.class, ()-> courseServiceImp.delete(id));
	}

//	----------------------READ----------------------
	@Test
	void testReadCourseForRightArgument(){
		System.out.println("test case for Reading Course when right id is passed");
		Integer id = 3;
		Course course = courseServiceImp.read(id);
		Assertions.assertEquals(course.getCourseId(), courseServiceImp.read(id).getCourseId());
		Assertions.assertEquals(course.getCourseCost(), courseServiceImp.read(id).getCourseCost());
	}


	@Test
	void testReadCourseForWrongArgument(){
		System.out.println("test case for Reading Course when wrong id is passed");
		Integer id = 10005;
		Assertions.assertThrows(CourseNotFoundException.class, ()-> courseServiceImp.read(id));
	}

// 	----------------------READALL----------------------

}
