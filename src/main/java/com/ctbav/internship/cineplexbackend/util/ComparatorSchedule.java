package com.ctbav.internship.cineplexbackend.util;

import java.text.ParseException;
import java.util.Comparator;
import com.ctbav.internship.cineplexbackend.DTO.ScheduleDTO;
import com.ctbav.internship.cineplexbackend.models.Schedule;


public class ComparatorSchedule implements Comparator<ScheduleDTO> {

	@Override
	public int compare(ScheduleDTO o1, ScheduleDTO o2) {
		try {
			return o1.getStartTime().compareTo(o2.getStartTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;

	}

}
