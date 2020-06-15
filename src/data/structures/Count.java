package data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Count {
	static int aMuN(int n) {
		if (n == 1)
			return 1;
		return n * aMuN(n - 1);
	}

	/*
	 * static int fibonacci(int n) { if (n < 0) { return -1; }else if (n==0 || n==1)
	 * { return n; }else { return fibonacci(n-1)+fibonacci(n-2); } }
	 */

	static int stackofbricks(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		if (max < a.length) {
			return max + 1;
		}
		if (max == a.length) {
			return max;
		}
		return max + 1;
	}

	static int fibonacci(int n) {
		if (n < 0)
			return -1;
		if (n == 0 || n == 1)
			return n;
		int a[] = new int[n];
		int rs = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}

		for (int i = 2; i < a.length; i++) {
			a[i] = a[i - 1] + a[i - 2];
			rs = a[i];
		}
		return rs;
	}

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
				if ((a[i] - reverseNumber(a[i])) % k == 0) {
					count++;
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

	static int contest(int[] a, int k) {
		if (k == a.length) {
			k = k - 1;
		}
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int temp = a[k];
			if (a[i] >= k && a[i] > 0) {
				count++;
			}
		}
		return count;
	}

	static int helpMe(int n, int m) {
		int count = 0;
		while (n != m) {
			if (m % 2 == 0 && n <= m) {
				m /= 2;
				count++;
			} else {
				m += 1;
				count++;
			}

		}
		return count;
	}

	static long count83(int[] a) {
		float temp = (float) 8 / 3;
		long count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if ((float) a[i] / a[j] == temp && i != j) {
					count += 1;
				}
			}
		}
		return count;
	}

	int jumppingMokey(int[] a) {

		int count = 0;
		try {
			for (int i = 0; i < a.length; i++) {
				if (i + 3 > a.length - 2 && a[a.length - 1] == 0) {
					i += 1;
					count++;
				}

				if (i + 3 > a.length - 2 && a[a.length - 1] == 1 && a[a.length - 2] == 0) {
					count++;
					continue;
				}
				if (i + 3 > a.length - 2 && a[a.length - 1] == 1 && a[a.length - 2] == 1) {
					return -1;
				}

				if (a[i + 3] == 1 && a[i + 2] == 1 && a[i + 1] == 1) {
					return -1;
				}
				if (a[i + 3] == 1 && a[i + 2] == 1 && a[i + 1] == 0) {
					count++;
					continue;
				}
				if (a[i + 3] == 1 && a[i + 2] == 0) {
					i += 1;
					count++;
					continue;
				}
				if (a[i + 3] == 0) {
					i = i + 2;
					count++;
					continue;
				}
				if (a[i + 3] == 1 && a[i + 2] == 0) {
					i = i + 1;
					count++;
					continue;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		return count;
	}

	static long countMoney(long moneyToBuy) {

	}

	static int multiplyTable(int n, int k) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i * j == k) {
					count++;
				}
			}
		}
		return count;
	}

	static int maxMultiplication(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] * a[j] > max && i != j) {
					max = a[i] * a[j];
				}
			}
		}
		return max;
	}

	static int maxMod(int[] a) {

		int max1 = 0;
		int max2 = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max1) {
				max1 = a[i];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max2 && a[i] < max1) {
				max2 = a[i];
			}
		}

		return max2;
	}

	static long cupsOfWater(long totalWater, int k) {
		try {
			long num = totalWater / k;
			if (totalWater % k != 0) {
				return num + 1;
			}
			return num;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	static int countPosition(String s) {
		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;
		map.put(result, result);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'L') {
				result -= 1;
				map.put(result, result);
			} else {
				result += 1;
				map.put(result, result);
			}
		}
		return map.size();

	}

	static int countLevel(int[] b) {
		if (b[0] >= b[1] && b[2] >= b[3])
			return -1;
		int count = 1;
		double a[] = new double[b.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}

		while (Math.sqrt(a[0]) >= Math.sqrt(a[1])) {
			a[0] *= a[2];
			a[1] *= a[3];
			count++;
		}
		return count;

	}

	static int milkingthecow(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (a[i] > 0) {
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] > 0) {
						a[j] -= 1;
					}
				}
			}
		}
		return sum;
	}

	static int countCaseArray(int n) {

	}

	static int nextYears(int a, int b) {

		return a - (2 * b);
	}

	static int countCustomer(int a, int b, int[] arr) {
		b *= 2;
		int sum = 0, count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1 && a > 0) {
				a--;
				count++;
			} else if (arr[i] == 1 && a == 0 && b > 0) {
				b -= 1;
				count++;
			} else if (arr[i] == 2 && b - 2 >= 0) {
				b -= 2;
				count += 2;
			}
		}
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];

		return sum - count;
	}

	static int lego(int a, int b, int n) {
		double bb = Double.valueOf(b);
		double aa = Double.valueOf(a);
		double nn = Double.valueOf(n);

		double check1 = checkLego(bb, aa, nn);
		double check2 = checkLego(aa, bb, nn);

		if (check1 == -1 && check2 != -1) {
			return (int) check2;
		}
		if (check2 == -1 && check1 != -1) {
			return (int) check1;
		}
		if (check1 > check2) {
			return (int) check2;
		} else {
			return (int) check1;
		}
	}

	private static double checkLego(double a, double b, double n) {
		// TODO Auto-generated method stub
		double count = 0;
		while (n - a >= 0) {
			n = n - a;
			count++;
		}

		if (n == 0) {
			return count++;
		}
		while (n - b >= 0) {
			n = n - b;
			count++;
		}
		if (n == 0) {
			return count++;
		}
		if (n > 0) {
			n += a;
		}
		while (n - b > 0) {
			n -= b;
			count++;
		}
		if (n - b == 0) {
			return count++;
		}

		return -1;
	}

	static int count(int a[], int l, int r, int x) {
		if (l == r) {
			if (a[l] == x) {
				return 1;
			} else {
				return 0;
			}
		} else {
			int m = (l + r) / 2;
			return count(a, l, m, x) + count(a, m + 1, r, x);
		}

	}

	public int countlengthArray(int a[], int n) {
		/*
		 * int index = 0; int count = 0; int temp = 0; int max = 0; Map<Integer,
		 * Integer> map = new HashMap<>(); List<Integer> list = new ArrayList<>();
		 * list.add(a[0]); for (int i = 1; i <n; i++) { if (a[i] > a[i-1]) {
		 * list.add(a[i]); }else { list.add(-1); } } for (int i = 0; i < n; i++) { if
		 * (list.get(i) != -1) { count++; }else { map.put(, arg1) } }
		 */

	}

	static int countNumbersBeautiful(long a, long b) {
		int count = 0;
		for (long i = a; i < b; i++) {
			if (i < 10) {
				count++;
			} else {
				if (checkNumbersBeautiful(i)) {
					count++;
				}
			}
		}
		return count++;
	}

	private static boolean checkNumbersBeautiful(long n) {
		// TODO Auto-generated method stub
		try {
			StringBuilder stringBuilder = new StringBuilder(String.valueOf(n));
			long dev = 0;
			if (stringBuilder.length() == 2) {
				dev = 10;
			} else if (stringBuilder.length() == 3) {
				dev = 100;
			} else if (stringBuilder.length() == 4) {
				dev = 1000;
			} else if (stringBuilder.length() == 5) {
				dev = 10000;
			} else if (stringBuilder.length() == 6) {
				dev = 100000;
			} else if (stringBuilder.length() == 7) {
				dev = 1000000;
			} else if (stringBuilder.length() == 8) {
				dev = 10000000;
			} else if (stringBuilder.length() == 9) {
				dev = 100000000;
			} else if (stringBuilder.length() == 10) {
				dev = 1000000000;
			} else if (stringBuilder.length() == 11) {
				dev = 10000000000l;
			} else if (stringBuilder.length() == 12) {
				dev = 100000000000l;
			} else if (stringBuilder.length() == 13) {
				dev = 1000000000000l;
			} else if (stringBuilder.length() == 14) {
				dev = 10000000000000l;
			} else if (stringBuilder.length() == 15) {
				dev = 100000000000000l;
			}

			int phepDu = (int) (n % dev);
			String rs = String.valueOf(phepDu).concat(String.valueOf(phepDu));
			if (Integer.valueOf(rs.substring(0, stringBuilder.length())) == n) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	static int shoots(int[] a, int x) {
		List<Integer> list = new ArrayList<>();
		int b[] = Array.quickSort(a, 0, a.length - 1);

		int count = 0;

		for (int i = b.length - 1; i >= 0; i--) {
			int temp = x;
			int value = b[i];
			count = 1;

			if (temp - value == 0) {
				list.add(count);
			} else {
				for (int j = b.length - 1; j >= 0; j--) {

				}
				int l = i;
				int count2 = 0;
				int count3 = i;
				while (temp > 0 || l > 0) {
					temp = temp - b[l];
					count2++;
					if (temp == 0) {
						list.add(count2);
					}
					if (temp < 0) {
						temp = temp + b[l];
						count2--;
						l--;
					}

				}
			}
		}
		for (int i = 0; i < b.length; i++) {
			System.out.print(list.get(i) + " ");
		}
		return -1;
	}

	static char prominentCharacters(String r) {
		String s = r.toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count = 0;
			for (int j = i + 1; j < s.length(); j++) {
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

	static boolean numberPalindrome(long n) {
		String s1 = new String(String.valueOf(n));
		int i = 0;
		int j = s1.length() - 1;
		while (i != j && i < j) {
			if (s1.charAt(i) != s1.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	static int countZeroDigit(int a, int b) {
		int count = 0;
		for (int i = a; i <= b; i++) {
			String temp = String.valueOf(i);
			for (int j = 0; j < temp.length(); j++) {
				if (Character.getNumericValue(temp.charAt(j)) == 0) {
					count++;
				}
			}
		}
		return count;
	}

	static int specialPolynomial(int x, int n) {
		int result = 0;
		int count = -1;
		while (result < n) {
			count++;
			result += Math.pow(x, count);

		}
		return count - 1;
	}

	static int secondBiggest(int n, int[] a) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		List<Integer> list = new ArrayList<>(set);
		if (list.size() < 2) {
			return list.get(0);
		}
		Collections.sort(list);
		return list.get(list.size() - 2);
	}

	static int ten(int n) {
		int count = 0;
		if (n % 5 != 0) {
			return -1;
		}
		while (n % 10 != 0) {
			count++;
			n += n;
		}
		return count;
	}

	static int ropes(int[] a, int k) {

	}

	static int chessKnight(String Cell) {

	}

	public static int dontGiveMeFive(int start, int end) {
		int count = 0;
		while (start <= end) {
			String string = new String(String.valueOf(start));
			if (string.contains("5") == false) {
				count++;
			}
			start++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(ten(15));
		System.out.println(dontGiveMeFive(1,8));
	}

}
