package data.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Array {
	static Scanner sc = new Scanner(System.in);
	static	int[] removeArray(int a[],int index) {
		for (int i = index; i < a.length-1; i++) {
			a[i] = a[i+1];
		}
		return a;
	}
	
	static void AddArray(int a[],int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập value thứ a ["+i+"] =");
			a[i] = sc.nextInt();
		}
	}
	
	static void showArray(int a[],int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] +"\t");
		}
	}
	
	static int[] addValueInArray(int a[],int index,int v,int n) {
		for (int i =n-1 ; i >= index; i--) {
			a[i+1] = a[i];
		}
		a[index] = v;	
		return a;
	}
	
	static int[] sortArray(int a[],int n) {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j <n; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	
		return a;
	}
	
	static int[] insertArraySorting(int a[],int value,int n) {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] >= value) {
				temp = i;
				break;
			}
		}
		for (int i = n-1; i >= temp; i--) {
			a[i+1] = a[i];
		}
		a[temp] = value;
		return a;
	}
	
	static	boolean isMonotonous(int[] sequence){
		int count1 = 1;
		int count2 = 1;
		for (int i = 1; i < sequence.length; i++) {
			int a = sequence[i];
			int b = sequence[i-1];
			if (a>b) {
				count1++;
			}
			if (a<b) {
				count2++;
			}
			if (a==b) {
				return false;
			}
		}
		if (count1 == sequence.length || count2 == sequence.length) {
			return true;
		}
		return false;
	}
	
	static	boolean isArithmeticProgression(int[] sequence){
		int temp = sequence[1]-sequence[0];
		int sum = 0;
		for (int i = 1; i < sequence.length; i++) {
			sum = sequence[i] - sequence[i-1];
			if (sum != temp) {
				return false;
			}
		}
		return true;
	}
	
	static int[] prefixSums(int[] a){
		int temp = 0;
		int b [] = new int[a.length];
		for (int i = 1; i < a.length; i++) {
			temp = 0;
			for (int j = 0; j < i; j++) {
				temp += a[j];
				b[i] =temp;
			}
		}
		b[0] = a[0];
		return b;
	}
	
	static	int[] alternatingSums(int[] a){
		try {
			int b[] = new int[2];
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 2; i < a.length; i++) {
				if (i %2== 0) {
					sum1+=a[i];
				}else {
					sum2+=a[i];
				}
			}
			if (a.length == 1) {
				b[0] = a[0];
				b[1] = 0;
			}else {
				sum1+=a[0];
				sum2+=a[1];
				b[0] = sum1;
				b[1] = sum2;
			}
			return b;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	static	int[] makeArrayConsecutive(int[] sequence){
		try {
			int temp = 0;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < sequence.length; i++) {
				for (int j = i+1; j < sequence.length; j++) {
					if (sequence[i] > sequence[j]) {
						temp = sequence[i];
						sequence[i] = sequence[j];
						sequence[j] = temp;
					}
				}
			}
			
			int a = sequence[0];
			int b = sequence[sequence.length-1];
			for (int i = a; i <= b; i++) {
				map.put(i, i);
			}
			
			for (int i = a; i <=b; i++) {
				for (int j = 0; j < sequence.length; j++) {
					if (map.get(i)==sequence[j]) {
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
				for (int j = i+1; j < array.length; j++) {
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


	
	public static void main(String[] args) {
		int a [] = {-1,-3};
		System.out.println(makeArrayConsecutive(a));;
		
	}
	
}
