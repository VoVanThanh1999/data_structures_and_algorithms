package data.structures;

import java.util.HashMap;
import java.util.Map;



public class Search {
	
	static	int searchElement(int[] a, int n) {
		int c[] = selectionSort(a);
		int b[] = uniqueArray(c);
		Map<Integer, Integer> map = new HashMap<>();
		int temp = 0;
		int count = 1;
		while (count <= b.length) {
			map.put(count, b[count-1]);
			count++;	
		}
		if (map.get(n)!= 0) {
			return map.get(n);
		}
		
		if (temp!=0) {
			return b[temp+1];
		} 
		return -1;
	}
	
	static int[] selectionSort(int[]b) {
		int temp = 0;
		int a[] = b;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i]<a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	static int[] uniqueArray(int a[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			map.put(i, a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (map.get(i)==map.get(j)) {
					map.remove(i);
				}
			}
		}
		int b[] = new int[map.size()];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (i<map.size()) {
				b[i] = entry.getValue();
				i++;
			}
            
        }
		return b;
	}
	public static void main(String[] args) {
		int[] a = {240, -637,  101,  619,  450,    9,   77, -325, -392};
		System.out.println(searchElement(a,7));
	}
}
