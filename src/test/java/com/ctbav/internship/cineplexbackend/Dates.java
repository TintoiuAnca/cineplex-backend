package com.ctbav.internship.cineplexbackend;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ctbav.internship.cineplexbackend.controllers.ScheduleController;
import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.ctbav.internship.cineplexbackend.util.IntervalScheduling;

@ExtendWith(MockitoExtension.class)
public class Dates {

	@InjectMocks
	ScheduleController scheduleController;

	@Test
	public void test() throws ParseException {
		List<Schedule> schedules = scheduleController.list();
		IntervalScheduling interval = new IntervalScheduling();
		interval.findOptimalSchedule(schedules);

	}

}
