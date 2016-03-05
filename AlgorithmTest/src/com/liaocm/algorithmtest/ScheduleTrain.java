package com.liaocm.algorithmtest;

import java.util.ArrayList;

//�𳵵��ȳ���
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
		// ��վ��û�г������д���վ�ĳ�,������վ
		if (copystation.isEmpty() && !copysource.isEmpty()) {
			
			return enterTrain(copystation, copysource);
		}
		// �Ѿ�û�п�����վ�ĳ�������վ�Ļ𳵵���
		if (!copystation.isEmpty() && copysource.isEmpty()) {
			return outTrain(copystation,copysource);
		}
		// ��վ���г������滹�еȴ��ĳ���ʱ�򣬷�Ϊ��վ����վ�������
		// ��վ
		ArrayList<String> subretOutTrainArrayList = outTrain(copystation,copysource);
//		��վ
		ArrayList<String> subretEnterTrainArrayList = enterTrain(copystation, copysource);
	    subretOutTrainArrayList.addAll(subretEnterTrainArrayList);
	    return subretOutTrainArrayList;
	}
}
