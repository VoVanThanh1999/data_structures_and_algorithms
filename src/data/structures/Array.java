package data.structures;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;
import javax.crypto.spec.IvParameterSpec;
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
			while (pivot < a[i]) {
				i++;
			}
			while (pivot > a[j]) {
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

		if (a[0] > 0 || a[0] < 0 && flag == false) {
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
		return flag1 == true || flag2 == true || flag3 == true;
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

	static int stopLight(int[] arr) {

	}

	static int firstBigger(int a, int b) {
	}

	static boolean isInfiniteProcess(long a, long b) {
		// a bé hơn b

		if ((a == 0 && b % 2 == 0) || (a % 2 == 0 && b == 0)) {
			return false;
		}

		if (a > b && a % 2 == 0 && b % 2 == 0) {
			return false;
		}

		if (a > b && a % 2 != 0 && b % 2 != 0) {
			return false;
		}
		return true;
	}

	static int stackofbricks(int[] a) {
		List<Integer> gachs = new ArrayList<>();
		List<Integer> check = new ArrayList<>();
		int count = 1;
		boolean flag = true;
		for (int i = 0; i < a.length; i++) {
			gachs.add(a[i]);
		}
		gachs.sort((o1, o2) -> (o2 - o1));
		check.add(gachs.get(0));
		while (flag == true && count < gachs.size()) {
			boolean flag1 = true;
			for (int i = 0; i < check.size(); i++) {
				if (check.get(i) < 1) {
					flag1 = false;
				}
			}
			if (flag1) {
				check.add(gachs.get(count));
				count++;
				for (int i = 0; i < check.size() - 1; i++) {
					check.set(i, check.get(i) - 1);
				}
			} else {
				flag = false;
			}

		}
		return count;

	}

	static String jumpingFrog(int[] a) {
		long x1 = a[0];
		long x2 = a[1];
		long v1;
		long v2;
		long jum1;
		long jum2;
		if (a[0] < a[1]) {
			jum1 = x1;
			jum2 = x2;
			v1 = a[2];
			v2 = a[3];
		} else {
			jum1 = x2;
			jum2 = x1;
			v1 = a[3];
			v2 = a[2];
		}
		if (jum1 < jum2 && v1 <= v2) {
			return "No";
		}
		while (jum1 < jum2) {
			jum1 += v1;
			jum2 += v2;
		}
		if (jum1 == jum2) {
			return String.valueOf(jum1);
		}
		return "NO";
	}

	static boolean isSortedArray(int[] arr) {
		boolean flag1 = true;
		boolean flag2 = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				flag1 = false;
			}
			if (arr[i] < arr[i - 1]) {
				flag2 = false;
			}
		}
		return flag1 == true || flag2 == true;
	}

	static boolean tankParade(int[] arr) {

	}

	static int doingHomework(int[] a) {
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			for (int j = i; j < a.length; j++) {
				if (a[i] < a[j] && i != j) {
					sum += a[j];
					i++;
				} else if (a[i] >= a[j] && i != j) {
					list.add(sum);
					i = j - 1;
					break;
				}
			}
			list.add(sum);
			sum = 0;
		}
		return Collections.max(list);
	}

	static int sumFillerDiagonal(int[][] a) {
		int n = a.length - 1;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i][n];
			n--;
		}
		return sum;
	}

	static int gradeCheating(int n, int m, int[] a) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		if (sum < m) {
			return sum;
		}
		return m;
	}

	static int gcdOfNumbers(int[] a) {
		int arr[] = quickSort(a, 0, a.length - 1);
		int gcd = 1;
		List<Integer> list = new ArrayList<>();
		while (gcd < a[a.length - 1]) {
			boolean flag = true;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % gcd != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				list.add(gcd);
			}
			gcd++;
		}

		return Collections.max(list);
	}

	static int uniqueNumber(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return arr[i];
			}
		}
		return -1;
	}

	static int[] findDistinctNumbers(int[] a) {
		Map<Integer, Boolean> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], true);
		}

		for (int i = 0; i < a.length; i++) {
			if (map.get(a[i]) == true) {
				list.add(a[i]);
				map.put(a[i], false);
			}
		}
		int b[] = new int[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
	}

	static int missingNumber(int[] arr) {
		int a[] = quickSort(arr, 0, arr.length - 1);
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

	static int numberGameIII(int[] s) {
		int arr[] = quickSort(s, 0, s.length - 1);
		boolean flag = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] % arr[0] != 0) {
				flag = false;
			}
		}
		if (flag) {
			return arr[0];
		}
		return -1;
	}

	static boolean beautifulArray(int[] arr) {
		int mid = 0;
		int sum1 = 0;
		int sum2 = 0;
		if (arr.length == 0 || arr.length == 1) {
			return false;
		}
		if (arr.length == 2) {
			mid = 1;
		} else {
			mid = arr.length / 2;

		}
		for (int i = 0; i < arr.length; i++) {
			if (i < mid) {
				sum1 += arr[i];
			} else if (i > mid) {
				sum2 += arr[i];
			}
		}
		return sum1 == sum2;

	}

	static boolean findRange(int[] array, int n) {
		int count = 1;

		while (count < array.length) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == n) {
					return true;
				}

			}

		}
		return false;
	}

	static int firstMultiple(int[] divisors, int start) {
		while (true) {
			boolean flag = true;
			for (int i = 0; i < divisors.length; i++) {
				if (start % divisors[i] != 0) {
					flag = false;
					break;
				}
			}
			if (flag == false) {
				start++;
				continue;
			} else {
				return start;
			}
		}
	}

	static int[] primeFactors(int n) {
		List<Integer> list = new ArrayList<>();
		int value = n;
		if (n < 2) {
			int s[] = {};
			return s;
		}
		for (int i = 2; i <= n; i++) {
			if (MathClasss.isPrime(i) && value % i == 0) {
				value /= i;
				list.add(i);
				i = i - 1;
			}
			if (value == 1) {
				int t[] = new int[list.size()];
				for (int j = 0; j < list.size(); j++) {
					t[j] = list.get(j);
				}
				return t;
			}
		}
		return null;
	}

	static int mode(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int value = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (map.containsKey(arr[i]) == false) {
				map.put(arr[i], count);
			}
		}
		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() >= max) {
				max = i.getValue();
			}
		}
		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() == max) {
				int val = i.getKey() * max;
				value += val;
			}
		}
		return value;

	}

	static int quizSolve(int[] arr, int x) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (x > arr[i]) {
				count++;
				x++;
			} else {
				break;
			}
		}
		return count;
	}

	static long repeatingScreen(int[] arr, int k, int n) {

	}

	static int[] findTeam(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (map.get(arr[i]) == null) {
				map.put(arr[i], count);
			}
		}
		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() == k) {
				list.add(i.getKey());
			}
		}
		Collections.sort(list);
		int temp[] = new int[list.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = list.get(i);
		}
		return temp;
	}

	static int sofaShipping(int[] a) {
		List<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			list.add(a[i]);
		}
		int len = list.size();
		while (len > 0) {
			int min = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i) <= min) {
					min = list.get(i);
				}
			}
			for (int i = 0; i < list.size(); i++) {
				count++;
				if (list.get(i) == min) {
					list.remove(i);
					len--;
					break;
				}

			}
		}
		return count;
	}

	int minimalistFractions(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] == 1) {
					continue;
				} else if (i != j && a[i] != 0 && a[j] != 0) {
					boolean flag = true;
					int tuSo = a[i];
					int mauSo = a[j];
					if (mauSo == 1) {
						count++;
						continue;
					}
					int min = tuSo;
					if (min < mauSo) {
						min = mauSo;
					}
					while (min > 1) {
						if (tuSo % min == 0 && mauSo % min == 0) {
							flag = false;
							break;
						}
					}
					if (flag) {
						count++;
					}
				}
			}
		}
		return count;
	}

	static String arrayProperty(int[] a) {
		int val = a[1] - a[0];
		boolean linear = true;
		boolean exponential = true;

		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] + val != a[i]) {
				linear = false;
			}
		}
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] * val != a[i]) {
				exponential = false;
			}
		}
		if (linear) {
			return "Linear - Arithmetic Difference = ".concat(String.valueOf(val));
		}
		if (exponential) {
			return "Exponential - Geometric Difference = ".concat(String.valueOf(val));
		}
		return "Undetermined";
	}

	static int longestArrays(int[] a) {
		int count = 1;
		int max = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] >= a[i - 1]) {
				count++;
			} else {
				if (count > max) {
					max = count;
					count = 1;
				}
				count = 1;
			}
		}
		if (count > max) {
			max = count;
			count = 1;
		}
		return max;
	}

	static int[] towers(int[] arr) {
		int max = 0;
		Set<Integer> integers = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			integers.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > max) {
				max = count;
			}
		}
		int a[] = { max, integers.size() };
		return a;
	}

	static boolean areSimilar(int[] a, int[] b) {
		int d = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				d++;
		}
		if (d != 0 && d != 2) {
			return false;
		}
		int arr[] = quickSort(a, 0, a.length - 1);
		int arrB[] = quickSort(a, 0, b.length - 1);
		for (int i = 0; i < arrB.length; i++) {
			if (arr[i] != arrB[i]) {
				return false;
			}
		}
		return true;
	}

	static boolean timeSleep(int[] x) {
		int value = 0;
		for (int i = 1; i < x.length; i++) {
			if (i % 2 != 0) {
				value = x[i] - x[i - 1];
			}
		}
		return value < 6;
	}

	static int mettingRoom(int[] s, int[] e) {
		int count = 1;
		for (int i = 0; i < e.length; i++) {
			for (int j = i + 1; j < e.length; j++) {
				if (e[j] < e[i]) {
					int temp = e[i];
					e[i] = e[j];
					e[j] = temp;
					int temp1 = s[i];
					s[i] = s[j];
					s[j] = temp1;
				}
			}
		}
		int end = e[0];
		for (int i = 1; i < e.length; i++) {
			if (s[i] > end) {
				count++;
				end = e[i];
			}
		}
		return count;
	}

	static int numberOfSubArray(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		String temp = "";
		int max = 5;
		int min = 5;
		for (int i = 0; i < arr.length; i++) {
			max += Math.abs(arr[i]);
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		while (min <= max) {
			int value = min;
			for (int i = 0; i < arr.length; i++) {
				int count3 = 1;
				int sum = arr[i];
				if (sum == value) {
					temp += String.valueOf(arr[i]) + " ";
				}
				for (int j = i + 1; j < arr.length; j++) {
					sum += arr[j];
					count3++;
					if (sum == value) {
						temp += String.valueOf(arr[i]).concat(String.valueOf(arr[j])) + " ";
					}
					if (sum > value) {
						break;
					}
					if (count3 == 2) {
						break;
					}
				}
			}
			min++;
		}
		System.out.println(temp);

		for (int i = 0; i < temp.length(); i++) {
			int value = 0;
			boolean flag = false;
			int sum = 0;
			for (int j = i; j < temp.length(); j++) {
				if (String.valueOf(temp.charAt(j)).equals(" ") && flag == false) {
					sum = 0;
					break;
				} else if (String.valueOf(temp.charAt(j)).equals(" ") && flag == true) {
					break;
				} else {
					flag = true;
					value = j;
					sum += Character.getNumericValue(temp.charAt(j));
				}
			}
			if (flag) {
				list.add(sum);
				i = value;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			int count = 1;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == list.get(j)) {
					count++;
				}
			}
			if (map.containsKey(list.get(i)) == false) {
				map.put(list.get(i), count);
			}
		}

		int max1 = 0;
		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() > max1) {
				max1 = i.getValue();
			}
		}
		return max1;
	}

	static int sortDesc(final int num) {
		// Your code
		List<String> list = new ArrayList<>();
		String s = new String(String.valueOf(num));
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
		}
		Collections.sort(list, Collections.reverseOrder());
		for (int i = 0; i < list.size(); i++) {
			temp += String.valueOf(list.get(i));
		}
		return Integer.valueOf(temp);
	}

	static int countMoney(int money) {
		List<String> list = new ArrayList<>();
		int a[] = { 20, 10, 5, 2, 1 };
		int i = 0;
		int count = 0;
		int value = money - 21;
		while (value != 0 && i < a.length) {
			value = value - a[i];
			list.add(String.valueOf(a[i]));
			count++;
			if (value < 0) {
				value += a[i];
				count--;
				i++;
				list.remove(list.size() - 1);
			}
		}
		for (int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j) + " ");
		}
		System.out.println("");

		return count;
	}

	static boolean diagonalMatrix(int[][] a) {
		boolean flag = true;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (count != j) {
					if (a[i][j] != 0) {
						flag = false;
					}
				}
			}
			count++;
		}
		count = a.length - 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (count != j) {
					if (a[i][j] != 0) {
						flag = false;
					}
				}
			}
			count--;
		}
		return flag == true;
	}

	static int steelTempest(int[] ingame) {
		int value = 0;
		int count = 0;
		for (int i = 0; i < ingame.length; i++) {
			if (value == 2) {
				value = 0;
				count++;
			} else if (ingame[i] == 1) {
				value++;
			} else {
				value = 0;
			}
		}
		return count;
	}

	static int minValue(int[] values) {

	}

	static boolean gamePlay(int[] time) {
		int sum = 0;
		for (int i = 0; i < time.length; i++) {
			if (i > 0 && i % 2 != 0) {
				if (time[i] - time[i - 1] >= 5)
					return true;
				sum += time[i] - time[i - 1];
			}
		}
		return sum >= 8 ? true : false || time[0] == 8 || time[time.length - 1] == 8;
	}

	static boolean linePoints(int[][] points) {

	}

	static boolean additionSubArray(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			list.add(arr[i] - arr[i - 1]);
		}
		if (list.size() < 2) {
			return false;
		}
		for (int i = 1; i < list.size(); i++) {
			map.put(list.get(i) - list.get(i - 1), 0);
		}
		for (int i = 1; i < list.size(); i++) {
			if (map.containsKey(list.get(i) - list.get(i - 1))) {
				map.put(list.get(i) - list.get(i - 1), map.get(list.get(i) - list.get(i - 1)) + 1);
			}
		}
		for (Map.Entry<Integer, Integer> integer : map.entrySet()) {
			if (integer.getValue() > 1) {
				return true;
			}
		}
		return false;
	}

	static int numberRainbows(int[] colors) {
		boolean flag = true;
		int count = 0;
		int count1 = 0;
		int a[] = quickSort(colors, 0, colors.length - 1);
		while (flag == true) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] > 0) {
					a[i] = a[i] - 1;
					count++;
				}
				if (count == 7) {
					break;
				}
			}
			if (count == 7) {
				count = 0;
				count1++;
				a = quickSort(a, 0, a.length - 1);
				continue;
			} else {
				flag = false;
			}
		}
		return count1;
	}

	static int[] roboPosition(String run) {
		int trucOX = 0;
		int val1 = 0;
		int val2 = 0;
		boolean flag = true;
		String temp = "";
		String value = "";
		for (int i = 0; i < run.length(); i++) {
			if (run.charAt(i) == 44) {
				if (temp.equals("")) {

				}
			} else {
				temp += String.valueOf(run.charAt(i));
			}
		}
		int result[] = { val1, val2 };
		return result;
	}

	static boolean linePoints1(int[][] points) {
		/*
		 * boolean flag = true; boolean flag1 = true; for (int i = 1; i < points.length;
		 * i++) { if (points[0][i] != points[0][i-1]) { flag = false; } } for (int i =
		 * 1; i < points.length; i++) { if (points[i][0] != points[i][0]) { flag1 =
		 * false; } } boolean flag2 = true; boolean flag3 = true; int min =
		 * points[0][0]; int min1 = points[0][0]; int max = 0; int max1 = 0;
		 * 
		 * for (int i = 0; i < points.length; i++) { if (points[i][0] > max) { max =
		 * points[i][0]; } if (points[i][0] < min) { min = points[i][0]; } if
		 * (points[0][i] > max1) { max1 = points[0][i]; } if (points[0][i] < min1) {
		 * min1 = points[0][i]; } } while (min<=max) { boolean flags = false; for (int i
		 * = 0; i < points.length; i++) { if (points[i][0]==min) { flags =true; } } if
		 * (flags==false) { flag2 = false; break; } min+=1; } while (min1<=max1) {
		 * boolean flags = false; for (int i = 0; i < points.length; i++) { if
		 * (points[0][i]==min1) { flags =true; } } if (flags==false) { flag3 = false;
		 * break; } min+=1; } return flag2|| flag3 || flag || flag1;
		 */
	}

	public static int[] deleteNth(int[] elements, int maxOccurrences) {
		// Code here ;)
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < elements.length; i++) {
			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) == elements[i]) {
					count++;
				}
			}
			if (count < maxOccurrences) {
				list.add(elements[i]);
			}
		}
		int temp[] = new int[list.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = list.get(i);
		}
		return temp;
	}

	public static boolean comp(int[] a, int[] b) {
		if (a == null || b == null || a.length != b.length)
			return false;
		long sumA = 0;
		long sumB = 0;
		for (int i = 0; i < a.length; i++) {
			sumA += Math.abs(a[i]);
			sumB += Math.sqrt(b[i]);
		}

		return sumA == sumB;
	}

	public static long[] gap(int g, long m, long n) {
		// your code
		while (g + m <= n) {
			if (m % 2 != 0 && g + m % 2 != 0) {
				if (MathClasss.isPrime(m) && MathClasss.isPrime(g + m)) {
					boolean flag = true;
					long val = m + 1;
					while (val < (g + m) - 1) {
						if (MathClasss.isPrime(val)) flag = false;
						val++;
					}
					if (flag) {
						long temp[] = { m, g + m };
						return temp;
					} else {
						m++;
						continue;
					}
				} else {
					m++;
				}
			} else {
				m++;
			}
		}
		return null;
	}
	public static boolean check(int[][] sudoku) {
		if (sudoku.length!=9) {
			return false;
		}
		int count = 0;
		boolean flag = true;
		while (count<sudoku.length) {
			for (int j = 1; j <= sudoku.length; j++) {
				if (j%3==0) {
					if (!checkSodoku(showSodokuX3X(count,j,sudoku))) {
						flag = false;
					}
				}
			}
			count+=3;
		}
		return flag;
	}
	
	private static int[][] showSodokuX3X(int i, int j, int[][] sudoku) {
		// TODO Auto-generated method stub
		int val = i;
		int val1;
		if (j==3) {
			val1 = 0;
		}else if (j==6) {
			val1 = 3;
		}else  {
			val1= 6;
		}
		int array[][] = new int[3][3];
		int len = val+3;
		int c = 0;
		while (val<len) {
			int temp = val1;
			int h = 0;
			while (temp<j) {
				array[c][h] = sudoku[val][temp];
				temp++;
				h++;
			}
			c++;
			val++;
		}
		return array;
	}

	public static boolean checkSodoku(int[][] sudoku) {
		 //do your magic
		boolean flag = true;
		for (int i = 0; i < sudoku.length; i++) {
			Set<Integer> set = new HashSet<>();
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < sudoku.length; j++) {
				set.add(sudoku[i][j]);
				list.add(sudoku[i][j]);
			}
			if (set.size()!=list.size()) {
				flag = false;
				break;
			}
		}
		int count = 0;
		while (count < sudoku.length) {
			Set<Integer> set = new HashSet<>();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < sudoku.length; i++) {
				set.add(sudoku[i][count]);
				list.add(sudoku[i][count]);
			}
			if (set.size()!=list.size()) {
				flag = false;
				break;
			}
			count++;
		}
		
		return flag;
    }
