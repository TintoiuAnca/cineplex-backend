package com.ctbav.internship.cineplexbackend.util;

import java.text.ParseException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.ctbav.internship.cineplexbackend.models.Schedule;

public class IntervalScheduling {

	public void findOptimalSchedule(List<Schedule> schedules) throws ParseException {
		// System.out.println("Input schedules: \t" + Arrays.toString(schedules));
//		schedules.sort(new ComparatorSchedule()); // sort schedules by finish time
//		LinkedList<Schedule> schedulesSelected = new LinkedList<Schedule>();
//		schedulesSelected.add(schedules.get(0)); // add 1st schedule
//		Schedule lastScheduleAdded = schedules.get(0);
//		for (int i = 1; i < schedules.size(); i++) {
//			if ((schedules.get(i).getStartTime()).compareTo(lastScheduleAdded.getEndTime()) > 0) { // check if schedule																					// finishes)
//				schedulesSelected.add(schedules.get(i));
//				lastScheduleAdded = schedules.get(i); // update for the movie that was just added
//			}
//		}
//
//		System.out.println("\nSelected " + schedulesSelected.size() + " Schedules: ");
//		for (Schedule schedule : schedulesSelected) {
//			System.out.println(schedule);
//		}

	}
}
