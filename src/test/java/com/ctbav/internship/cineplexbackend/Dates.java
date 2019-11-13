package com.ctbav.internship.cineplexbackend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import com.ctbav.internship.cineplexbackend.DTO.ScheduleDTO;

public class Dates {
	ScheduleDTO schedule=new ScheduleDTO();

	@Test
	public void test() {
		String hour="12:30";
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String strDate = formatter.format(hour);
		try {
			Date date = formatter.parse(strDate);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
