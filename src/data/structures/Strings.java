package data.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Strings {
	
	public static void check() {
		String text ="navinreddy";
		String pattern ="red";
		int tlen = text.length();
		int count = 0;
		int plen = pattern.length();
		for (int i = 0; i <= tlen-plen; i++) {
			char c = text.charAt(i);
			char p = pattern.charAt(0);
			if (c==p) {
				for (int j = i,k=0; j < i+plen; j++,k++) {
					 c = text.charAt(j);
					 p = pattern.charAt(k);
					 if (c==p) {
						count++;
					}
				}
			}
		}
		if (count == plen) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	public static String amendTheSentence(String s) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringBuilder st1 = new StringBuilder(s);
		StringBuilder st2 = new StringBuilder(s.toLowerCase());
		StringBuilder st3 = new StringBuilder();
		String temp = "";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c=st1.charAt(i);
			char p = st2.charAt(i);
			if (c!=p) {
				map.put(count, i);
				count = i;
			}
		}
		map.put(count, st2.length());
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if(temp=="") {
				temp =temp+st2.substring(entry.getKey(), entry.getValue());
			}else {
				temp =temp+" "+st2.substring(entry.getKey(), entry.getValue());
			}
		}
		
		return temp;
	}
	
	static	boolean checkPalindrome(String inputString) {
		int len = (inputString.length()/2);
		int len1 = inputString.length()-1;
		StringBuilder st1 = new StringBuilder(inputString);
		StringBuilder st2 = new StringBuilder(inputString);
		int count = 0;
		for (int i = 0, j = len1; i < len; i++,j--) {
			if (st1.charAt(i)==st2.charAt(j)) {
				count++;
			}
		}
		if (count == len) {
			return true;
		}else {
			return false;
		}
	}
	
	static	boolean isTandemRepeat(String input){
			int len = input.length()/2;
			String s1 = input.substring(0,len);
			String s2 = input.substring(len, input.length()-1);
			if (s1.equals(s2)) {
				return true;
			}
				return false;
	}
	
	static String truncateString(String s) {
		StringBuilder st1 = new StringBuilder(s);
		if(s.length()==0) {
			return "";
		}
		int left = 0;
		int right = s.length()-1;
	
		if (st1.charAt(left)%3==0) {
			st1.deleteCharAt(left);
			return	truncateString(st1.toString());
		}
		if(st1.charAt(right)%3==0) {
			st1.deleteCharAt(right);
			return	truncateString(st1.toString());
		}
		char c = st1.charAt(left);
		char p = st1.charAt(right);
		if ((c+p)%3==0) {
			st1.deleteCharAt(left);
			st1.deleteCharAt(right-1);
			return	truncateString(st1.toString());
		}
		return st1.toString();
	}
	
	public static int stringsCrossover(String[] inputArray, String result) {
		try {
			int count = 0;
			for (int i = 0; i < inputArray.length; i++) {
				for (int j = i+1; j < inputArray.length; j++) {
					String inputStrings = inputArray[i]+inputArray[j];
					if (checkCrossover(inputStrings,result)) count++;
				}
			}
			return count;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public static boolean checkCrossover(String inputStrings ,String result) {
		int count = 0;
		StringBuilder st1 = new StringBuilder(inputStrings);
		StringBuilder stR = new StringBuilder(result);
		
		for (int i = 0; i < inputStrings.length(); i++) {
			for (int j = 0; j < result.length(); j++) {
				char t = st1.charAt(i);
				char t1 = stR.charAt(j);
				if (t==t1) {
					count++;
					break;
				}
			}
		}
		
		if (count == result.length()) return true;
		
		return false;
	}
	
	public static void main(String[] args ) {
		String[] inputArray =  {"abc","aaa","aba","bab"};
		String result = "bbb";
		System.out.println(stringsCrossover(inputArray,result));
		
	}
}
