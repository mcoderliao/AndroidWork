package com.liaocm.algorithmtest;

import java.util.ArrayList;

public class AlgortithmTest {
	public static void main(String agrc[]) {
		ArrayList<String> stationArrayList = new ArrayList<String>();
		ArrayList<String> sourceArrayList = new ArrayList<String>();
		sourceArrayList.add("4");
		sourceArrayList.add("3");
		sourceArrayList.add("2");
		sourceArrayList.add("1");		
		ArrayList<String> testscheuleTrain = ScheduleTrain.scheduleTrain(
				stationArrayList, sourceArrayList);
		for (int scheduleIndex = 0; scheduleIndex < testscheuleTrain.size(); scheduleIndex++) {
			System.out.println(testscheuleTrain.get(scheduleIndex));

		}
	}
}
