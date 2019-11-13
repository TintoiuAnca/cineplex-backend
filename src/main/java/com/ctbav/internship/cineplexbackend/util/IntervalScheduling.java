package com.ctbav.internship.cineplexbackend.util;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctbav.internship.cineplexbackend.models.Schedule;
import com.ctbav.internship.cineplexbackend.repositories.MovieRepository;
import com.ctbav.internship.cineplexbackend.repositories.ScheduleRepository;

public class IntervalScheduling {
	
	public void findOptimalSchedule(Schedule[] schedules) throws ParseException {
		System.out.println("Input schedules: \t" + Arrays.toString(schedules));
		Arrays.sort(schedules); // sort schedules by finish time
		LinkedList<Schedule> schedulesSelected = new LinkedList<Schedule>();
		schedulesSelected.add(schedules[0]); // add 1st schedule
		Schedule lastScheduleAdded = schedules[0];
		for (int i = 1; i < schedules.length; i++) {
			 if((schedules[i].getStartTime()).compareTo(lastScheduleAdded.getEndTime())>0) { //check if schedule is compatible (starts after or at the time time as the last schedule finishes)
			schedulesSelected.add(schedules[i]);
			lastScheduleAdded = schedules[i]; // update for the movie that was just added
		}
		}

		System.out.println("\nSelected " + schedulesSelected.size() + " Schedules: ");
		for (Schedule schedule : schedulesSelected) {
			System.out.println(schedule);
		}

	}
}
