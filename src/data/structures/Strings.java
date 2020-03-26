package data.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
			st2.append(st1.toString().substring(list.get(i-1), list.get(i))+" ");
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
				if (checkCrossover(temp, result)== true) {
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

	public static void main(String[] args) {
		String[] inputArray = { "abc", "aaa", "aba", "bab" };
		String result = "bbb";
		System.out.println(amendTheSentence("iFvFAxtViLJDuWWXJesppOcLVdRA"));

	}
}
