package com.example.demoa.user;

import com.example.demoa.entity.user.ServiceBooking;
import com.example.demoa.enums.Status;
import com.example.demoa.exception.BookingNotFoundException;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.serviceimplementation.ServiceBookingServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;



@SpringBootTest
class ServiceBookingTests {
	@Autowired
	private ServiceBookingServiceImp serviceBookingServiceImp;

	//	----------------------ADD----------------------
	@Test
	void testAddBookingForValidArgument(){
		System.out.println("test case for Adding Service Booking if Valid Data Passed");
		ServiceBooking serviceBooking = new ServiceBooking(LocalDate.parse("2024-03-03"), Status.BOOKED, 500.0, 4,5);
		Assertions.assertEquals("Service Booked", serviceBookingServiceImp.addServiceBooking(serviceBooking));
	}
	@Test
	void testAddBookingForNullArgument(){
		System.out.println("test case for Adding Service Booking if 'null' is Passed as an argument");
		Assertions.assertThrows(InvalidArgumentException.class, ()-> serviceBookingServiceImp.addServiceBooking(null));
	}



//  ----------------------UPDATE----------------------

	@Test
	void testUpdateBookingForValidArgument(){
		System.out.println("test case for Updating Order if Valid Data Passed");
		Integer id = 1;
		ServiceBooking serviceBooking = new ServiceBooking(LocalDate.parse("2024-03-03"), Status.BOOKED, 500.0, 4,5);
		Assertions.assertEquals("Booking Updated", serviceBookingServiceImp.updateServiceBooking(id, serviceBooking));
	}
	@Test
	void testUpdateBookingForIdNotPresent(){
		System.out.println("test case for Updating Order when order with id not present");
		Integer id = 1002;
		ServiceBooking serviceBooking = new ServiceBooking();
		Assertions.assertThrows(BookingNotFoundException.class, ()-> serviceBookingServiceImp.updateServiceBooking(id, serviceBooking));
	}
	@Test
	void testUpdateBookingForNullArgument(){
		System.out.println("test case for Updating Order if null is passed as order");
		Integer id = 6;
		Assertions.assertThrows(InvalidArgumentException.class, ()-> serviceBookingServiceImp.updateServiceBooking(id, null));
	}


	//	----------------------DELETE----------------------
	@Test
	void testCancelBookingForValidArgument(){
		System.out.println("test case for Canceling Booking when Valid id is passed");
		Integer id = 1;
		Assertions.assertEquals("Booking Cancelled", serviceBookingServiceImp.cancelServiceBooking(id));
	}
	@Test
	void testCancelBookingForInvalidArgument(){
		System.out.println("test case for Canceling Booking when Invalid id is passed");
		Integer id = 1005;
		Assertions.assertThrows(BookingNotFoundException.class, ()-> serviceBookingServiceImp.cancelServiceBooking(id));
	}

	//	----------------------READ----------------------
	@Test
	void testReadBookingForValidArgument(){
		System.out.println("test case for Reading Booking when Valid id is passed");
		Integer id = 1;
		ServiceBooking serviceBooking = serviceBookingServiceImp.readServiceBooking(id);
		Assertions.assertEquals(serviceBooking.getEmployeeId(), serviceBookingServiceImp.readServiceBooking(id).getEmployeeId());
		Assertions.assertEquals(serviceBooking.getTotalCost(), serviceBookingServiceImp.readServiceBooking(id).getTotalCost());
	}

	@Test
	void testReadBookingForInvalidArgument(){
		System.out.println("test case for Reading Booking when Invalid id is passed");
		Integer id = 10005;
		Assertions.assertThrows(BookingNotFoundException.class, ()-> serviceBookingServiceImp.readServiceBooking(id));
	}

// 	----------------------READALL----------------------


}