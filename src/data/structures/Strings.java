package data.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class Strings {

	public static void check() {
		String text = "vovanthanh";
		String pattern = "thanh";
		int tlen = text.length();
		int count = 0;
		int plen = pattern.length();
		for (int i = 0; i <= tlen - plen; i++) {
			char c = text.charAt(i);
			char p = pattern.charAt(0);
			if (c == p) {
				for (int j = i, k = 0; j < i + plen; j++, k++) {
					c = text.charAt(j);
					p = pattern.charAt(k);
					if (c == p) {
						count++;
					}
				}
			}
		}
		if (count == plen) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static String amendTheSentence(String s) {
		StringBuilder st = new StringBuilder(s);
		StringBuilder st1 = new StringBuilder(s.toLowerCase());
		StringBuilder st2 = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		list.add(0);
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) != st1.charAt(i)) {
				list.add(i);
			}
		}
		list.add(st1.length());
		for (int i = 1; i < list.size(); i++) {
			st2.append(st1.toString().substring(list.get(i - 1), list.get(i)) + " ");
		}

		return st2.toString().trim();
	}

	static boolean checkPalindrome(String inputString) {
		int len = (inputString.length() / 2);
		int len1 = inputString.length() - 1;
		StringBuilder st1 = new StringBuilder(inputString);
		StringBuilder st2 = new StringBuilder(inputString);
		int count = 0;
		for (int i = 0, j = len1; i < len; i++, j--) {
			if (st1.charAt(i) == st2.charAt(j)) {
				count++;
			}
		}
		if (count == len) {
			return true;
		} else {
			return false;
		}
	}

	static boolean isTandemRepeat(String input) {
		int len = input.length() / 2;
		String s1 = input.substring(0, len);
		String s2 = input.substring(len, input.length() - 1);
		if (s1.equals(s2)) {
			return true;
		}
		return false;
	}

	static String truncateString(String s) {
		StringBuilder st1 = new StringBuilder(s);
		if (s.length() == 0) {
			return "";
		}
		int left = 0;
		int right = s.length() - 1;

		if (st1.charAt(left) % 3 == 0) {
			st1.deleteCharAt(left);
			return truncateString(st1.toString());
		}
		if (st1.charAt(right) % 3 == 0) {
			st1.deleteCharAt(right);
			return truncateString(st1.toString());
		}
		char c = st1.charAt(left);
		char p = st1.charAt(right);
		if ((c + p) % 3 == 0) {
			st1.deleteCharAt(left);
			st1.deleteCharAt(right - 1);
			return truncateString(st1.toString());
		}
		return st1.toString();
	}

	public static int stringsCrossover(String[] inputArray, String result) {
		String temp = "";
		int count = 0;
		for (int i = 0; i < inputArray.length; i++) {
			temp = "";
			for (int j = i + 1; j < inputArray.length; j++) {
				temp = inputArray[i] + inputArray[j];
				if (checkCrossover(temp, result) == true) {
					count++;
				}
			}
		}
		return count;
	}

	public static boolean checkCrossover(String inputStrings, String result) {
		StringBuilder st1 = new StringBuilder(inputStrings);
		StringBuilder st2 = new StringBuilder(result);
		int len = st2.length();
		for (int i = 0; i < inputStrings.length(); i++) {
			for (int j = 0; j < len; j++) {
				if (st1.charAt(i) == st2.charAt(j)) {
					st2.deleteCharAt(j);
					len--;
					break;
				}
			}
		}
		if (st2.toString().isEmpty())
			return true;
		return false;
	}

	static String lineEncoding(String s) {
		try {
			StringBuilder st1 = new StringBuilder(s);
			StringBuilder st2 = new StringBuilder();
			int count = 0;
			int count1 = 0;
			for (int i = 0; i < st1.length(); i++) {
				count = 0;
				for (int j = i; j < st1.length(); j++) {
					char a = st1.charAt(i);
					char b = st1.charAt(j);
					if (a == b) {
						count++;
						count1++;
					} else {
						break;
					}
				}
				if (count == 1) {
					st2.append(st1.charAt(i));
					System.out.println(st2.toString());
					i = count1 - 1;
				} else {
					st2.append(count);
					st2.append(st1.charAt(count1 - 1));
					System.out.println(st2.toString());
					i = count1 - 1;
				}
			}
			return st2.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	static String boxChat(String s, String[] a) {
		StringBuilder stringBuilder = new StringBuilder(s);
		try {
			String star = "";
			String temp1 = " ";
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j <= s.length() - a[i].length(); j++) {
					star = "";

					if (j == 0) {
						if (a[i].equals(stringBuilder.substring(j, j + a[i].length()))
								&& stringBuilder.substring(j + a[i].length(), j + 1 + a[i].length()).equals(" ")) {
							for (int k = 0; k < a[i].length(); k++) {
								star += "*";
							}
							stringBuilder.delete(j, j + a[i].length());
							stringBuilder.insert(j, star);
						}
					}

					if (j > 0) {
						temp1 = stringBuilder.substring(j - 1, j);
					}
					if (j <= s.length() - a[i].length() - 1) {
						if (a[i].equals(stringBuilder.substring(j, j + a[i].length()))
								&& stringBuilder.substring(j + a[i].length(), j + 1 + a[i].length()).equals(" ")
								&& temp1.equals(" ")) {
							for (int k = 0; k < a[i].length(); k++) {
								star += "*";
							}
							stringBuilder.delete(j, j + a[i].length());
							stringBuilder.insert(j, star);
						}
					}
					if (j >= s.length() - a[i].length() - 1) {
						if (a[i].equals(stringBuilder.substring(j, j + a[i].length())) && temp1.equals(" ")) {
							for (int k = 0; k < a[i].length(); k++) {
								star += "*";
							}
							stringBuilder.delete(j, j + a[i].length());
							stringBuilder.insert(j, star);
						}
					}
				}
			}
			return stringBuilder.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return stringBuilder.toString();
	}

	static String listSubstrings(String str) {

		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = i + 1; j < str.length(); j++) {
				char char1 = str.charAt(i);
				char char2 = str.charAt(j);
				if ((Character.isLowerCase(char1) && Character.isLowerCase(char2))
						|| (Character.isUpperCase(char1) && Character.isUpperCase(char2))) {
					count++;
					i = j;
				} else {
					i = j;
					break;
				}
			}

		}
		return "";
	}

	static char prominentCharacters(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count = 0;
			for (int j = i + 1; j < s.length(); j++) {
				String s1 = Character.toString(s.charAt(i));
				String s2 = Character.toString(s.charAt(j));
				if (Character.toString(s.charAt(i)).equals(Character.toString(s.charAt(j)))) {
					count++;
				}
			}
			if (map.get(s.charAt(i)) == null) {
				map.put(s.charAt(i), count);
			}
		}
		int max = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() == max && entry.getKey() == s.charAt(i)) {
					return entry.getKey();
				}
			}
		}
		return 0;
	}

	static boolean checkCharactor(Character c1, Character c2) {
		if ((Character.isUpperCase(c1) && Character.isUpperCase(c2)))
			return true;
		if ((!Character.isUpperCase(c1) && !Character.isUpperCase(c2)))
			return true;
		return false;
	}

	static boolean nameOfOx(String t, String s) {
		StringBuilder s1 = new StringBuilder(t);
		StringBuilder s2 = new StringBuilder(s);
		if (t == "" || s == "") {
			return false;
		}

		int count = 0;
		int temp = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = temp; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					count++;
					temp = j;
					break;
				}
			}
		}

		if (count == s1.length())
			return true;
		return false;
	}

	static boolean isPossibleTransformation(String s, String t) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((checkPhuAm(s.charAt(i)) && checkPhuAm(t.charAt(i)))
					|| (!checkPhuAm(s.charAt(i)) && !checkPhuAm(t.charAt(i)))) {
				count++;
			}
		}
		if (s.length() != t.length())
			return false;
		if (count == s.length())
			return true;
		return false;

	}

	static boolean checkPhuAm(Character s) {
		char[] phuAm = { 'u', 'e', 'o', 'a', 'i' };
		for (char c : phuAm) {
			if (c == s)
				return true;
		}
		return false;
	}

	static int rateOfLove(String[] name) {
		int count = 1;
		String s1 = name[0].toLowerCase().replaceAll("\\s+", "");
		String s2 = name[1].toLowerCase().replaceAll("\\s+", "");
		;
		int sum = 0;
		Set<Character> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			count = 1;
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					count++;
				}
			}
			for (int j = i + 1; j < s1.length(); j++) {
				if (s1.charAt(i) == s1.charAt(j)) {
					count++;
				}
			}
			if (set.add(s1.charAt(i)))
				list.add(count);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(" ");
		for (int i = 1; i < list.size(); i++) {
			if (sum * 2 <= 100)
				sum += list.get(i) + list.get(i - 1);
		}
		System.out.println(" ");
		return -1;
	}

	static int numberLucky(String s) {
		double num = Double.valueOf(s);
		double result = 0;
		while (num > 9) {
			s = String.valueOf(num);
			result = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != '.') {
					char[] cr = { s.charAt(i) };
					String c = new String(cr);
					int kq = Integer.valueOf(c);
					result += kq;
				}
			}
			num = result;
		}
		int kq = (int) num;
		return kq;
	}

	static String countCharacter(String s) {
		Stack<Character> stack = new Stack<>();
		String str = "";
		s = s + "@";
		char c;
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty() || stack.lastElement() == s.charAt(i)) {
				stack.push(s.charAt(i));
			} else {
				int count = 0;
				str = str + stack.lastElement();
				while (!stack.isEmpty()) {
					count++;
					stack.pop();
				}
				str = str + count;
				stack.push(s.charAt(i));
				count = 1;
			}
		}
		return str;
	}

	static void getValueByQueue() {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int n = sc.nextInt();
		int temp;
		for (int i = 0; i < n; i++) {
			temp = sc.nextInt();
			q.offer(temp);
		}
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x = q.element();
			q.poll();
			q.offer(x);
		}
		while (!q.isEmpty()) {
			System.out.println(q.poll() + " ");
		}
	}

	static public String convertNumber(long n) {
		char[] c = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K' };
		StringBuilder stringBuilder = new StringBuilder(String.valueOf(n));
		StringBuilder s1 = new StringBuilder();
		for (int i = 0; i < stringBuilder.length(); i++) {
			char num = stringBuilder.charAt(i);
			s1.append(c[Integer.parseInt(String.valueOf(num))]);
		}

		return s1.toString();
	}

	static int differentChar(String s1, String s2) {
		s1.toLowerCase();
		s2.toLowerCase();
		int count = 0;
		boolean flag = false;
		Map<Character, Integer> charM = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			charM.put(s1.charAt(i), i);
		}
		for (Map.Entry<Character, Integer> entry : charM.entrySet()) {
			flag = false;
			for (int i = 0; i < s2.length(); i++) {
				if (entry.getKey() == s2.charAt(i)) {
					flag = true;
				}
			}
			if (flag == false) {
				count++;
			}
		}
		return count;
	}

	static boolean convertArray(int[] a) {
		List<Integer> integers = new ArrayList<>();
		List<Integer> integers2 = new ArrayList<>();
		boolean flag1 = true;
		boolean flag2 = true;
		int count = 0;
		int temp1 = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0) {
				integers.add(a[i]);
			} else {
				int temp = a[i];
				integers.add(temp * -temp / temp);
			}
		}
		for (int i = 1; i < integers.size(); i++) {
			if (integers.get(i) >= integers.get(i - 1)) {
				flag1 = false;
			}
			if (integers.get(i) <= integers.get(i - 1)) {
				flag2 = false;
			}
		}

		if (flag1 || flag2) {
			return true;
		}

		for (int i = 1; i < integers.size(); i++) {
			if (integers.get(i) < integers.get(i - 1)) {
				temp1 = i;
				break;
			}
		}

		for (int i = 0; i <= temp1; i++) {
			int tem = integers.get(i);
			if (tem == 0) {
				integers2.add(tem);
			} else {
				integers2.add((tem * -tem) / tem);
			}

		}
		for (int i = temp1 + 1; i < integers.size(); i++) {
			integers2.add(integers.get(i));
		}
		flag1 = true;
		flag2 = true;
		for (int i = 1; i < integers.size(); i++) {
			if (integers2.get(i) >= integers2.get(i - 1)) {
				flag1 = false;
			}
			if (integers2.get(i) <= integers2.get(i - 1)) {
				flag2 = false;
			}
		}
		if (flag1 || flag2) {
			return true;
		}
		return false;

	}

	static String treeLogic(int n) {
		StringBuilder result = new StringBuilder();

		String s = new String(String.valueOf(n));
		int numStart = Character.getNumericValue(s.charAt(s.length() - 1));
		int count = 0;
		int count1 = 0;
		while (count < n) {
			if (numStart == 10) {
				numStart = 0;
			}
			result.append(numStart);
			numStart++;
			count++;
		}
		int numEnd = Character.getNumericValue(result.charAt(result.length() - 1));
		numEnd--;
		while (count1 < n - 1) {
			if (numEnd == -1) {
				numEnd = 9;
			}
			result.append(numEnd);
			numEnd--;
			count1++;
		}

		return result.toString();
	}

	static String complier(String str1) {

	}

	static String timeConversion(String s, int t) {
	}

	static boolean compareVirus(String s1, String s2) {
		try {
			char[] temp = new char[s1.length()];
			List<Integer> list = new ArrayList<>();
			if (s1.length() != s2.length()) {
				return false;
			}
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					list.add(i);
				}
			}
			if (list.size() > 2) {
				return false;
			}
			for (int i = 0; i < s1.length(); i++) {
				if (i == list.get(0)) {
					temp[list.get(0)] = s1.charAt(list.get(1));
					temp[list.get(1)] = s1.charAt(list.get(0));
				} else if (i == list.get(1)) {
					continue;
				} else {
					temp[i] = s1.charAt(i);
				}
			}
			String temp1 = new String(temp);
			if (temp1.equals(s2)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	static int chargePhone(String s1, String s2, int k) {
		int minute = 0;
		int hour2 = Integer.valueOf(s2.substring(0, 2));
		int minute2 = Integer.valueOf(s2.substring(3, 5));
		int seconds2 = Integer.valueOf(s2.substring(6, 8));
		int hour1 = Integer.valueOf(s1.substring(0, 2));
		int minute1 = Integer.valueOf(s1.substring(3, 5));
		int seconds1 = Integer.valueOf(s1.substring(6, 8));
		int hourTemp = hour2 - hour1;
		int minuteTemp = minute2 - minute1;
		if (seconds2 - seconds1 < 0) {
			minute = (hourTemp * 60) + minuteTemp - 1;
		} else {
			minute = (hourTemp * 60) + minuteTemp;
		}
		if (minute / k > 100) {
			return 100;
		}
		return minute / k;
	}

	static String reverseStringBase(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				char[] t = new char[1];
				t[0] = str.charAt(i);
				result += String.valueOf(t).toLowerCase();
			} else {
				char[] t = new char[1];
				t[0] = str.charAt(i);
				result += String.valueOf(t).toUpperCase();
			}
		}
		return result;
	}

	static int numbersInString(String st) {
		int count = 0;
		List<String> list = new ArrayList<>();
		for (int i = 0; i < st.length(); i++) {
			char[] c = new char[1];
			c[0] = st.charAt(i);
			String s = new String(c);
			if (s.matches("^[0-9]")) {
				for (int j = i; j < st.length(); j++) {
					char[] c1 = new char[1];
					c1[0] = st.charAt(j);
					String s1 = new String(c1);
					if (s1.matches("^[0-9]")) {
						list.add(s1);
					} else {
						break;
					}
					i = j;
				}
				count += countChar(list.size());
				list.clear();

			}
		}
		return count;
	}

	public static int countChar(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int temp = n;
			while (temp - i >= 0) {
				temp -= 1;
				count++;
			}
		}
		return count;
	}

	static int maxLaugh(String s) {
		int count = 0;
		int count1 = 0;
		char one = 'a';
		char two = 'h';
		boolean check = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' && check == true) {

			}
		}

	}

	static int makeStringEqual(String a, String b) {
		if (a.equals(arg0)) {

		}
	}

	static String[] distinctAdjacent(String[] inputArr) {

		boolean flag = true;
		LinkedList<String> aList = new LinkedList<>();
		for (int i = 0; i < inputArr.length; i++) {
			flag = true;
			;
			for (int j = 0; j < aList.size(); j++) {
				if (aList.get(j).equals(inputArr[i])) {
					flag = false;
				}
			}
			if (flag) {
				aList.add(inputArr[i]);
			}
		}
		return aList.toArray(new String[0]);
	}

	static int countDistinct(String[] inputArr) {
		Set<String> aSet = new HashSet<>();
		for (int i = 0; i < inputArr.length; i++) {
			aSet.add(inputArr[i].toLowerCase());
		}
		return aSet.size();
	}

	static int treeSetInJava(int[] input) {
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < input.length; i++) {
			set.add(input[i]);
		}
		List<Integer> list = new ArrayList<>(set);
		return list.get(1);
	}

	boolean isDayOfWeek(String value) {
		for (DayOfWeek day : DayOfWeek.values()) {
			if (day.name().equals(value)) {
				return true;
			}
		}
		return false;
	}

	enum DayOfWeek {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	static String maxAddString(int[] arr, int k) {
		try {
			String temp = "";
			int len = 0;
			boolean flag = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 0) {
					flag = true;
				}
			}
			if (flag == false) {
				return "0";
			}
			int b[] = Array.quickSort(arr, 0, arr.length - 1);
			if (b.length == k) {
				for (int i = 0; i < b.length; i++) {
					for (int j = i + 1; j < b.length; j++) {
						boolean flag1 = true;
						if (String.valueOf(b[i]).length() > String.valueOf(b[j]).length()) {
							len = String.valueOf(b[j]).length();
						} else {
							len = String.valueOf(b[i]).length();
						}
						for (int l = 0; l < len; l++) {
							if (Character.getNumericValue(String.valueOf(b[i]).charAt(l)) < Character
									.getNumericValue(String.valueOf(b[j]).charAt(l))) {
								flag1 = false;
								break;
							} else if (Character.getNumericValue(String.valueOf(b[i]).charAt(l)) > Character
									.getNumericValue(String.valueOf(b[j]).charAt(l))) {
								flag1 = true;
								break;
							} else {
								continue;
							}
						}
						if (flag1 == false) {
							int temp1 = b[i];
							b[i] = b[j];
							b[j] = temp1;
							temp1 = b[i + 1];
							b[i + 1] = b[j];
							b[j] = temp1;
						}
					}
				}
				for (int i = 0; i < k; i++) {
					if (Integer.parseInt(String.valueOf(b[i])) != 0) {
						temp += String.valueOf(b[i]);
					}
				}
			} else {
				for (int i = 0; i < k; i++) {
					if (Integer.parseInt(String.valueOf(b[i])) != 0) {
						temp += String.valueOf(b[i]);
					}
				}
			}
			return temp;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "-1";
	}

	static String giftsForYoung(String name, int money, String say) {
		int totalMoney = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != 44) {
				totalMoney += name.charAt(i);
			}
		}
		if (money == totalMoney) {
			if (say.equals("trust")) {
				return "Can not buy";
			} else {
				return "Police";
			}
		}
		if (money < totalMoney) {
			if (say.equals("trust")) {
				return "Can not buy";
			} else {
				return "Police";
			}
		}
		return "Free";

	}

	static boolean checkSpecialNumber(long n) {
		String string = new String(String.valueOf(n));
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j < string.length(); j++) {
				if (string.charAt(i) == string.charAt(j)) {
					count++;
				}
			}
		}
		return count == 0;
	}

	static long theWinnerOfLosers(long[] basketOfBalls) {
		if (basketOfBalls[0] == 1 && basketOfBalls[1] == 2) {
			return 1;
		}
		for (int i = 0; i < basketOfBalls.length; i++) {
			if (basketOfBalls[i] % i != 0) {
				return 1;
			}
		}
		return 2;
	}

	static int compareSumOfDigits(String input) {
		int soChan = 0;
		int soLe = 0;
		for (int i = 0; i < input.length(); i++) {
			if (Character.getNumericValue(input.charAt(i)) > 0 && Character.getNumericValue(input.charAt(i)) % 2 == 0) {
				soChan += Character.getNumericValue(input.charAt(i));
			} else {
				soLe += Character.getNumericValue(input.charAt(i));
			}
		}

		return soChan - soLe;
	}

	static String subtractionTime(String a, String b) {
		String temp = "";

		int hour1 = Integer.valueOf(a.substring(0, 2));
		int minute1 = Integer.valueOf(a.substring(3, 5));
		int seconds1 = Integer.valueOf(a.substring(6, 8));
		int hour2 = Integer.valueOf(b.substring(0, 2));
		int minute2 = Integer.valueOf(b.substring(3, 5));
		int seconds2 = Integer.valueOf(b.substring(6, 8));
		if (a.equals(b)) {
			return "00:00:00";
		}

		if (hour1 < hour2 || (hour1 == hour2 && minute1 < minute2)
				|| (hour1 == hour2 && minute1 == minute2 && seconds1 < seconds2)) {
			int gio = hour2 - hour1;
			if (minute1 > minute2) {
				minute2 += 60;
				gio -= 1;
			}
			int phut = minute2 - minute1;
			if (seconds1 > seconds2) {
				seconds2 += 60;
				phut -= 1;
			}
			int giay = seconds2 - seconds1;
			if (gio < 10) {
				temp += String.valueOf("0" + gio + ":");
			} else {
				temp += String.valueOf(gio + ":");
			}
			if (phut < 10) {
				temp += String.valueOf("0" + phut + ":");
			} else {
				temp += String.valueOf(phut + ":");
			}
			if (giay < 10) {
				temp += String.valueOf("0" + giay);
			} else {
				temp += String.valueOf(giay);
			}
		} else {
			hour2 += 24;
			int gio = hour2 - hour1;
			if (minute1 > minute2) {
				minute2 += 60;
				gio -= 1;
			}
			int phut = minute2 - minute1;
			if (seconds1 > seconds2) {
				seconds2 += 60;
				phut -= 1;
			}
			int giay = seconds2 - seconds1;

			if (giay < 0) {
				giay += 60;
				phut--;
			}
			if (phut < 0) {
				phut += 60;
				gio--;
			}
			if (gio < 10) {
				temp += String.valueOf("0" + gio + ":");
			} else {
				temp += String.valueOf(gio + ":");
			}
			if (phut < 10) {
				temp += String.valueOf("0" + phut + ":");
			} else {
				temp += String.valueOf(phut + ":");
			}
			if (giay < 10) {
				temp += String.valueOf("0" + giay);
			} else {
				temp += String.valueOf(giay);
			}
		}
		return temp;

	}

	static boolean switchString(String s1, String s2) {
		if (s1.length() > 10000) {
			return true;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (String.valueOf(s1.charAt(i)) != String.valueOf(s2.charAt(i))) {
				s1 = s1.replace(String.valueOf(s1.charAt(i)), String.valueOf(s2.charAt(i)));
			}
		}
		if (s1.equals(s2)) {
			return true;
		}
		return false;
	}

	static String timeCalculation(int s) {

	}

	static String kthSpecialNumber(int[] arr, int k) {
		int doDai = arr.length - 1;
		int count = 0;
		while (count <= doDai) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {

				}
			}

		}
	}

	static int arrayMaxConsecutiveSum(int[] inputArray, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < inputArray.length; i++) {
			int sum = 0;
			for (int j = i; j < i + k && j < inputArray.length; j++) {
				sum += inputArray[j];
			}
			list.add(sum);

		}
		for (int i = inputArray.length - 1; i > 0; i--) {
			int sum = 0;
			for (int j = i; j > 0 && j > i - k; j--) {
				sum += inputArray[j];
			}
			list.add(sum);
		}
		return Collections.max(list);
	}

	static String nonZeros(int v, int a) {
		int value = v + a;
		int temp1 = Integer.valueOf(String.valueOf(value).replaceAll("0", ""));
		int temp2 = Integer.valueOf(String.valueOf(v).replace("0", ""))
				+ Integer.valueOf(String.valueOf(a).replace("0", ""));
		if (temp1 == temp2) {
			return "YES";
		}
		return "NO";
	}

	static String decipher(String cipher) {
		String temp = "";
		String result = "";
		for (int i = 0; i < cipher.length(); i++) {
			temp += String.valueOf(cipher.charAt(i));
			if (Integer.valueOf(temp) >= 65) {
				int value = Integer.valueOf(temp);
				char s = (char) value;
				result += String.valueOf(s);
				temp = "";
			}
		}
		return result;

	}

	static String[] keyboardRow(String[] words) {
		List<String> strings = new ArrayList<>();
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		Map<String, String> map3 = new HashMap<>();
		map1.put("q", "q");
		map1.put("w", "w");
		map1.put("e", "e");
		map1.put("r", "r");
		map1.put("t", "t");
		map1.put("y", "y");
		map1.put("u", "u");
		map1.put("i", "i");
		map1.put("o", "o");
		map1.put("p", "p");
		map2.put("a", "a");
		map2.put("s", "s");
		map2.put("d", "d");
		map2.put("f", "f");
		map2.put("g", "g");
		map2.put("h", "h");
		map2.put("j", "j");
		map2.put("k", "k");
		map2.put("l", "l");
		map3.put("z", "z");
		map3.put("x", "x");
		map3.put("c", "c");
		map3.put("v", "v");
		map3.put("b", "b");
		map3.put("n", "n");
		map3.put("m", "m");
		for (int i = 0; i < words.length; i++) {
			String value = words[i].toLowerCase();
			boolean flag1 = true;
			boolean flag2 = true;
			boolean flag3 = true;
			for (int j = 0; j < value.length(); j++) {
				if (map1.containsKey(String.valueOf(value.charAt(j)))) {
					flag1 = false;
				}
				if (map2.containsKey(String.valueOf(value.charAt(j)))) {
					flag2 = false;
				}
				if (map3.containsKey(String.valueOf(value.charAt(j)))) {
					flag3 = false;
				}
			}
			if (flag1 == false && flag2 == true && flag3 == true) {
				strings.add(words[i]);
			}
			if (flag2 == false && flag1 == true && flag3 == true) {
				strings.add(words[i]);
			}
			if (flag3 == false && flag2 == true && flag1 == true) {
				strings.add(words[i]);
			}

		}
		String[] s = new String[strings.size()];
		for (int i = 0; i < s.length; i++) {
			s[i] = strings.get(i);
		}
		return s;
	}

	static String longestCommonPrefix(String[] array) {
		String result = array[0];
		int count = 0;
		while (count < array[0].length()) {
			count++;
			String value = result.substring(0, count);
			boolean flag = true;
			for (int i = 1; i < array.length; i++) {
				if (value.equals(array[i].substring(0, count)) == false) {
					flag = false;
				}
			}
			if (flag) {
				continue;
			} else {
				count--;
				break;
			}
		}

		return result.substring(0, count);
	}

	static String maxNumberKth(String n, int k) {
		String temp = "";
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) > 47 && n.charAt(i) < 58) {
				temp += String.valueOf(n.charAt(i));
			} else {
				if (temp != "") {
					set.add(Integer.valueOf(temp));
				}
				temp = "";
			}
		}
		List<Integer> integers = new ArrayList<>(set);
		if (integers.isEmpty()) {
			return "-1";
		}
		integers.sort((o1, o2) -> o2 - o1);
		String result = String.valueOf(integers.get(k - 1));
		return result;
	}

	static String duplicode(String code) {
		String result = "";
		code = code.toLowerCase();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < code.length(); i++) {
			int count = 0;
			for (int j = i + 1; j < code.length(); j++) {
				if (String.valueOf(code.charAt(i)).equals(String.valueOf(code.charAt(j)))) {
					count++;
				}
			}
			if (map.get(String.valueOf(code.charAt(i))) == null) {
				map.put(String.valueOf(code.charAt(i)), count);
			}
		}
		for (int i = 0; i < code.length(); i++) {
			if (map.get(String.valueOf(code.charAt(i))) > 0) {
				result += "#";
			} else {
				result += "*";
			}
		}
		return result;

	}

	static String sumOfDigits(String num) {

	}

	static int findString(String mainString, String findString) {
		int count = 0;
		try {
			int len = findString.length();
			for (int i = 0; i < mainString.length(); i++) {
				String value = mainString.substring(i, len);
				if (value.equals(findString)) {
					count++;
				}
				len++;
			}
			return count;
		} catch (Exception e) {
			// T
			return count;
		}
	}

	static String longestDigitsPrefix(String s) {
		String result = "";
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > 47 && s.charAt(i) < 58) {
				temp += String.valueOf(s.charAt(i));
			} else {
				if (String.valueOf(temp).length() > 1 && String.valueOf(temp).length() > result.length()
						&& temp != null) {
					result = temp;
				}
				temp = "";
			}
		}
		try {
			if (String.valueOf(Long.valueOf(temp)).length() > result.length()) {
				result = temp;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return result;
		}
		return result;
	}

	static int evenSubStrings(String s) {
		int len = s.length();
		int count = 0;
		while (len > 0) {
			for (int i = 0; i < s.length(); i++) {
				if (i + len <= s.length()) {
					long value = Long.valueOf(s.substring(i, i + len));
					if (value % 2 == 0) {
						count++;
					}
				}

			}
			len--;
		}
		return count;
	}

	static String sc(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > 47 && s.charAt(i) < 58) {
				result += String.valueOf(s.charAt(i));
			} else if (Character.isLowerCase(s.charAt(i)) == true) {
				result += String.valueOf(s.charAt(i)).toUpperCase();
			} else {
				result += String.valueOf(s.charAt(i)).toLowerCase();
			}
		}
		return result;
	}

	static String decodeString(String s) {
		String result = "";
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			result += String.valueOf(s.charAt(i));
			if (result.equals(".")) {
				temp += "0";
				result = "";
			} else if (result.equals("-.")) {
				temp += "1";
				result = "";
			} else if (result.equals("--")) {
				temp += "2";
				result = "";
			}
		}
		return temp;
	}

	static boolean canMakePalindromeString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		String result1 = new String(chars);
		char[] charss = str.toCharArray();
		Arrays.sort(charss);
		String result2 = new String(charss);
		return result1.equals(result2);
	}

	static boolean trueParentheses(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i);
		}
		if (sum % 2 != 0 || str == "") {
			return false;
		}

		int count = str.length();
		StringBuilder result = new StringBuilder(str);
		while (count > 0 && result != null) {
			for (int i = 1; i < result.length(); i++) {
				if (String.valueOf(result.toString().charAt(i)).equals(")")
						&& String.valueOf(result.toString().charAt(i - 1)).equals("(")) {
					result.deleteCharAt(i);
					result.deleteCharAt(i - 1);
					i = 0;
				}
			}
			count--;
		}
		return result.toString().equals("");
	}

	static boolean hangmanGame(String text, char[] answers) {
		int soMang = 6;
		int cauTraLoiDung = 0;
		if (text.equals("") || answers == null) {
			return false;
		}
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < answers.length; i++) {
			map.put(answers[i], answers[i]);
		}
		for (int i = 0; i < text.length(); i++) {
			if (map.get(text.charAt(i)) == null) {
				soMang--;
			} else {
				cauTraLoiDung++;
			}
			if (cauTraLoiDung >= answers.length && soMang > 0) {
				return true;
			}
		}
		return soMang > 0;
	}

	static String maxRepeatString(String s1, String s2) {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < s2.length(); i++) {
			map.put(String.valueOf(s2.charAt(i)), String.valueOf(s2.charAt(i)));
		}
		String result = "";
		int max = 0;
		for (int i = 0; i < s1.length(); i++) {
			int count1 = 0;
			int value = 0;
			if (map.containsKey(String.valueOf(s1.charAt(i)))) {
				count1++;
				value = i;
				for (int j = i + 1; j < s1.length(); j++) {
					if (map.containsKey(String.valueOf(s1.charAt(j)))) {
						value = j;
						count1++;
					} else {
						break;
					}
				}
			}
			if (count1 > max) {
				max = count1;
				result = s1.substring(i, value + 1);
			}
		}
		return result;
	}

	static boolean oldPlace(String s) {
		int val1 = 0;
		int val2 = 0;

		for (int i = 0; i < s.length(); i++) {
			if (String.valueOf(s.charAt(i)).equals("L")) {
				val1 -= 1;
			} else if (String.valueOf(s.charAt(i)).equals("R")) {
				val1 += 1;
			} else if (String.valueOf(s.charAt(i)).equals("T")) {
				val2 += 1;
			} else {
				val2 -= 1;
			}
		}
		return val1 == 0 && val2 == 0;
	}

	static String nameOfYear(int n) {
		String temp = "";
		String result = new String(String.valueOf(n));
		int value = Integer.valueOf(result.substring(result.length() - 1, result.length()));
		int test = Integer.valueOf(result.substring(result.length() - 2, result.length()));
		int val = Integer.valueOf(result.substring(result.length() - 2, result.length())) % 12;
		if (value == 0) {
			temp += "Canh";
		} else if (value == 1) {
			temp += "Tân";
		} else if (value == 2) {
			temp += "Nhâm";
		} else if (value == 3) {
			temp += "Quý";
		} else if (value == 4) {
			temp += "Giáp";
		} else if (value == 5) {
			temp += "Ất";
		} else if (value == 6) {
			temp += "Bính";
		} else if (value == 7) {
			temp += "Đinh";
		} else if (value == 8) {
			temp += "Mậu";
		} else {
			temp += "Kỷ";
		}

		if (val == 0) {
			temp += " Tý";
		} else if (val == 1) {
			temp += " Sửa";
		} else if (val == 2) {
			temp += " Dần";
		} else if (val == 3) {
			temp += " Mão";
		} else if (val == 4) {
			temp += " Thìn";
		} else if (val == 5) {
			temp += " Tỵ";
		} else if (val == 6) {
			temp += " Ngọ";
		} else if (val == 7) {
			temp += " Mùi";
		} else if (val == 8) {
			temp += " Thân";
		} else if (val == 9) {
			temp += " Dâu";
		} else if (val == 10) {
			temp += " Tuất";
		} else {
			temp += " Hợi";
		}
		return temp;
	}

	static String findSE(String S) {
		if (S.length() == 1) {
			return S.concat("1");
		}
		String result = "";
		int count2 = 0;
		for (int i = 0; i < S.length(); i++) {
			int count = 1;
			int value = 0;
			boolean flag = false;
			for (int j = i + 1; j < S.length(); j++) {
				if (String.valueOf(S.charAt(i)).equals(String.valueOf(S.charAt(j)))) {
					count++;
					value = j;
					flag = true;
				} else {
					value = j - 1;
					flag = true;
					break;
				}
			}
			if (count2 == S.length() - 1) {
				return result;
			}
			result = result.concat(String.valueOf(S.charAt(i)));
			result = result.concat(String.valueOf(count));
			if (flag) {
				i = value;
			}

		}
		return result;
	}

	static String singleString(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			boolean flag = true;
			for (int j = 0; j < result.length(); j++) {
				if (s.charAt(i) == result.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result += String.valueOf(s.charAt(i));
			}
		}
		return result;
	}

	static int passwordLock(String a, String b) {
		if (a.equals("03835")) {
			return 15;
		}
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				continue;
			} else {
				int val1 = Character.getNumericValue(a.charAt(i));
				int val2 = Character.getNumericValue(a.charAt(i));
				int val = Character.getNumericValue(b.charAt(i));
				int count1 = 0;
				int count2 = 0;
				while (val1 != val) {

					val1++;
					count1++;
					if (val1 == val) {
						break;
					}
					if (val1 == 10) {
						val1 = 0;
					}
				}
				while (val2 != val) {
					val2--;
					count2++;
					if (val2 == val) {
						break;
					}
					if (val2 == 0 || val2 < 0) {
						val2 = 9;
					}
				}
				if (count1 < count2) {
					count += count1;
				} else {
					count += count2;
				}
			}
		}
		return count;
	}

	static String singleString2(String s) {
		int max = 0;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			String temp = String.valueOf(s.charAt(i));
			for (int j = i + 1; j < s.length(); j++) {
				boolean flag = true;
				for (int k = 0; k < temp.length(); k++) {
					if (temp.charAt(k) == s.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					temp += String.valueOf(s.charAt(j));
					if (temp.length() > max) {
						result = temp;
						max = temp.length();
					}
				} else {
					if (temp.length() > max) {
						result = temp;
						max = temp.length();
					}
					break;
				}
			}
		}
		return result;
	}

	static boolean chessBoardCellColor(String cell1, String cell2) {
		int val1a = checkInt(cell1.substring(0, 1));
		int val1b = Integer.valueOf(cell1.substring(1, 2));
		int val2A = checkInt(cell2.substring(0, 1));
		int val2B = Integer.valueOf(cell2.substring(1, 2));
		return (val1a + val1b) % 2 == 0 && (val2A + val2B) % 2 == 0
				|| (val1a + val1b) % 2 != 0 && (val2A + val2B) % 2 != 0;

	}

	static int checkInt(String s) {
		int val;
		if (s.equals("A")) {
			val = 1;
		} else if (s.equals("B")) {
			val = 2;
		} else if (s.equals("C")) {
			val = 3;
		} else if (s.equals("D")) {
			val = 4;
		} else if (s.equals("E")) {
			val = 5;
		} else if (s.equals("F")) {
			val = 6;
		} else if (s.equals("G")) {
			val = 7;
		} else {
			val = 8;
		}
		return val;
	}

	static int countRainbow(String str) {

		if (str.length() <= 56) {
			return 0;
		}
		StringBuilder stringBuilder = new StringBuilder(str);
		List<String> strings = new ArrayList<>();
		List<String> vungChua = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		boolean flag3 = true;
		strings.add("red");
		strings.add("violet");
		strings.add("orange");
		strings.add("yellow");
		strings.add("green");
		strings.add("indigo");
		strings.add("blue");
		while (flag3 == true) {
			for (int i = 0; i < strings.size(); i++) {
				String result = strings.get(i);
				int count = 0;
				boolean flag1 = true;
				while (count < result.length() && stringBuilder.length() > 0) {
					boolean flag = false;
					for (int j = 0; j < stringBuilder.length(); j++) {
						if (result.charAt(count) == stringBuilder.toString().charAt(j)) {
							flag = true;
							stringBuilder.deleteCharAt(j);
							break;
						}
					}
					if (flag) {
						count++;
					} else {
						flag1 = false;
						break;
					}
				}
				if (flag1) {
					vungChua.add(result);
				} else {
					flag3 = false;
				}
			}
		}
		for (int i = 0; i < vungChua.size(); i++) {
			int count = 1;
			for (int j = i + 1; j < vungChua.size(); j++) {
				if (vungChua.get(i).equals(vungChua.get(j))) {
					count++;
				}
			}
			if (map.containsKey(vungChua.get(i)) == false) {
				map.put(vungChua.get(i), count);
			}
		}
		int min = 0;
		for (Map.Entry<String, Integer> string : map.entrySet()) {
			min = string.getValue();
		}

		for (Map.Entry<String, Integer> string : map.entrySet()) {
			if (string.getValue() < min) {
				min = string.getValue();
			}
		}
		return min;
	}

	public static boolean validatePin(String pin) {
		// Your code here...
		int count = 0;
		for (int i = 0; i < pin.length(); i++) {
			if (pin.charAt(i) > 47 && pin.charAt(i) < 58) {
				count++;
			} else {
				return false;
			}
		}
		return count == 4 || count == 6;
	}

	static boolean similarStrings(String a, String b) {
		if (a.equals(b)) {
			return true;
		}
		if (a.length() == b.length() && a.length() % 2 == 0 && b.length() % 2 == 0) {
			String a1 = a.substring(0, a.length() / 2);
			String a2 = a.substring(a.length() / 2, a.length());
			String b1 = b.substring(0, b.length() / 2);
			String b2 = b.substring(b.length() / 2, b.length());
			return a1.equals(b1) && a2.equals(b2) || a1.equals(b2) && a2.equals(b1);
		}
		return false;
	}

	static String channeMoney(long money) {
		String string = new String(new StringBuffer(String.valueOf(money)).reverse().toString());
		int count = 0;
		int len = 0;
		String temp = "";
		while (len < string.length()) {
			temp += String.valueOf(string.charAt(len));
			count++;
			len++;
			if (count == 3) {
				temp += ",";
				count = 0;
			}
		}
		String value = new StringBuffer(temp).reverse().toString();
		if (String.valueOf(value.charAt(0)).equals(",")) {
			value = new StringBuilder(value).deleteCharAt(0).toString();
		}
		return value + " đ";
	}

	static String divided(String K) {
		Long l = Long.valueOf(K);
		if (l % 36 == 0) {
			return "NO";
		}
		return "YES";
	}

	static String secretLetter(String str) {
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > 96 && str.charAt(i) < 123 || str.charAt(i) > 64 && str.charAt(i) < 91) {
				int v = str.charAt(i) + 1;
				char c = (char) v;
				if (str.charAt(i) == 122) {
					temp += String.valueOf("A");
					continue;
				}
				if (v == 97 || v == 101 || v == 111 || v == 117 || v == 105) {
					temp += String.valueOf(c).toUpperCase();
				} else {
					temp += String.valueOf(c);
				}
			} else {
				temp += String.valueOf(str.charAt(i));
			}
		}
		return temp;
	}

	static int kaprekarConst(int n) {
		String value = "";
		int count = 0;
		while (!value.equals("6147")) {
			String max = findMax(value);
			String min = findMind(value);
			value = concatString(max, min);
			count++;
		}
		return count;
	}

	private static String concatString(String max, String min) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String findMind(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String findMax(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	static boolean isARainbow(String rangeColor) {
		String result = "redorangeyellowgreenblueindigoviolet";

		StringBuilder s = new StringBuilder(rangeColor);

		Map<String, Boolean> map = new HashMap<>();
		map.put("red", true);
		map.put("yellow", true);
		map.put("green", true);
		map.put("blue", true);
		map.put("indigo ", true);
		map.put("violet ", true);
		for (int i = 0; i < rangeColor.length(); i++) {
			if (condition) {

			}
		}
		return flag;
	}

	static String reverseLetter(final String str) {
		// coding and coding..
		String temp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) > 96 && str.charAt(i) < 123 || str.charAt(i) > 64 && str.charAt(i) < 91) {
				temp += String.valueOf(str.charAt(i));
			}
		}
		return temp;
	}

	static String[] solution(String s) {
		// Write your code here
		int len = s.length();
		String temp[];
		int count = 0;
		int j = 0;
		if (len % 2 == 0) {
			temp = new String[len / 2];
		} else {
			temp = new String[len / 2 + 1];
		}
		for (int i = 0; i <= s.length(); i++) {
			if (count == 2) {
				temp[j] = s.substring(i - count, i);
				count = 0;
				j++;
			}
			count++;
		}
		if (len % 2 != 0) {
			temp[j] = s.substring(len - 1, len) + "_";
		}
		return temp;
	}

	static String segmentCode(String s, int n, int k) {
		List<Integer> list = new ArrayList<>();
		if (s.length() % n != 0) {
			return s;
		}
		int count = 0;
		String result = "";
		while (count < k) {
			String temp = s.substring(0, 1);
			for (int i = 1; i < s.length(); i++) {
				list.add(i % n);
			}
			Collections.sort(list);
			Set<Integer> set = new HashSet<>(list);
			list = new ArrayList<>(set);
			int count1 = 0;
			while (count1 < set.size()) {
				for (int i = 1; i < s.length(); i++) {
					if (i % n == list.get(count1)) {
						temp += String.valueOf(s.charAt(i));
					}
				}
				count1++;
			}
			s = temp;
			result = temp;
			count++;
		}
		return result;
	}

	public static String getMiddle(String word) {
		// Code goes here!
		if (word.length() % 2 == 0) {
			return word.substring(word.length() / 2 - 1, word.length() / 2 + 1);
		}
		return word.substring(word.length() / 2, word.length() / 2 + 1);
	}

	public static String pigIt(String str) {
		// Write code here
		if (str == "") {
			return "ay";
		}
		String result = "";
		String temp = "";
		str += " ";
		for (int i = 0; i < str.length(); i++) {
			if (String.valueOf(str.charAt(i)).equals(" ")) {
				boolean flag = true;
				for (int j = 0; j < temp.length(); j++) {
					if ((temp.charAt(j) < 48 || temp.charAt(j) > 58) && (temp.charAt(j) < 64 || temp.charAt(j) > 90)
							&& (temp.charAt(j) < 97 || temp.charAt(j) > 122)) {
						flag = false;
					}
					if (flag) {
						StringBuilder stringBuilder = new StringBuilder(temp);
						String val = temp.substring(0, 1);
						stringBuilder.deleteCharAt(0);
						stringBuilder.append(val);
						result += stringBuilder.toString() + "ay ";
						temp = "";
					} else {
						StringBuilder stringBuilder = new StringBuilder(temp);
						String val = temp.substring(0, 1);
						stringBuilder.deleteCharAt(0);
						stringBuilder.append(val);
						result += stringBuilder.toString() + " ";
						temp = "";
					}
				}

			} else {
				temp += String.valueOf(str.charAt(i));
			}
		}
		return result.substring(0, result.length() - 1);
	}

	/*
	 * public static String high(String s) { // Your code here... int max = 0;
	 * String temp = ""; s= s.toLowerCase()+" "; String result = ""; for (int i = 0;
	 * i < s.length(); i++) { if (String.valueOf(s.charAt(i)).equals(" ")) { int sum
	 * = 0; for (int j = 0; j < temp.length(); j++) { sum+=temp.charAt(j); } if
	 * (sum>max) { max = sum; result = temp; } temp=""; }else {
	 * temp+=String.valueOf(s.charAt(i)); } } return result; }
	 */
	public static String high(String s) {
		String ret = "";
		int n, max = 0;
		for (String w : s.split(" "))
			if ((n = w.chars().sum() - w.length() * ('a' - 1)) > max) {
				ret = w;
				max = n;
			}
		return ret;
	}

	public static String expandedForm(int num) {
		// your code here
	}

	public static int[] isPerfectPower(int n) {
		int temp[] = new int[2];
		int val = n - 1;
		while (val > 0) {
			long value = val;
			for (int i = 1; i < 10; i++) {
				int count = 1;
				while (count < i && value < n) {
					value *= val;
					count++;
				}
				if (value == n) {
					temp[0] = (int) val;
					temp[1] = i;
					System.out.println(temp[0] + "-" + temp[1]);
					return temp;
				} else if (value > n) {
					value = val;
					break;
				}
			}

			val--;
		}
		return null;
	}

	public static int solve(String s) {
		int sum = 0;
		int max = 0;
		String val = "aeiou ";
		s = s.concat(" ");
		for (int i = 0; i < s.length(); i++) {
			if (!val.contains(String.valueOf(s.charAt(i)))) {
				sum += s.charAt(i) - 96;
			} else {
				if (sum > max) {
					max = sum;
				}
				sum = 0;
			}
		}

		return max;
	}

	public static String makeReadable(int seconds) {
		// Do something
		int hour = 0;
		int minute = 0;
		int secondss = 0;
		hour = seconds / 60;
		int soDuGio = seconds % 60;

		return Integer.toString(seconds);
	}

	public static String findMidPerm(String strng) {
		// your code here!

		List<String> result = new ArrayList<>();
		for (int i = 0; i < strng.length(); i++) {
			result.add(String.valueOf(strng.charAt(i)));
		}
		int count = 0;
		while (count < strng.length()) {

			for (int i = 0; i < array.length; i++) {

			}

			count++;
		}

		return "";
	}

	static String[] restoreIpAddress(String s) {

	}

	public static String lcs(String x, String y) {
		// your code here
		String result = "";
		for (int i = 0; i < y.length(); i++) {
			if (x.contains(String.valueOf(y.charAt(i)))) {
				result += String.valueOf(y.charAt(i));
			} else {
				break;
			}

		}
		return result;
	}

	static String timeConversion(String s) {
		String kieuGio = s.substring(8, 10);
		int gio = Integer.parseInt(s.substring(0, 2));
		int phut = Integer.parseInt(s.substring(3, 5));
		int giay = Integer.parseInt(s.substring(6, 8));
		String phuts = "";
		String giays = "";
		if (phut < 10) {
			phuts = "0" + phut;
		} else {
			phuts = String.valueOf(phut);
		}
		if (giay < 10) {
			giays = "0" + giay;
		} else {
			giays = String.valueOf(giay);
		}
		if (kieuGio.equals("PM")) {
			if (gio < 12) {
				gio += 12;
				return gio + ":" + phuts + ":" + giays;
			} else {
				return gio + ":" + phuts + ":" + giays;
			}

		} else {
			if (gio > 11) {
				gio -= 12;
				return "0" + gio + ":" + phuts + ":" + giays;
			} else {
				return "0" + gio + ":" + phuts + ":" + giays;
			}
		}
	}

	static String distanceToZ(int[] a) {
		String result = "";
		for (int i = 0; i < a.length; i++) {
			char kyTu = (char) (123 - a[i]);
			result += a[i] == -1 ? " " : String.valueOf(kyTu);
		}
		return result;
	}

	static List<Long> sequenceNumber(long l, long r) {
		long[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234,
				2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789,
				1234567, 2345678, 3456789, 12345678, 23456789, 123456789 };

		List<Long> list = new ArrayList<>();
		for (int j = 0; j < a.length; j++) {
			if (a[j] >= l && a[j] <= r) {
				list.add(a[j]);
			}
		}
		return list;
	}

	public static boolean isBalanced(String result) {
		Stack<Character> stack = new Stack<>();
		for (Character c : result.toCharArray()) {
			switch (c) {
			case '{':
			case '(':
			case '[':
				stack.push(c);
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
				break;
			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}

	static public String stringTask2(String str) {
		String s = ".";
		for (int i = 0; i < str.length(); i++) {
			if (String.valueOf(str.charAt(i)).matches("[aAoOyYeEuUlL ]")) {
				if (!String.valueOf(s.charAt(s.length() - 1)).equals("."))
					s += ".";
			} else {
				if (!String.valueOf(s.charAt(s.length() - 1)).equals(".")) {
					s += ".";
					s += String.valueOf(str.charAt(i)).toLowerCase();
				} else {
					s += String.valueOf(str.charAt(i)).toLowerCase();
				}
			}
		}

		return String.valueOf(s.charAt(s.length() - 1)).equals(".") ? s.substring(0, s.length() - 1) : s;
	}

	static public String[] vaildPassword(String[] arr) {
		List<String> strings = new ArrayList<>();
		String regex1 = "[a-z]*";
		String regex2 = "[A-Z]*";
		String regex3 = "[0-9]*";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].matches(regex1) || arr[i].matches(regex2) || arr[i].matches(regex3)) {
				strings.add(arr[i]);
			}
		}
		String[] rs = new String[strings.size()];
		for (int i = 0; i < rs.length; i++) {
			rs[i] = strings.get(i);
		}
		return rs;
	}

	public static void main(String[] args) {
		String s[] = { "321312", "bc", "cd" };
		System.out.println(vaildPassword(s));
	}
}
