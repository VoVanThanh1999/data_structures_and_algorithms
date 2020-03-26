package data.structures;

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
			if (pivot>a[i]) {
				i++;
			}
			if (pivot<a[j]) {
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
	
	public static void main(String[] args) {
		int a[] = { 4, 2,5};
		showArray(quickSort(a, 0, a.length - 1));
	}
}
