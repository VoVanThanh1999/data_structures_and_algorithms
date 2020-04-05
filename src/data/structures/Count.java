package data.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count {

	static int commonCharacterCount(String s1, String s2) {
		int dem = 0;
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		for (int i = 0; i < sb1.length(); i++) {
			for (int j = 0; j < sb2.length(); j++) {
				char a = sb1.charAt(i);
				char b = sb2.charAt(j);
				if (a == b) {
					sb1.deleteCharAt(i);
					sb2.deleteCharAt(j);
					i--;
					j--;
					dem++;
					break;
				}
			}
		}
		return dem;

	}

	static boolean checkEqualFrequency(int[] inputArray) {
		try {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int temp = 0;
			int count = 0;
			int count1 = 0;
			for (int i = 0; i < inputArray.length; i++) {
				temp = 0;
				for (int j = 0; j < inputArray.length; j++) {
					if (inputArray[i] / inputArray[j] == 1 && inputArray[i] % inputArray[j] == 0)
						temp++;
				}
				if (map.isEmpty()) {
					map.put(inputArray[i], temp);
				} else {
					map.put(inputArray[i], temp);
				}
			}
			int a[] = new int[map.size()];
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				a[count] = entry.getValue();
				count++;
			}
			for (int i = 0; i < a.length; i++) {
				if (a[0] != a[i]) {
					count1++;
				}
			}
			if (count1 == 0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	static int differentSymbolsNaive(String s) {
		try {
			StringBuilder stringBuilder = new StringBuilder(s);
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < stringBuilder.length(); i++) {
				map.put(s.charAt(i), i);
			}
			return map.size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	static boolean isPangram(String sentence) {
		try {
			Map<Integer, Character> map = new HashMap<>();
			String temp = sentence.toLowerCase();
			StringBuilder stringBuilder = new StringBuilder(temp.replace(" ", ""));
			int len = temp.length();
			System.out.println(len);
			map.put(0, 'a');
			map.put(1, 'b');
			map.put(2, 'c');
			map.put(3, 'd');
			map.put(4, 'e');
			map.put(5, 'f');
			map.put(6, 'g');
			map.put(7, 'h');
			map.put(8, 'i');
			map.put(9, 'j');
			map.put(10, 'k');
			map.put(11, 'l');
			map.put(12, 'm');
			map.put(13, 'n');
			map.put(14, 'o');
			map.put(15, 'p');
			map.put(16, 'q');
			map.put(17, 'r');
			map.put(18, 's');
			map.put(19, 't');
			map.put(20, 'u');
			map.put(21, 'v');
			map.put(22, 'w');
			map.put(23, 'y');
			map.put(24, 'z');

			System.out.println(map.size());
			for (int i = 0; i < 25; i++) {
				for (int j = 0; j < len; j++) {
					if (map.get(i) == stringBuilder.charAt(j)) {
						map.remove(i);
						break;
					}
				}
			}
			if (map.isEmpty()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return false;

	}

	static int differentSubstringsTrie(String inputString) {
		try {
			int count = 0;
			Map<String, Integer> map = new HashMap<>();
			for (int i = 1; i <= inputString.length(); i++) {
				count = i;
				for (int j = 0; j <= inputString.length(); j++) {
					if (count <= inputString.length()) {
						map.put(inputString.substring(j, count), i);
						count = count + 1;
					}
				}
			}
			return map.size();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}

	static int countCouple(int[] a) {
		int count1 = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], a[i]);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = 0;
			for (int i = 0; i < a.length; i++) {
				if (entry.getKey() == a[i]) {
					count++;
				}
			}
			while (count > 1) {
				count1++;
				count = count - 2;

			}
		}
		return count1;
	}

	static int bookDays(int[] a) {
		try {
			int count1 = 0;
			List<Float> list = new ArrayList<>();
			for (int i = 0; i < a.length; i++) {
				float temp = 0;
				int count = 0;

				for (int j = 0; j <= i; j++) {
					temp += a[j];
					count++;
				}
				temp = temp / count;
				list.add(temp);
			}

			for (int i = 1; i <= a.length; i++) {
				if (list.get(i) > list.get(i - 1)) {
					count1++;
				}
			}
			return count1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	static int countOx(int[] a, int k) {
		try {
			int count = 0;
			
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					continue;
				}
				if ((a[i]-reverseNumber(a[i]))%k==0) {
					count ++;
				}
			}
			return count;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	static int reverseNumber(int n) {
		int reverse = 0;
		while (n != 0) {
			reverse = reverse * 10;
			reverse = reverse + n % 10;
			n = n / 10;
		}
		return reverse;
	}
	
	static	int helpMe(int n, int m) {
		return -1;
	}

	static int contest(int[] a, int k) {
		if (k==a.length) {
			k=k-1;
		}
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int temp = a[k];
			if (a[i]>=k && a[i]>0) {
				count++;
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {

		int a[] = {16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};


	}

}
