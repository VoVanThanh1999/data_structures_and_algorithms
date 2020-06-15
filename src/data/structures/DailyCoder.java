package data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyCoder {
	
	
	public int[] problem06042020(int a[],int k){
		int temp[] = new int[1];
		for (int i = 0; i < a.length; i++) {
			boolean flag = false;
			for (int j = i+1; j < a.length; j++) {
				if (a[i]+a[j]==k) {
					temp[0] = a[i];
					temp[1] = a[j];
					flag = true;
				}
			}
			if (flag) {
				return temp;
			}
		} 
		return null;
	}
	public static List<Integer> sortElementsByFrequency(int input[]){
		List<Integer> rs = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> mCount = new HashMap<Integer, Integer>();
		Map<Integer, Boolean> mCheck = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			mCount.put(input[i], 0);
			mCheck.put(input[i], true);
		}
		for (int i = 0; i < input.length; i++) {
			if (mCount.containsKey(input[i])) {
				int val = mCount.get(input[i]);
				mCount.put(input[i], val+1);
			}
		}
		for (Map.Entry<Integer, Integer> integer : mCount.entrySet()) {
			list.add(integer.getValue());
		}
		Collections.sort(list,Collections.reverseOrder());
		for (int i = 0; i < list.size(); i++) {
			int val = list.get(i);
			int value = 0;
			boolean flag = false;
			for (int j = 0; j < input.length; j++) {
				if (mCount.containsKey(input[j]) && mCount.get(input[j])==val && mCheck.get(input[j])) {
					value = input[j];
					flag = true;
					mCheck.put(input[j], false);
					break;
				}
			}
			if (flag) {
				for (int j = 0; j < val; j++) {
					rs.add(value);
				}
			}
		}
		return rs;
	}
	public static void main(String[] args) {
		int	arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		System.out.println(sortElementsByFrequency(arr));
	}
}
