package data.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

public class Array {
	static Scanner sc = new Scanner(System.in);

	static int[] removeArray(int a[], int index) {
		for (int i = index; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		return a;
	}

	static void AddArray(int a[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập value thứ a [" + i + "] =");
			a[i] = sc.nextInt();
		}
	}

	static void showArray(int a[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + "\t");
		}
	}

	static int[] addValueInArray(int a[], int index, int v, int n) {
		for (int i = n - 1; i >= index; i--) {
			a[i + 1] = a[i];
		}
		a[index] = v;
		return a;
	}

	static int[] sortArray(int a[], int n) {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		return a;
	}

	static int[] insertArraySorting(int a[], int value, int n) {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] >= value) {
				temp = i;
				break;
			}
		}
		for (int i = n - 1; i >= temp; i--) {
			a[i + 1] = a[i];
		}
		a[temp] = value;
		return a;
	}

	static boolean isMonotonous(int[] sequence) {
		int count1 = 1;
		int count2 = 1;
		for (int i = 1; i < sequence.length; i++) {
			int a = sequence[i];
			int b = sequence[i - 1];
			if (a > b) {
				count1++;
			}
			if (a < b) {
				count2++;
			}
			if (a == b) {
				return false;
			}
		}
		if (count1 == sequence.length || count2 == sequence.length) {
			return true;
		}
		return false;
	}

	static boolean isArithmeticProgression(int[] sequence) {
		int temp = sequence[1] - sequence[0];
		int sum = 0;
		for (int i = 1; i < sequence.length; i++) {
			sum = sequence[i] - sequence[i - 1];
			if (sum != temp) {
				return false;
			}
		}
		return true;
	}

	static int[] prefixSums(int[] a) {
		int temp = 0;
		int b[] = new int[a.length];
		for (int i = 1; i < a.length; i++) {
			temp = 0;
			for (int j = 0; j < i; j++) {
				temp += a[j];
				b[i] = temp;
			}
		}
		b[0] = a[0];
		return b;
	}

	static int[] alternatingSums(int[] a) {
		try {
			int b[] = new int[2];
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 2; i < a.length; i++) {
				if (i % 2 == 0) {
					sum1 += a[i];
				} else {
					sum2 += a[i];
				}
			}
			if (a.length == 1) {
				b[0] = a[0];
				b[1] = 0;
			} else {
				sum1 += a[0];
				sum2 += a[1];
				b[0] = sum1;
				b[1] = sum2;
			}
			return b;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	static int[] makeArrayConsecutive(int[] sequence) {
		try {
			int temp = 0;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < sequence.length; i++) {
				for (int j = i + 1; j < sequence.length; j++) {
					if (sequence[i] > sequence[j]) {
						temp = sequence[i];
						sequence[i] = sequence[j];
						sequence[j] = temp;
					}
				}
			}

			int a = sequence[0];
			int b = sequence[sequence.length - 1];
			for (int i = a; i <= b; i++) {
				map.put(i, i);
			}

			for (int i = a; i <= b; i++) {
				for (int j = 0; j < sequence.length; j++) {
					if (map.get(i) == sequence[j]) {
						map.remove(i);
						break;
					}
				}
			}
			int array[] = new int[map.size()];
			int count = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				array[count] = entry.getKey();
				count++;
			}

			for (int i = 0; i <= array.length; i++) {
				for (int j = i + 1; j < array.length; j++) {
					if (array[i] > array[j]) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}

			return array;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	static boolean checkSort(int[] a) {
		List<Integer> list = new ArrayList<>();
		int count = 0;
		list.add(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (a[i] != a[i - 1]) {
				list.add(a[i]);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == list.get(j)) {
					count++;
				}
			}
		}
		if (count > 0) {
			return false;
		}
		return true;
	}

	static int[] MaxSumArray(int[] a, int k) {
		List<Integer> list = new ArrayList<>();
		int tong = 0;
		int max = 0;
		int sum[] = new int[a.length];

		int index = 0;
		for (int i = 0; i <= a.length - k; i++) {
			tong = 0;
			for (int j = i; j < i + k; j++) {
				tong = tong + a[j];
			}
			sum[i] = tong;
		}

		for (int i = 0; i < sum.length; i++) {
			if (sum[i] > max) {
				max = sum[i];
				index = i;
			}

		}
		for (int i = index; i < index + k; i++) {
			list.add(a[i]);
		}
		int temp[] = new int[list.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = list.get(i);
		}
		return temp;
	}

	static int circleRotation(int[] arr, long d) {

		return arr[(int) d];
	}

	static long maxPoint(int[] a, int k) {
		long tong = k;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (tong >= a[i] && map.get(j) == null) {
					tong = tong + a[j];
					map.put(j, j);
				}
			}
		}
		return tong;
	}

	static int[] rainWater(int[] a) {
	}

	static int spreadInformation(int[] a, int k) {
		int count = 1;
		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			integers.add(a[i]);
		}
		Collections.sort(integers);
		int max = integers.get(0) + k;
		int len = integers.size();
		for (int i = 1; i < len; i++) {
			if (integers.get(i) <= max) {
				max = integers.get(i) + k;
			} else {
				max = integers.get(i) + k;
				count++;
			}

		}
		return count;

	}

	static int ArrayEqual(int[] a) {
		int count = 0;
		try {
			int mid = a[a.length / 2];

			int i = 0;
			while (a != null) {
				if (a[i] < mid) {
					a[i] += 1;
					count++;
				} else if (a[i] > mid) {
					a[i] -= 1;
					count++;
				} else {
					a[i] = a[i + 1];
					i++;
				}
			}
			return count;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;

	}

	static boolean deleteArray(int[] a) {
		int count = 0;
		int len = a.length;
		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			integers.add(a[i]);
		}

		for (int i = 1; i < len; i++) {
			if (integers.get(i) < integers.get(i - 1)) {
				integers.remove(i - 1);
				if (checkArrayIsSort(integers) == true) {
					count++;
				} else {
					return false;
				}
				len--;
			}
		}
		if (count > 1) {
			return false;
		}
		return true;
	}

	static boolean checkArrayIsSort(List<Integer> integers) {
		for (int i = 1; i < integers.size(); i++) {
			if (integers.get(i) < integers.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	static int bestFriend(int[] a, int[] b) {
		int count = 0;
		try {
			List<Integer> list = new ArrayList<>();
			int[] arrSort = sortArrays(b);

			for (int i = 0; i < a.length; i++) {
				list.add(a[i]);
			}
			int peo1 = arrSort[0];
			int peo2 = arrSort[1];
			int sm2 = peo1 + peo2;
			int len = list.size();
			Collections.sort(list);
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (peo1 >= list.get(i) && peo2 >= list.get(j) && i != j) {
						list.remove(j);
						list.remove(i);

						i = -1;
						len = len - 2;
						count++;
						break;
					}
				}
			}
			len = list.size();
			for (int i = 0; i < len; i++) {
				if (list.get(i) <= sm2) {
					count++;
					list.remove(i);
					i--;
					len--;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	static int[] sortArrays(int a[]) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	int bingoGame(int[][] a, int[] b) {

	}

	static String dragonGame(int s, int n, int[] x, int[] y) {

		int len = x.length;

		List<Integer> integers = new ArrayList<>();
		List<Integer> sm = new ArrayList<>();

		for (int i = 0; i < x.length; i++) {
			integers.add(x[i]);
		}

		for (int i = 0; i < y.length; i++) {
			sm.add(y[i]);
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (s > integers.get(j)) {
					s += sm.get(j);
					integers.remove(j);
					sm.remove(j);
					i = -1;
					len--;
					break;
				}
			}
		}
		if (integers.isEmpty()) {
			return "YES";
		}

		return "NO";
	}

	private boolean checkBingo(int[][] a) {

		for (int i = 0; i < a.length; i++) {

		}
		return false;

	}

	String soloBingoGame(int[][] a, int[][] b, int[] search) {

	}

	static int arrayAscending(int[] a, int k) {
		int temp = 0;
		int count = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			while (a[i - 1] >= temp) {
				temp += k;
				count += 1;
			}
			a[i] = temp;
		}
		return count;
	}

	static int nextIP(int[] ip) {
		int[] a = quickSort(ip, 0, ip.length - 1);

		if (a[0] != 1) {
			return 1;
		}

		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1] + 1) {
				return a[i - 1] + 1;
			}
		}
		return a[a.length - 1] + 1;
	}

	static int[] quickSort(int a[], int l, int r) {
		int pivot = a[l];
		int i = l;
		int j = r;
		int temp = 0;
		while (i <= j) {
			while (pivot > a[i]) {
				i++;
			}
			while (pivot < a[j]) {
				j--;
			}
			if (i <= j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if (l < j) {
			quickSort(a, l, j);
		}
		if (r > i) {
			quickSort(a, i, r);
		}
		return a;
	}

	static int[] maxPoint(int[] a, int[] b) {
		int[] max = new int[b.length];

		for (int i = 0; i < b.length; i++) {
			max[i] = checkMaxPoint(a, b[i]);
		}
		return max;
	}

	static int checkMaxPoint(int a[], int index) {
		int max = 0;
		for (int i = 0; i <= index; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	static int systemConveyor(int[] a, int k) {
		int count = 0;
		int sum = 0;
		for (int i = 0; i < a.length - 1; i++) {
			sum += a[i];
			if (a[i] > k) {
				if (a[i] % k == 0) {
					count += a[i] / k;
					sum = 0;
				} else {
					count = +1 + a[a.length - 1] / k;
					sum = 0;
				}
			} else if (a[i] == k) {
				count++;
				sum = 0;
			} else if (sum <= k && sum + a[i + 1] > k) {
				count++;
				sum = 0;
			}
		}

		if (a[a.length - 1] <= k)
			return count + 1;

		if (a[a.length - 1] > k) {
			if (a[a.length - 1] % k == 0) {
				return count + a[a.length - 1] / k;
			} else {
				return count + 1 + a[a.length - 1] / k;
			}
		}
		return count;
	}

	static int swapArray(int[] a) {
		List<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		Collections.sort(list);

		for (int i = 0; i < a.length; i++) {
			if (list.get(i) != a[i]) {
				count++;
			}
		}

		return count;
	}

	static int[] gameShow(int[] a, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == k)
				list.add(i);
		}

		if (!list.isEmpty()) {
			int b[] = new int[list.size()];
			for (int i = 0; i < b.length; i++) {
				b[i] = list.get(i);
			}
			return b;
		} else {
			for (int i = 0; i < a.length; i++) {
				list.add(a[i]);
			}
			list.add(k);
			Collections.sort(list);
			List<Integer> arr = new ArrayList<>();
			int max1 = 0;
			int max2 = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == k) {
					if (i == 0) {
						arr.add(list.get(i + 1));
					} else if (i == list.size() - 1) {
						arr.add(list.size() - 1);
					} else {
						max1 = list.get(i + 1) - list.get(i);
						max2 = list.get(i) - list.get(i - 1);
					}
				}
			}
			if (max1 > max2) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) + max2 == k) {
						arr.add(i);
					}
				}
			} else if (max1 < max2) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) + max1 == k) {
						arr.add(i);
					}
				}
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) + max1 == k || list.get(i) - max1 == k) {
						arr.add(i);
					}
				}
			}

			for (int i = 0; i < a.length; i++) {

			}

			int b[] = new int[arr.size()];
			for (int i = 0; i < b.length; i++) {
				b[i] = arr.get(i);
			}
			return b;
		}
	}

	static int[] hardworkingMember(int[][] dec, int n) {

	}

	static int numberDifferent(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0, count1 = 0, count2 = 0, min = 0, max = 0;

		for (int i = 0; i < a.length; i++) {
			count = 0;
			for (int j = i; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (map.get(a[i]) == null) {
				map.put(a[i], count);
			}
		}
		min = map.get(a[0]);
		max = map.get(a[0]);
		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() < min)
				min = i.getValue();
			if (i.getValue() > max)
				max = i.getValue();
		}

		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (max > i.getValue()) {
				count1++;
			}
			if (min < i.getValue()) {
				count2++;
			}
		}

		if (count1 > count2) {
			for (Map.Entry<Integer, Integer> k : map.entrySet()) {
				if (k.getValue() == max)
					return k.getKey();
			}
		} else {
			for (Map.Entry<Integer, Integer> i : map.entrySet()) {
				if (i.getValue() == min)
					return i.getKey();
			}
		}

		return -1;
	}

	static int shoots(int[] a, int x) {
		try {
			int b[] = quickSort(a, 0, a.length - 1);
			int count = 0;
			int temp = x;
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < b.length; i++) {
				count = 0;
				temp = x;
				for (int j = i; j < b.length; j++) {
					/*
					 * while (temp>0) { temp= temp-b[i]; count++; } if (temp==0) { list.add(count);
					 * break; }else { temp+=b[i]; count--; }
					 */
				}

			}
			int min = list.get(0);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}

			return min;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	static void twoArraySort(int a[], int b[], int n, int m) {
		int size = n + m;
		int r[] = new int[101];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < n && j < m) {
			if (a[i] < b[j]) {
				r[k] = a[i];
				k++;
				i++;
			} else {
				r[k] = b[j];
				k++;
				j++;
			}
		}
		while (i < n) {
			r[k] = a[i];
			k++;
			i++;
		}
		while (j < m) {
			r[k] = b[j];
			k++;
			j++;
		}
		for (k = 0; k < size; k++) {
			System.out.print(r[k] + " ");
		}
	}

	static boolean checkDonDieu(int a[], int n) {
		boolean check1 = false;
		boolean check2 = false;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[i - 1]) {
				check1 = true;
			} else {
				check1 = false;
				break;
			}
		}
		for (int i = 1; i < n; i++) {
			if (a[i] < a[i - 1]) {
				check2 = true;
			} else {
				check2 = false;
				break;
			}
		}
		if (check1 == true || check2 == true)
			return true;

		return false;

	}

	static int countDayFlower(int a[], int n) {
		int d = 1;
		int max = 0;
		int b[] = quickSort(a, 0, n - 1);
		for (int i = n - 1; i >= 0; i--) {
			if (b[i] + d > max) {
				max = b[i] + d;
			}
			d++;
		}
		return max;
	}

	public static int baiToanXepGach(int a[], int n) {
		int b[] = quickSort(a, 0, n - 1);
		int sucChuaBanDau = b[n - 1];
		int sucChuaHienTai = b[n - 1];
		int count = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (sucChuaBanDau >= 1 && sucChuaHienTai >= b[i]) {
				sucChuaBanDau--;
				sucChuaHienTai = b[i];
				count++;
			}
		}
		return count;
	}

	static int kthBiggestFrequency(int[] a, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int temp = 0;
		int max = a[k];
		LinkedHashMap<Integer, Integer> reverse = new LinkedHashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], a[i]);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			count = 0;
			for (int i = 0; i < a.length; i++) {
				if (entry.getKey() == a[i]) {
					count++;
				}
			}
			entry.setValue(count);
		}
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEach(x -> reverse.put(x.getKey(), x.getValue()));
		for (Map.Entry<Integer, Integer> i : reverse.entrySet()) {
			list.add(i.getKey());
			System.err.println(i);
		}
		return -1;
	}

	static int[] createRectangle(int[][] points) {
		int w = points[2][0];
		int h = points[0][1];
		int t[] = { w, h };
		return t;
	}

	static int kthBiggest(int[] arr, int k) {
		try {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < arr.length; i++) {
				set.add(arr[i]);
			}
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			return list.get(list.size() - k);
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	static List<Integer> hashList() {

	}

	static int minNumberArray(int[] a) {
		int b[] = quickSort(a, 0, a.length - 1);
		boolean flag = false;
		for (int i = 0; i < b.length; i++) {
			if (a[i] == 0) {
				flag = true;
			}
		}

		if (a[0] > 1 || a[0] < 0 && flag == false) {
			return 0;
		}

		for (int i = 1; i < b.length; i++) {

			if (b[i] > b[i - 1] + 1) {
				if (b[i - 1] < 0) {
					continue;
				}
				return b[i - 1] + 1;
			}
		}
		return b[b.length - 1] + 1;
	}

	static boolean stabilityArray(int[] arr) {
		boolean flag = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1] + 5) {
				flag = false;
			}
		}
		if (flag == false) {
			return false;
		}
		return true;
	}

	static boolean isMonotonous(int[] sequence) {
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		for (int i = 1; i < sequence.length; i++) {
			if (sequence[i] > sequence[i - 1]) {
				flag1 = false;
			}
			if (sequence[i] < sequence[i - 1]) {
				flag2 = false;
			}

			if (sequence[i] == sequence[i - 1]) {
				flag3 = false;
			}

		}
		return flag1 == true || flag2 == true || flag3==true;
	}

	static int[] countTeam(int n) {
		int temp[] = new int[2];
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
		temp[0] = Collections.min(list);
		temp[1] = Collections.max(list);
		return temp;
	}
	
	static	int stopLight(int[] arr) {
		
	}
	
	static	int firstBigger(int a, int b) {
	}
	
	static boolean isInfiniteProcess(long a, long b) {
		// a bé hơn b	
		
		if ((a==0 && b%2==0) || (a%2==0 && b==0) ) {
			return false;
		}
		
		if (a > b && a%2==0 && b%2==0) {
			return false;
		}
		
		if (a > b && a%2!=0 && b%2!=0) {
			return false;
		}
		return true;
	}
	
	static	int stackofbricks(int[] a) {
		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			integers.add(a[i]);
		}
		int s = 0;;
		integers.sort((o1,o2) -> o2-o1);
		  for(int i=1;i< integers.size();i++)
		    {
		        if(a[i]>=s) s++;
		    }
		    return s;
	}
	
	public static void main(String[] args) {
		int a[] = {3,2,2,2,2,2};
		System.out.println(stackofbricks(a));
	}

}
