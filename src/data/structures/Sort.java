package data.structures;

import java.util.ArrayList;
import java.util.List;

public class Sort {
	static int[] bubbleSortArray(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length; j > i; j--) {
				if (arr[j - 1] < arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	static public void showArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
 			System.out.print(a[i] + " ");
		}
	}

	static int[] mergeSort(int item[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
 			mergeSort(item, left, mid);
			mergeSort(item, mid + 1, right);
			merge(item, left, mid, right);
		}
		return item;
	}
	

	
	static void merge(int[] a, int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int n = right-left + 1;
		int k = 0;
		int temp[] = new int [n];
		
		while ((i<=mid)&& (j<=right)) {
			if (a[i]<a[j]) {
				temp[k] = a[i];
				i++;k++;
			}else {
				temp[k] = a[j];
				j++;k++;
			}
		}
		while (i<=mid) {
			temp[k] = a[i];
			k++;i++;
		}
		while (j<=right) {
			temp[k] = a[j];
			k++;j++;
		}
		i = left;
		for (k = 0; k < n; k++) {
			a[i] = temp[k];
			i++;
		}
		temp = null;
	}
	
	static int[] quickSort(int a[],int l, int r) {
		int pivot = a[l];
		int i = l;
		int j = r;
		int temp = 0;
		while (i<=j) {
			while(pivot>a[i]) {
				i++;
			}
			while (pivot<a[j]) {
				j--;
			}
			if (i<=j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if (l<j) {
			quickSort(a,l, j);
		}
		if (r>i) {
			quickSort(a, i, r);
		}
		return a;
	}
	static	int[] sortByHeight(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length-1; j > i; j--) {
				if (a[i] ==-1 || a[j]==-1) continue;
				if (a[i]>a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
				}
			}
		}
		return a;
	}
	
	static int[] sortByHeightWithQuickSort(int a[],int left,int right) {
		int i = left;
		int pivot = a[left];
		int j = right;
		int temp =0;
		while (i<=j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot ) {
				j--;
			}
			if (i<=j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if (left < j) {
			sortByHeightWithQuickSort(a,left,j);
		}
		if (i<right) {
			sortByHeightWithQuickSort(a,i,right);
		}
		return a;
	}
	
	static	String[] sortByLength(String[] inputArray) {
		try {
			String[] input1 = new String[inputArray.length];
			for (int i = 0; i < input1.length; i++) {
				input1[i] = inputArray[i];
			}
			String temp = "";
			for (int i = 0; i < inputArray.length; i++) {
				for (int j = i+1; j<inputArray.length; j++ ) {
					if (inputArray[i].length() > inputArray[j].length()) {
						temp = inputArray[i];
						inputArray[i] = inputArray[j];
						inputArray[j] = temp;
					}
				}
			}
			
			for (int i = 0; i < inputArray.length; i++) {
				for (int j = i+1; j < inputArray.length; j++) {
		
					if (inputArray[i].length() == inputArray[j].length()) {
						if (checkIndexString(input1, inputArray[i])>checkIndexString(input1, inputArray[j]) ) {
							temp = inputArray[i];
							inputArray[i] = inputArray[j];
							inputArray[j] = temp;
						}
					}
				}
			}
			for (int i = 0; i < inputArray.length; i++) {
				System.out.println(inputArray[i]);
			}
			return inputArray;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	static int checkIndexString(String a[],String b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] ==b) {
				return i;
			}
		}
		return -1;
	}
	static boolean areSimilar(int[] a, int[] b) {
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();
		int lenA = a.length;
		int lenB = b.length;
 		for (int i = 0; i < a.length; i++) {
			listA.add(a[i]);
			listB.add(b[i]);
		}
 		for (int i = 0; i <lenA ; i++) {
			for (int j = 0; j < lenB; j++) {
				if (listA.get(i) == listB.get(j)) {
					listA.remove(i);
					listB.remove(j);
					j--;i--;lenA--;lenB--;
					break;
				}
			}
		}
 		if (listA.isEmpty() && listB.isEmpty()) {
			return true;
		}
 		return false;
		
	}
	
	static	int[] digitalSumSort(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (sumDigital(a[i])<sumDigital(a[j])) {
					temp = a[i];
					a[i] = a[j];
					a[j] =temp;
				}
				if (sumDigital(a[i]) == sumDigital(a[j])) {
					if (a[i] > a[j]) {
						temp = a[i];
						a[i] = a[j];
						a[j] =temp;
					}
				}
			}
		}
		return a;
	}
	
	static int sumDigital(int n) {
		if (n<10) {
			return n;
		}
		int sum = 0;
		while (n!=0) {
			int a=n%10;
			 sum =sum+ n%10;
			n=n/10;
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		int a[] = {13, 20, 7, 4};
		int b[] = {2,1,1};
		String c[] = {"aaa","bbb","a"};
		System.out.println(sortByLength(c));
	}
}
