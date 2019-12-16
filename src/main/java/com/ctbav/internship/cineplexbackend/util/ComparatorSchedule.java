package com.ctbav.internship.cineplexbackend.util;

import java.text.ParseException;
import java.util.Comparator;

import com.ctbav.internship.cineplexbackend.models.Schedule;

public class ComparatorSchedule implements Comparator<Schedule> {

	@Override
	public int compare(Schedule o1, Schedule o2) {
		try {
			return o1.getStartTime().compareTo(o2.getStartTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;

	}

}