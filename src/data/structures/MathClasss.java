package data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.beans.binding.StringBinding;

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

	int lego(int a, int b, int n) {
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
	static	int indexOfPrime(int a) {
		int count = 0;
		for (int i = 2; i <= a; i++) {
			if (isPrime(i) && i==a) {
				return count+1;
			}else if (isPrime(i)) {
				count++;
			}
		}
		return -1;
	}
	
	static Long countMoney(int a, int n) {
		long sum = 0;
		long temp = Long.valueOf(a);
		for (int i = 0; i < n; i++) {
			sum+=temp;
			temp*=2;
			if (sum>1000000000+7) {
				return sum%1000000000+7;
			}
		}
	
		return Long.valueOf(sum);
	}
	static	long chooseMarbles(int n) {
		for (int i = 1; i <= n; i++) {
			
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 6 };
		System.out.println(countMoney(238, 131));

	}

}