<<<<<<< HEAD
	static	int maxNumberArray(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], a[i]);
			
		}
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i]>max) {
				max = a[i];
			}
			
		}
		max = max-1;
		while (max > 0) {
			if (map.containsKey(max)==false) {
				return max;
			}
			max--;
			
		}
		return -1;
		
	}
	public static int[] snail(int[][] array) {
	     // enjoy
	} 
	
	static void staircase(int n) {
		for (int i = 0; i <n; i++) {
			for (int j = 0; j <=i; j++) {
				System.out.print("#");
			}
			System.out.println("\n");
		}

	}
	
	public static void main(String[] args) {
		int a[] = {0 ,-1};
		ArrayList<Integer> arrayList = new ArrayList<>();

		staircase(4);
=======
	
	static void miniMaxSum(int[] arr) {
		long min = arr[0];
		long max = arr[0];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if (arr[i]>max) {
				max = arr[i];
			}
			if (arr[i]<min) {
				min = arr[i];
			}
		}
		System.out.println((sum-max)+" "+(sum-min));
    }
	static int birthdayCakeCandles(int[] ar) {
		int max = ar[0];
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i]>max) {
				max = ar[i];
			}
		}
		for (int i = 0; i < ar.length; i++) {
			if (ar[i]==max) {
				count++;
			}
		}
		return count;
    }
	
	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here
		List<Integer> output = new ArrayList<>();
		for (Integer integer : grades) {
			if (boiSo(integer)-integer<3 && boiSo(integer)>39) {
				output.add(boiSo(integer));
			}else {
				output.add(integer);
			}
		}
		return output;
	}
	
	private static Integer boiSo(Integer integer) {
		// TODO Auto-generated method stub
		int val = integer+1;
		while (val%5!=0) {
			val++;
		}
		return val;
	}
	
	static int[] breakingRecords(int[] scores) {
		int max = scores[0];
		int min = scores[0];
		int countMax = 0;
		int countMin = 0;
		int temp[] =new int [2];
		for (int i = 1; i < scores.length; i++) {
			if (scores[i]>max) {
				max = scores[i];
				countMax++;
			}
			if (scores[i]<min) {
				min = scores[i];
				countMin++;
			}
		}
		temp[0] = countMax;
		temp[1] = countMin;
		return temp;
	}
	
	static int birthday(List<Integer> s, int d, int m) {
		int count = 0;
		for (int i = 0; i <=s.size()-m; i++) {
			int sum = 0;
			for (int j = i; j <i+m; j++) {
				sum+=s.get(j);
			}
			if (sum==d) {
				count++;
			}
		}
		return count;
    }
	
	static int migratoryBirds(List<Integer> arr) {
		

    }
	
	public static void main(String[] args) {
		int a[] = {1,3,2,6,1,2};
		System.out.println(divisibleSumPairs(6,3,a));
>>>>>>> 700e4870c1c509d600977b42d1e1a2301538744b
	}

}
