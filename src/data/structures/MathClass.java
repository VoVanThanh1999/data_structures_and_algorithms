package data.structures;

import java.util.Scanner;

public class MathClass {
	static Scanner sc = new Scanner(System.in);
	
	static boolean isPrime(int n) {
		if (n<2) {
			return false;
		}
		for (int i = 2; i <Math.sqrt(n) ; i++) {
			if (n%i==0) return false;
		}
		return true;
	}
	
	static	int factorSum(int n) {
		int temp = n;
		int tong = 0;
		for (int i = 2; i <= n; i++) {
			while (n%i==0) {
				tong+=i;
				n=n/i;
			}
		}
		if (tong == temp) {
			return tong;
		}else {
			return factorSum(tong);
		}
	}
	
	static	int greatestCommonPrimeDivisor(int a, int b){
		try {
			int temp = 0;
			int n = a>b?a:b;
			for (int i = 2; i <=n; i++) {
				if (a%i==0 & b%i==0) {
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
	
	int maxFraction(int[] numerators, int[] denominators){
		float max =(float) numerators[0] / (float) denominators[0];
		int	kq = 0;
		for (int i = 1; i < denominators.length; i++) {
			float k = (float) numerators[i] / (float) denominators[i];
			if (k > max) {
				max = k;
				kq = i;
			}
		}
		return kq;
	}	
	
	static	int lastDigitDiffZero(int n){
		int temp = 1;
		/*int b = 0;*/
		for (int i = 1; i <= n; i++) {
			temp = temp * i;
		}
		return temp;
	}
	
	static	int NumOfOs(int x) {
		int num2 = 0, num5 =0;
		// tinh luy thua cua 2
		while (x % 2== 0) {
			num2++;
			x/=2;
		}
		// tinh luy thua cua 5
		while (x % 5==0) {
			num5++;
			x/=5;
		}
		
		return x;
	}
	
	boolean sasukeCodewar(int n, int m, int k) {
		if (n<m && n<k) {
			return true;
		}
		return false;
	}
 
	
	
	public static void main(String[] args) {
		System.out.println(NumOfOs(120));
	}

}
