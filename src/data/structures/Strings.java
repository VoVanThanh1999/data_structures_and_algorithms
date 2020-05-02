package data.structures;

import java.util.ArrayList;
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
		String text = "navinreddy";
		String pattern = "red";
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
	
	static	int maxLaugh(String s) {
		int count = 0;
		int count1 = 0;
		char one  = 'a';
		char two  = 'h';
		boolean check  = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='a' && check == true) {
				
			}
		}
	
	}
	
	static int makeStringEqual(String a, String b) {
		
	}
	
	static	String[] distinctAdjacent(String[] inputArr) {
		
		boolean flag = true;
	    LinkedList<String> aList = new LinkedList<>();
	    for (int i = 0; i < inputArr.length; i++) {
	    	flag = true;;
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
	
	static	int countDistinct(String[] inputArr) {
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
		    if(day.name().equals(value)) {
		        return true;
		    }
		}
		   return false;
	}
	enum DayOfWeek{
	    MONDAY,
	    TUESDAY,
	    WEDNESDAY,
	    THURSDAY,
	    FRIDAY,
	    SATURDAY,
	    SUNDAY
	}
	public static void main(String[] args) {
		int[]  s= {1,1,5,4,2,6};
		System.out.println(treeSetInJava(s));
	}
}
