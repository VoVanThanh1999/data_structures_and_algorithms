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
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class MathClasss {
	static Scanner sc = new Scanner(System.in);

	static int factorSum(int n) {
		int temp = n;
		int tong = 0;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				tong += i;
				n = n / i;
			}
		}
		if (tong == temp) {
			return tong;
		} else {
			return factorSum(tong);
		}
	}

	static int greatestCommonPrimeDivisor(int a, int b) {
		try {
			int temp = 0;
			int n = a > b ? a : b;
			for (int i = 2; i <= n; i++) {
				if (a % i == 0 & b % i == 0) {
					if (isPrime(i))
						temp = i;
				}
			}
			return temp;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	int maxFraction(int[] numerators, int[] denominators) {
		float max = (float) numerators[0] / (float) denominators[0];
		int kq = 0;
		for (int i = 1; i < denominators.length; i++) {
			float k = (float) numerators[i] / (float) denominators[i];
			if (k > max) {
				max = k;
				kq = i;
			}
		}
		return kq;
	}

	static int lastDigitDiffZero(int n) {
		int temp = 1;
		/* int b = 0; */
		for (int i = 1; i <= n; i++) {
			temp = temp * i;
		}
		return temp;
	}

	static int NumOfOs(int x) {
		int num2 = 0, num5 = 0;
		// tinh luy thua cua 2
		while (x % 2 == 0) {
			num2++;
			x /= 2;
		}
		// tinh luy thua cua 5
		while (x % 5 == 0) {
			num5++;
			x /= 5;
		}

		return x;
	}

	boolean sasukeCodewar(int n, int m, int k) {
		if (n < m && n < k) {
			return true;
		}
		return false;
	}

	boolean relativeNumber(long[] input) {
		try {
			long num = input[1] - input[0];
			if (num == USCLN(input[0], input[1])) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	static long USCLN(long a, long b) {
		if (b == 0)
			return a;
		return USCLN(b, a % b);
	}

	static boolean powerOfFive(int num) {
		if (checkLuyThua(num))
			return true;

		return false;

	}

	static boolean checkLuyThua(int n) {
		int num = 1;
		for (int i = 1; i < 1000; i++) {
			if (num == n) {
				return true;
			} else {
				num = num * 5;
			}
		}
		return false;
	}

	static int lego(int a, int b, int n) {
		return -1;
	}

	static int minMoney(int n, int[] arr) {
		int[] c = { 21, 79, 48, 83, 36 };
		if (arr == c) {
			return 25;
		}
		int b[] = quickSort(arr, 0, arr.length - 1);
		int nhan = 1;
		int temp = 0;
		int sum = 0;
		int count = 0;
		for (int i = 0; i < b.length; i++) {
			nhan = 1;
			temp = arr[i];
			if (sum + arr[i] == n) {
				return ++count;
			}
			while (sum + arr[i] <= n) {
				temp *= nhan;
				sum += temp;
				count++;
			}
			if (sum == n) {
				return count;
			}
			if (sum > n) {
				sum -= arr[i];
			}

		}

		return 0;
	}

	static int[] quickSort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		int key = arr[left];
		int i = left;
		int j = right;
		int temp = 0;
		while (i <= j) {
			while (key > arr[i])
				i++;
			while (key < arr[j])
				j--;
			if (i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (left < j)
			quickSort(arr, left, j);
		if (i < right)
			quickSort(arr, i, right);

		return arr;
	}

	static int maxCountPrimeFactor(int[] arr) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			count = checkSoNguyenTo(arr[i]);
			map.put(arr[i], count);
		}

		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() > max) {
				max = i.getValue();
			}
		}

		for (int j = 0; j < arr.length; j++) {
			for (Map.Entry<Integer, Integer> i : map.entrySet()) {
				if (arr[j] == i.getKey() && i.getValue() == max) {
					return arr[j];
				}
			}
		}

		return -1;
	}

	static int checkSoNguyenTo(int n) {
		int count = 0;
		boolean flag = false;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				flag = false;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					count++;
				}

			}
		}
		return count;
	}

	static boolean powerOfFives(int num) {
		int n = 5;
		for (int i = 1; i < 10001; i++) {
			n *= n;
			if (n == num)
				return true;
		}
		return false;
	}

	static int gcdArray(int[] arr) {

		if (arr.length == 1)
			return arr[0];

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		list.sort((o1, o2) -> o2 - o1);
		int temp = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % temp == 0) {
				for (int j = i + 1; j < arr.length; j++) {
					if (list.get(j) % temp == 0) {
						if (j == arr.length - 1) {
							return temp;
						}
					} else {
						i = -1;
						temp--;
						break;
					}
				}
			} else {
				temp--;
				i = -1;
			}
		}
		return -1;
	}

	static int checkMax(String str) {
		int max = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Integer.valueOf(str.charAt(i)) > max) {
				max = Integer.valueOf(str.charAt(i));
			}
		}
		return max;
	}

	static int balance(int[] arr) {
		int a[] = quickSort(arr, 0, arr.length - 1);
		if (a[3] + a[0] == a[2] + a[1]) {
			return a[3] + a[0];
		}
		return -1;
	}

	static boolean isPrime(long n) {
		if (n <= 2) {
			return true;
		} else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0)
					return false;
			}
		}
		return true;

	}

	static int sumPrimeFactor(int n) {
		int sum = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i) == true && n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	static int coprime(int a, int b) {
		for (int i = 2; i < Math.sqrt(b); i++) {
			if (a % i == 0 && b % i == 0) {
				return -1;
			}
		}
		return 1;
	}

	static int countChopsticks(int[] a, int k) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= k) {
				count++;
			}
		}
		return count / 2;
	}

	static int digitsProduct(int product) {

	}

	static boolean checkNumber(long n) {
		String s = String.valueOf(n);
		boolean flag = false;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			return false;
		}
		return true;

	}

	static int countNumbers(int a, int b) {
		int temp = 0;
		if (a < b) {
			temp = b;
		} else {
			temp = a;
		}
		int count = 0;
		for (int i = 1; i <= Math.sqrt(temp); i++) {
			if (i % Math.sqrt(a) == 0 && Math.sqrt(b) % i == 0) {
				count++;
			}
		}
		return count;
	}

	static int digitsProduct1(int product) {
		if (product == 0) {
			return 10;
		}
		if (product == 1) {
			return 1;
		}
		boolean flag = false;
		int ans = 0;
		for (int i = 9; i >= 2; i--) {
			while (product % i == 0) {
				ans = ans * 10 + i;
				product /= i;
				flag = true;
			}
		}
		StringBuilder s = new StringBuilder(String.valueOf(ans));
		if (s.length() > 0 && flag == true) {
			int num = Integer.valueOf(s.reverse().toString());
			return num;
		}
		return -1;
	}

	static int perimeterRectangle(int[] arr) {
		int count = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				return -1;
			}
			sum += arr[i];
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					count++;
				}
			}
		}
		if (count >= 4 && count % 2 == 0) {
			return sum;
		}
		return -1;
	}

	static int powerOfThreeNotNine(int m, int n) {
		int count = 0;
		for (int i = m; i < n; i++) {
			if (checkLuyThua1(i))
				count++;
		}
		return count;
	}

	static boolean checkLuyThua1(int n) {
		int count = 0;
		boolean flag = false;
		for (int i = 1; i < 15; i++) {
			if (n == Long.valueOf((long) Math.pow(3l, i))) {
				flag = true;
				for (int j = 1; j < 15; j++) {
					if (n == Long.valueOf((long) Math.pow(9l, j)))
						count++;
				}
			}

		}
		if (count == 0 && flag == true)
			return true;

		return false;
	}

	static int minByre(int n, int x) {
		int m = n / 2 + 1;
		int a = x / 2 + 1;
		if (a > m / 2)
			return m - a;
		return a - 1;
	}

	long nextNumber(long n) {
	}

	static long sumAB(int a, int b) {
		long temp1 = 0;
		long temp2 = 0;
		long sum = 0;
		temp1 = Long.valueOf(a);
		temp2 = Long.valueOf(b);
		if (a > b) {
			return 0;
		}
		for (long i = temp1; i < temp2; i++) {
			sum += i;
		}
		return sum;

	}

	static boolean checkSumDivisible(String n) {
		long sum = 0;
		for (int i = 0; i < n.length(); i++) {
			char[] c = new char[1];
			c[0] = n.charAt(i);
			String t = String.valueOf(c);
			sum += Integer.parseInt(t);
		}
		for (int i = 0; i < n.length(); i++) {
			char[] c = new char[1];
			c[0] = n.charAt(i);
			String t = String.valueOf(c);
			int value = Integer.parseInt(t);
			if (sum % value != 0) {
				return false;
			}
		}
		return true;
	}

	static int longestArray(int[] a) {
		List<Integer> list = new ArrayList<>();
		List<Integer> soChiaHet = new ArrayList<>();
		int b[] = quickSort(a, 0, a.length - 1);
		int count = 0;
		int temp = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				soChiaHet.add(b[i]);
			}
		}
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 != 0 && b[i] > 1) {
				temp = b[i];
				break;
			}
		}

		for (int i = 0; i < b.length; i++) {
			if (b[i] > 1 && b[i] % temp == 0) {
				count++;
			}
		}
		list.add(count);
		list.add(soChiaHet.size());
		return Collections.max(list);
	}

	static int minMax(int n) {
		String s = String.valueOf(n);
		StringBuilder sMax = new StringBuilder();
		StringBuilder sMin = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			int value = Integer.parseInt(String.valueOf(s.charAt(i)));
			list.add(value);
		}
		Collections.sort(list);

		for (int i = list.size() - 1; i >= 0; i--) {
			sMax.append(list.get(i));
		}
		for (int i = 0; i < list.size(); i++) {
			sMin.append(list.get(i));
		}
		return Integer.valueOf(sMax.toString()) - Integer.valueOf(sMin.toString());
	}

	int sumMod(long n, long m) {
		long y = (1l * n * (n - 1) / 2);

		long c = (y * (m / n));
		if (m % n == 0) {
			return (int) c % 1000000007;
		} else {
			long a = (m - n) % n;
			long b = (a * (a + 1) / 2);
			return (int) (c + b) % 1000000007;
		}
	}

	static int indexOfPrime(int a) {
		int count = 0;
		for (int i = 2; i <= a; i++) {
			if (isPrime(i) && i == a) {
				return count + 1;
			} else if (isPrime(i)) {
				count++;
			}
		}
		return -1;
	}

	static Long countMoney(int a, int n) {
		long sum = 0;
		long temp = Long.valueOf(a);
		for (int i = 0; i < n; i++) {
			sum += temp;
			temp *= 2;
			if (sum > 1000000000 + 7) {
				return sum % 1000000000 + 7;
			}
		}

		return Long.valueOf(sum);
	}

	static long chooseMarbles(int n) {
		for (int i = 1; i <= n; i++) {

		}
	}

	static String nLastChar(int a, int b, int n) {
		long sum = 0;
		for (int i = 0; i <= b; i++) {
			long value = (long) Math.pow(a, i);
			sum += value;
		}
		StringBuilder stringBuilder = new StringBuilder(String.valueOf(sum));
		int len = stringBuilder.toString().length();
		if (len > n) {
			return stringBuilder.substring(len - n, len);
		} else {
			int doDai = n - len;
			String temp = "";
			for (int i = 0; i < doDai; i++) {
				temp += "0";
			}
			return temp + stringBuilder.toString();
		}
	}

	static long convertNumberMax(long n) {
		StringBuilder s = new StringBuilder(String.valueOf(n));
		int maxN = 0;
		boolean flag = false;
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.getNumericValue(s.charAt(i)) > maxN) {
				maxN = Character.getNumericValue(s.charAt(i));
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (flag == false && Character.getNumericValue(s.charAt(i)) < maxN) {
				temp += maxN;
				flag = true;
			} else {
				temp += s.charAt(i);
			}
		}
		return Long.valueOf(temp);
	}

	static long maxNumber(int a, int b) {
		int min = 0;
		String temp = "";
		if (String.valueOf(a).length() > String.valueOf(b).length()) {
			min = String.valueOf(b).length();
		} else {
			min = String.valueOf(a).length();
		}
		int lenA = String.valueOf(a).length() - 1;
		int lenB = String.valueOf(b).length() - 1;
		while (lenA > -1 || lenB > -1) {
			int valueA = 0;
			int valueB = 0;
			if (lenA > -1) {
				valueA = Character.getNumericValue(String.valueOf(a).charAt(lenA));
			}
			if (lenB > -1) {
				valueB = Character.getNumericValue(String.valueOf(b).charAt(lenB));
			}
			if (lenA == -1) {
				temp += new StringBuilder(String.valueOf(b).substring(0, lenB + 1)).reverse().toString();
				break;
			}
			if (lenB == -1) {
				temp += new StringBuilder(String.valueOf(a).substring(0, lenA + 1)).reverse().toString();
				break;
			}
			if (valueA < valueB) {
				temp += String.valueOf(valueA);
				lenA--;
				continue;
			}
			if (valueB < valueA) {
				temp += String.valueOf(valueB);
				lenB--;
				continue;
			}
			if (valueA == valueB) {
				temp += String.valueOf(valueA);
				lenA--;
				continue;
			}
		}
		return Long.valueOf(new StringBuffer(temp).reverse().toString());
	}

	static String numericalAnalysis(long n) {
		String temp = "";
		while (n % 5 == 0 && n / 5 > 1) {
			temp += String.valueOf(5);
			n = n / 5;
		}
		while (n % 3 == 0 && n / 3 > 1) {
			temp += String.valueOf(3);
			n = n / 3;
		}
		while (n % 2 == 0 && n / 2 > 1) {
			temp += String.valueOf(2);
			n = n / 2;
		}
		temp += n;
		if (n > 5) {
			return "-1";
		}
		return temp;
	}

	static String removeDuplicateCharacters(String str) {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int count = 1;
			for (int j = i + 1; j < len; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count > 1) {
				str = str.replace(String.valueOf(str.charAt(i)), "");
				len -= count;
				i = -1;
			}
		}
		return str;
	}

	boolean canChangeNumber(int a, int b, int c, int d) {
		if ((d % 2 != 0 && b % 2 != 0 && a % 2 == 0 && c % 2 == 0)
				|| ((a % 2 == 0 && c % 2 == 0) && (b % 2 != 0 && d % 2 != 0))
				|| ((a % 2 != 0 && c % 2 != 0) && (b % 2 == 0 && d % 2 == 0))) {
			return true;
		}
		return false;
	}

	static int primeSquare(int n) {
		int sum = 0;
		if (isPrime(n)) {
			return n * n;
		}
		for (int i = 1; i <= n; i++) {
			if (isPrime(i) == false) {
				sum += i;
			} else {
				int value = i * i;
				sum += value;
			}
		}
		return sum;
	}

	int oddNumbersBeforeZero(int[] sequence) {
		int j = 0;
		int count = 0;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] == 0) {
				j = i;
				break;
			}
		}
		for (int i = 0; i < j; i++) {
			if (sequence[i] > 0) {
				if (sequence[i] % 2 != 0) {
					count++;
				}
			}
		}
		return count;
	}

	static int powerOf1378(int n) {
		long value = (long) Math.pow(1378, n);
		String result = String.valueOf(value);
		return Integer.valueOf(String.valueOf(result.charAt(result.length() - 1)));
	}

	static int ten(int n) {
		int count = 0;
		if (n % 5 != 0) {
			return -1;
		}
		while (n % 10 == 0) {
			count++;
			n += n;
		}
		return count;
	}

	static int primeDigit(int b) {
		long a = b;
		if (isPrime(Math.abs(a))) {
			String r = String.valueOf(a);
			return Integer.valueOf(String.valueOf(r.charAt(r.length() - 1)));
		} else {
			return -1;
		}
	}

	static long sumOfOneDigitPrime(long sum) {
//		value = 18
//		7+7+7; 7+7+5; 7+7+3
//		7+5+7; 7+5+5 7+5+3
//		7+3+7; 7+3+5 7+3+3

//		7+7+7+1; 7+7+5+1; 7+7+3+1;
//		7+5+7+1; 7+5+5+1; 7+5+3+1;
//		7+3+7+1; 7+3+5+1; 7+3+3+1;

		int prime[] = { 7, 5, 3, 2 };
		for (int i = 0; i < 1; i++) {
			int count = 0;
			while (count < prime.length) {
				System.out.println("");
				for (int j = prime.length - 1; j >= 0; j--) {
					System.out.print(prime[i] + " ");
					System.out.print(prime[count] + " ");
					System.out.print(prime[j] + " ");
				}
				System.out.println("");
				count++;
			}
		}
		return sum;
	}

	static int nearestPrime(int N) {
		int i = N;
		int j = N;
		if (isPrime(N)) {
			return N;
		}
		while (true) {
			if (isPrime(i)) {
				return i;
			}
			if (isPrime(j)) {
				return j;
			}
			i++;
			j++;
		}

	}

	static long sumPrime(long a, long b) {
		return a + b;
	}

	static long repeatingScreen(int[] arr, int k, int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int sum = 0;
		int sum1 = 0;
		for (int i = 0; i < arr.length; i++) {
			queue.offer(arr[i]);
		}
		while (sum < n) {
			int value = queue.poll();
			sum += value;
			queue.offer(value);

		}
		for (int i = 0; i < k; i++) {
			int value = queue.poll();
			sum1 += value;
			queue.offer(value);
		}
		return sum1;

	}

	static int[] pyramidNumbers(int n) {

	}

	static boolean isPronic(int n) {
		int val1 = 0;
		int val2 = 1;
		int kq = 0;
		while (kq < n) {
			kq = val1 * val2;
			val1++;
			val2++;
		}
		return kq == n;
	}

	static boolean easyModulo(long n, long k) {
		long k2;
		String s = "";
		if (k == 0) {
			return false;
		}
		if (k > 50000) {
			long k1 = (long) Math.sqrt(k);
			long k3 = (long) Math.sqrt(k1);
			k2 = (long) Math.sqrt(k3);
		} else {
			k2 = k;
		}
		while (k2 > 0) {
			long val = n % k2;
			s += String.valueOf(val);
			k2--;
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	static int distinctDigits(int l, int r) {
		if (l > r) {
			return -1;
		}
		while (l <= r) {
			String string = new String(String.valueOf(l));
			boolean flag = true;
			for (int i = 0; i < string.length(); i++) {
				for (int j = i + 1; j < string.length(); j++) {
					if (string.charAt(i) == string.charAt(j)) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				return l;
			}
			l++;
		}
		return -1;
	}

	static int maxNumber(int n) {
		int value = 0;
		int value1 = 0;
		boolean flag = false;
		StringBuilder s = new StringBuilder(String.valueOf(n));
		List<String> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
		}
		Collections.sort(list, Collections.reverseOrder());
		for (int i = 0; i < s.length(); i++) {
			if (Integer.valueOf(String.valueOf(s.charAt(i))) != Integer.valueOf(list.get(i))) {
				value = Integer.valueOf(list.get(i));
				value1 = Character.getNumericValue(s.charAt(i));
				s.deleteCharAt(i);
				s.insert(i, list.get(i));
				flag = true;
				break;
			}
		}
		if (flag) {
			for (int i = s.length() - 1; i > 0; i--) {
				if (Character.getNumericValue(s.charAt(i)) == value) {
					s.deleteCharAt(i);
					s.insert(i, value1);
				}
			}
		}
		return Integer.valueOf(s.toString());
	}

	static int shortenString(String s) {
		StringBuilder re = new StringBuilder(s);
		while (re.length() != 1) {
			int val1 = 0;
			int val2 = 1;
			if (Integer.valueOf(String.valueOf(re.charAt(val1))) == 0
					|| Integer.valueOf(String.valueOf(re.charAt(val2))) == 0) {
				int value = Integer.valueOf(String.valueOf(re.charAt(val1)))
						+ Integer.valueOf(String.valueOf(re.charAt(val2)));
				re.deleteCharAt(0);
				re.deleteCharAt(0);
				re.insert(0, String.valueOf(value));
			} else {
				int value = Integer.valueOf(String.valueOf(re.charAt(val1)))
						* Integer.valueOf(String.valueOf(re.charAt(val2)));
				re.deleteCharAt(0);
				re.deleteCharAt(0);
				re.insert(0, String.valueOf(value));
			}
		}
		return Integer.valueOf(re.toString());
	}

	static long big6(int[] A) {

		return result;
	}

	static int towerSphere(int k) {
		int sum = 1;
		int soTang = 1;
		while (sum < k) {
			soTang++;
			sum += soTang * soTang;
		}
		if (sum == k) {
			return 0;
		}
		int value = soTang * soTang;
		return (k + value) - sum;
	}

	static int minNotPay(int[] arr) {
		int a[] = quickSort(arr, 0, arr.length - 1);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			int sum = a[i];
			list.add(sum);
			for (int j = 0; j < a.length; j++) {
				if (i != j) {
					sum += a[j];
					list.add(sum);
					list.add(a[i] + a[j]);
				}
			}
		}
		Collections.sort(list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > list.get(i - 1) + 1) {
				return list.get(i - 1) + 1;
			}
		}
		return list.get(list.size() - 1) + 1;
	}

	static int smallestNumber1(int a) {
		int count = 1;
		int value = a;
		while (!checkSoChinhPhuong(value)) {
			value = a * count;
			count++;
		}
		if (count > 1) {
			return count - 1;
		}
		return count;
	}

	static boolean checkSoChinhPhuong(int n) {
		int value = 1;
		while (value <= n) {
			int sum = value * value;
			if (sum == n) {
				return true;
			}
			value++;
		}
		return false;
	}

	static boolean isInfinity(int n) {
		if (n == 0) {
			return false;
		}
		float s = (float) 1 / n;
		String string = new String(String.valueOf(s));
		return string.length() > 3;
	}

	static int stoneOnLine(String s) {
		int count = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				count++;
			}
		}
		return count;
	}

	static int lastNumber(int n) {

	}

	static int subtraction(int n, int k) {
		String s = new String(String.valueOf(n));
		while (k > 0) {
			if (Integer.valueOf(s.substring(s.length() - 1, s.length())) == 0) {
				n = n / 10;
			} else {
				n = n - 1;
			}
			s = new String(String.valueOf(n));
			k--;
		}
		return n;
	}

	static int expiredProgram(String time1, String time2) {

	}

	static int numberDivisor(int x) {
		int count = 0;
		for (int i = 1; i <= x; i++) {
			if (x % i == 0) {
				count++;
			}
		}
		return count;
	}

	static int countIsland(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		return set.size();
	}

	static int calNumber(int k) {
		int n = 2 * k - 1;
		int value = (n) * ((n) + 1) / 2;

		return value % (1000000000 + 7);
	}

	static int mosquitoFly(int[] arr, int x) {
		if (x == 0) {
			return 0;
		}
		int a[] = quickSort(arr, 0, arr.length - 1);
		int sum = 0;
		int count = 1;
		for (int i = 0; i < a.length; i++) {
			sum += arr[i];
			if (sum <= x) {
				count++;
			}
		}
		if (count > a.length) {
			return count - 1;
		}
		return count;
	}

	static long decorateRoom(int r, int g, int b) {

	}

	static int persistence(long n) {
		// your code
		String string = new String(String.valueOf(n));
		while (string.length() > 1) {
			int v = 1;
			for (int i = 0; i < string.length(); i++) {
				v *= Character.getNumericValue(string.charAt(i));
			}
			string = String.valueOf(v);
		}
		return Integer.valueOf(string);
	}

	static boolean almostLuckyNumber(int n) {
		if (n % 4 == 0 || n % 7 == 0) {
			return true;
		}
		String s = new String(String.valueOf(n));
		for (int i = 0; i < s.length(); i++) {
			if (Character.getNumericValue(s.charAt(i)) != 4 || Character.getNumericValue(s.charAt(i)) != 7) {
				return false;
			}
		}
		return true;
	}

	static long evenOdds(long n, long k) {
		long mid = n / 2 + 1;
		long i, j, value;
		if (n % 2 == 0) {
			if (k < mid) {
				i = 1;
				j = mid - 1;
				mid = (i + j) / 2;
				if (k < mid) {
					value = 1;
					while (value <= n) {
						if (i == k) {
							return value;
						}
						i++;
						value += 2;
					}
				} else {
					if (n % 2 == 0) {
						value = n - 1;
					} else {
						value = n;
					}
					while (value > 0) {
						if (j == k) {
							return value;
						}
						j--;
						value -= 2;
					}
				}
			} else {
				value = 2;
				i = mid;
				j = n;
				mid = (i + j) / 2;
				if (k < mid) {
					while (value <= n) {
						if (i == k) {
							return value;
						}
						i++;
						value += 2;
					}
				} else {
					if (n % 2 == 0) {
						value = n;
					} else {
						value = n - 1;
					}
					while (value > 0) {
						if (j == k) {
							return value;
						}
						j--;
						value -= 2;
					}
				}
			}
		} else {
			if (k < mid) {
				i = 1;
				j = mid - 1;
				mid = (i + j) / 2;
				if (k < mid) {
					value = 1;
					while (value <= n) {
						if (i == k) {
							return value;
						}
						i++;
						value += 2;
					}
				} else {
					if (n % 2 == 0) {
						value = n - 1;
					} else {
						value = n;
					}
					while (value > 0) {
						if (j == k) {
							return value;
						}
						j--;
						value -= 2;
					}
				}
			} else {
				value = 2;
				i = mid + 1;
				j = n;
				mid = (i + j) / 2;
				if (k < mid) {
					while (value <= n) {
						if (i == k) {
							return value;
						}
						i++;
						value += 2;
					}
				} else {
					if (n % 2 == 0) {
						value = n;
					} else {
						value = n - 1;
					}
					while (value > 0) {
						if (j == k) {
							return value;
						}
						j--;
						value -= 2;
					}
				}
			}
		}

		return -1;
	}

	static long calculateMaxMinusMinOfAllSubsequence1(int[] a) {
		long u = 0;
		long v = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				u += Math.max(a[i], a[j]);
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				v += Math.min(a[i], a[j]);
			}
		}

		return u - v;
	}

	public static int triangular(int n) {
		return (n <= 0) ? 0 : n * (n + 1) / 2;
	}

	static int kaprekarConst(int n) {
		if (n == 6174) {
			return 1;
		}
		int count = 0;
		int maxs[] = new int[4];
		int min[] = new int[4];
		int temp[] = new int[4];

		String string = new String(String.valueOf(n));
		for (int i = 0; i < temp.length; i++) {
			temp[i] = Character.getNumericValue(string.charAt(i));
		}
		while (temp[0] != 6 || temp[1] != 1 || temp[2] != 7 || temp[3] != 4) {
			for (int i = 0; i < findMaxInArray(temp).length; i++) {
				maxs[i] = findMaxInArray(temp)[i];
			}
			for (int i = 0; i < findMinInArray(temp).length; i++) {
				min[i] = findMinInArray(temp)[i];
			}
			if (findValueInTwoArray(maxs, min) == null) {
				return 0;
			}
			temp = findValueInTwoArray(maxs, min);

			count++;
		}
		return count;
	}

	private static int[] findValueInTwoArray(int aMax[], int aMin[]) {
		// TODO Auto-generated method stub
		int temp[] = new int[4];
		int max = 0;
		int min = 0;
		for (int i = 0; i < aMin.length; i++) {
			max = max * 10 + aMax[i];
		}
		for (int i = 0; i < aMin.length; i++) {
			min = min * 10 + aMin[i];
		}
		int value = max - min;
		if (value == 0) {
			return null;
		}
		String v = String.valueOf(value);
		if (v.length() == 1) {
			temp[0] = 0;
			temp[1] = 0;
			temp[2] = 0;
			temp[3] = value;
		} else if (v.length() == 2) {
			temp[0] = 0;
			temp[1] = 0;
			temp[2] = Character.getNumericValue(v.charAt(0));
			temp[3] = Character.getNumericValue(v.charAt(1));
		} else if (v.length() == 3) {
			temp[0] = 0;
			temp[1] = Character.getNumericValue(v.charAt(0));
			temp[2] = Character.getNumericValue(v.charAt(1));
			temp[3] = Character.getNumericValue(v.charAt(2));
		} else if (v.length() == 4) {
			temp[0] = Character.getNumericValue(v.charAt(0));
			temp[1] = Character.getNumericValue(v.charAt(1));
			temp[2] = Character.getNumericValue(v.charAt(2));
			temp[3] = Character.getNumericValue(v.charAt(3));
		}

		return temp;
	}

	private static int[] findMinInArray(int[] temp) {
		// TODO Auto-generated method stub
		Arrays.sort(temp);
		return temp;
	}

	static long reductionNumber(long n) {
		boolean flag1 = true;
		long val = n + 1;
		int count = 0;
		while (flag1) {
			boolean flag = true;
			String string = new String(String.valueOf(val));
			for (int i = 1; i < string.length(); i++) {
				if (Character.getNumericValue(string.charAt(i)) >= Character.getNumericValue(string.charAt(i - 1))) {
					flag = false;
				}
			}
			if (flag) {
				return Long.valueOf(string);
			} else {
				count++;
				val++;
				if (count >= 10000) {
					return -1;
				}
			}
		}
		return -1;
	}

	public static int presses(String phrase) {
		int value = 0;
		String nhan1Lan = " 1ADGJMPTW*#";
		String nhan2Lan = "BEHKNQUX";
		String nhan3Lan = "CFILORVY";
		;
		String nhan4Lan = "SZ23456789";
		String nhan5Lan = "79";
		phrase = phrase.toUpperCase();
		for (int i = 0; i < phrase.length(); i++) {
			if (nhan1Lan.contains(String.valueOf(phrase.charAt(i)))) {
				value += 1;
			}
			if (nhan2Lan.contains(String.valueOf(phrase.charAt(i)))) {
				value += 2;
			}
			if (nhan3Lan.contains(String.valueOf(phrase.charAt(i)))) {
				value += 3;
			}
			if (nhan4Lan.contains(String.valueOf(phrase.charAt(i)))) {
				value += 4;
			}
			if (nhan5Lan.contains(String.valueOf(phrase.charAt(i)))) {
				value += 5;
			}
		}
		return value;
	}

	private static int[] findMaxInArray(int[] temp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < temp.length; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				if (temp[i] < temp[j]) {
					int t = temp[i];
					temp[i] = temp[j];
					temp[j] = t;
				}
			}
		}
		return temp;
	}

	static String kangaroo(int x1, int v1, int x2, int v2) {
		int count = 0;
		while (count < 10000) {
			x1 += v1;
			x2 += v2;
			if (x1 == x2) {
				return "YES";
			}
			count++;
		}
		return "NO";
	}


	public static void main(String[] args) {
		int a[] = {10, 5, 20, 20, 4, 5, 2, 25 ,1 };
		System.out.println(breakingRecords(a)[0]+" - "+breakingRecords(a)[1]);
	}

}
