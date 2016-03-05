package com.liaocm.algorithmtest;

import java.util.ArrayList;

//火车调度程序
public class ScheduleTrain {

	public static ArrayList<String> outTrain(
			ArrayList<String> stationArrayList,
			ArrayList<String> sourceArrayList) {
		ArrayList<String> copystation = new ArrayList<String>(stationArrayList);
		ArrayList<String> copysource = new ArrayList<String>(sourceArrayList);
		String outTrainString = copystation.get(copystation.size()-1);
		copystation.remove(copystation.size()-1);
		ArrayList<String> subretArrayList = scheduleTrain(copystation,
				copysource);
		ArrayList<String> outputArrayList = new ArrayList<String>();
		for (int subretIndex = 0; subretIndex < subretArrayList.size(); subretIndex++) {
			outputArrayList.add(outTrainString
					+ subretArrayList.get(subretIndex));
		}
		return outputArrayList;

	}

	public static ArrayList<String> enterTrain(
			ArrayList<String> stationArrayList,
			ArrayList<String> sourceArrayList) {
		ArrayList<String> copystation = new ArrayList<String>(stationArrayList);
		ArrayList<String> copysource = new ArrayList<String>(sourceArrayList);
		copystation.add(copysource.get(copysource.size()-1));
		copysource.remove(copysource.size()-1);
		return scheduleTrain(copystation, copysource);
	}

	public static ArrayList<String> scheduleTrain(
			ArrayList<String> stationArrayList,
			ArrayList<String> sourceArrayList) {
		if (stationArrayList.isEmpty() && sourceArrayList.isEmpty()) {
			ArrayList<String> endStrings = new ArrayList<String>();
			endStrings.add("");
			return endStrings;
		}
		ArrayList<String> copystation = new ArrayList<String>(stationArrayList);
		ArrayList<String> copysource = new ArrayList<String>(sourceArrayList);
		// 车站中没有车，还有待入站的车,将火车入站
		if (copystation.isEmpty() && !copysource.isEmpty()) {
			
			return enterTrain(copystation, copysource);
		}
		// 已经没有可以入站的车，将车站的火车弹出
		if (!copystation.isEmpty() && copysource.isEmpty()) {
			return outTrain(copystation,copysource);
		}
		// 车站里有车且外面还有等待的车的时候，分为出站和入站两种情况
		// 出站
		ArrayList<String> subretOutTrainArrayList = outTrain(copystation,copysource);
//		入站
		ArrayList<String> subretEnterTrainArrayList = enterTrain(copystation, copysource);
	    subretOutTrainArrayList.addAll(subretEnterTrainArrayList);
	    return subretOutTrainArrayList;
	}
}
