package data.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Search {

	static int searchElement(int[] a, int n) {
		int c[] = selectionSort(a);
		int b[] = uniqueArray(c);
		Map<Integer, Integer> map = new HashMap<>();
		int temp = 0;
		int count = 1;
		while (count <= b.length) {
			map.put(count, b[count - 1]);
			count++;
		}
		if (map.get(n) != 0) {
			return map.get(n);
		}

		if (temp != 0) {
			return b[temp + 1];
		}
		return -1;
	}

	static int[] selectionSort(int[] b) {
		int temp = 0;
		int a[] = b;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	static int[] uniqueArray(int a[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			map.put(i, a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (map.get(i) == map.get(j)) {
					map.remove(i);
				}
			}
		}
		int b[] = new int[map.size()];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (i < map.size()) {
				b[i] = entry.getValue();
				i++;
			}

		}
		return b;
	}

	static int searchElement02(int a[][], int k) {
		try {
			Map<Integer, Integer> map = new HashMap<>();
			int[][] b = sortElement02(a);
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					System.err.print(a[i][j] + " ");
				}
			}

			int temp[] = new int[100];
			int count = 0;
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					temp[count] = b[i][j];
					count++;
				}
			}
			int s[] = uniqueArray(temp);
			int count1 = 1;
			while (count1 <= s.length) {
				map.put(count1, s[count1 - 1]);
				count1++;
			}

			if (k == 0) {
				return map.get(1);
			}
			if (map.get(k) != 0) {
				return map.get(k);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return -1;
	}

	static int[][] sortElement02(int a[][]) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = i + 1; k < a.length; k++) {
					for (int m = j + 1; m < a.length; m++) {
						if (a[i][j] > a[k][m]) {
							temp = a[i][j];
							a[i][j] = a[k][m];
							a[k][m] = temp;
						}
					}
				}
			}
		}
		return a;
	}

	static int[] missingValue(int[] a, int[] b) {
		int[] c = uniqueArray(b);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < c.length; i++) {
			map.put(i, c[i]);
		}
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			for (int i = 0; i < a.length; i++) {
				if (entry.getValue() == a[i]) {

					count++;
					break;
				}
			}
		}
		int temp[] = new int[map.size() - count];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() != null) {
				temp[i] = entry.getValue();
			}
		}
		return temp;
	}

	static boolean beautifulArray(int[] arr) {
		int count = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int j = 0; j < i; j++) {
				sum1 += arr[j];
			}
			for (int k = i + 1; k < arr.length; k++) {
				sum2 += arr[k];
			}
			if (sum1 == sum2) {
				count++;
			}
		}
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	static int differentValuesInMultiplicationTable2(int n, int m) {
		try {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					int temp = i * j;
					if (map.isEmpty()) {
						map.put(temp, temp);
					} else {
						map.put(temp, temp);
					}
				}
			}
			return map.size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	static boolean charactersRearrangement(String string1, String string2) {
		try {
			if (string1.length() != string2.length())
				return false;
			boolean check1 = checkCharacters(string1, string2);
			boolean check2 = checkCharacters(string2, string1);
			if (!check1 || !check2)
				return false;
			if (!check1 && !check2)
				return false;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	static boolean checkCharacters(String st1, String st2) {
		try {
			int count = 0;
			StringBuilder s1 = new StringBuilder(st1);
			StringBuilder s2 = new StringBuilder(st2);
			for (int i = 0; i < st1.length(); i++) {
				for (int j = 0; j < st1.length(); j++) {
					if (s1.charAt(i) == s2.charAt(j)) {
						count++;
						break;
					}
				}
			}
			if (count == st1.length()) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	
	public static void main(String[] args) {

		String s1 = "asddsa";
		String s2 = "dsaasd";
	

	}
}
