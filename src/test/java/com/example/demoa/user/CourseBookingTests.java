package com.example.demoa.user;


import com.example.demoa.entity.user.CourseBooking;
import com.example.demoa.enums.Status;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.exception.BookingNotFoundException;
import com.example.demoa.serviceimplementation.CourseBookingServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class CourseBookingTests {
	@Autowired
	private CourseBookingServiceImp courseBookingServiceImp;

	//	----------------------ADD----------------------
	@Test
	void testAddBookingForValidArgument(){
		System.out.println("test case for Adding booking if Valid Data Passed");
		LocalDate slotNo = LocalDate.of(2024, 4, 13);
		CourseBooking courseBooking = new CourseBooking(3, LocalDate.parse("2024-03-03"), 2000.0);

		Assertions.assertEquals("Course Booked", courseBookingServiceImp.addCourseBooking(courseBooking));
	}
	@Test
	void testAddBookingForNullArgument(){
		System.out.println("test case for Adding booking if 'null' is Passed as an argument");
		Assertions.assertThrows(InvalidArgumentException.class, ()-> courseBookingServiceImp.addCourseBooking(null));
	}

//  ----------------------UPDATE----------------------

	@Test
	void testUpdateBookingForValidArgument(){
		System.out.println("test case for Updating Booking if Valid Data Passed");
		Integer id = 2;
//		LocalDate slot = LocalDate.of(2024, 4, 13);
		CourseBooking courseBooking = new CourseBooking(LocalDate.of(2024, 4, 13), Status.BOOKED, 2,2000.0);
		Assertions.assertEquals("Booking Updated", courseBookingServiceImp.updateCourseBooking(id, courseBooking));
	}
	@Test
	void testUpdateBookingForIdNotPresent(){
		System.out.println("test case for Updating Booking when booking with id not present");
		Integer id = 1002;
		CourseBooking courseBooking = new CourseBooking();
		Assertions.assertThrows(BookingNotFoundException.class, ()-> courseBookingServiceImp.updateCourseBooking(id, courseBooking));
	}
	@Test
	void testUpdateBookingForNullArgument(){
		System.out.println("test case for Updating Booking if null is passed as booking");
		Integer id = 6;
		Assertions.assertThrows(InvalidArgumentException.class, ()-> courseBookingServiceImp.updateCourseBooking(id, null));
	}


	//	----------------------DELETE----------------------
	@Test
	void testCancelBookingForValidArgument(){
		System.out.println("test case for Canceling Booking when Valid id is passed");
		Integer id = 2;
		Assertions.assertEquals("Booking Canceled", courseBookingServiceImp.cancelCourseBooking(id));
	}

	@Test
	void testCancelBookingForInvalidArgument(){
		System.out.println("test case for Canceling Booking when Invalid id is passed");
		Integer id = 1005;
		Assertions.assertThrows(BookingNotFoundException.class, ()-> courseBookingServiceImp.cancelCourseBooking(id));
	}

	//	----------------------READ----------------------
	@Test
	void testReadCourseBookingForValidArgument(){
		System.out.println("test case for Reading Booking when Valid id is passed");
		Integer id = 2;
		CourseBooking courseBooking = courseBookingServiceImp.readCourseBooking(id);
		Assertions.assertEquals(courseBooking.getStatus(), courseBookingServiceImp.readCourseBooking(id).getStatus());
		Assertions.assertEquals(courseBooking.getTotalCost(), courseBookingServiceImp.readCourseBooking(id).getTotalCost());
	}


	@Test
	void testReadCourseBookingForInvalidArgument(){
		System.out.println("test case for Reading Booking when Invalid id is passed");
		Integer id = 10005;
		Assertions.assertThrows(BookingNotFoundException.class, ()-> courseBookingServiceImp.readCourseBooking(id));
	}

// 	----------------------READALL----------------------

}
