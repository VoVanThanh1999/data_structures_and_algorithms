package data.structures;

import java.util.Scanner;

public class Graph {
	static Scanner sc = new Scanner(System.in);

	public static void bieuDienDoThiBangMaTranKe(int a[][], int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("i = " + (i + 1) + " j = " + (j + 1) + "  =: ");
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println("Hiển thị đồ thị bằng ma trận");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("[" + (i + 1) + " " + (j + 1) + "]" + " = " + a[i][j] + " ; ");
			}
			System.out.println();
		}
	}

	public static void bieuDienDoThiBangMaTranLienThuot(int a[][], int dinh, int canh) {
		for (int i = 0; i < dinh; i++) {
			for (int j = 0; j < canh; j++) {
				System.out.println("Dinh tại " + (i + 1) + " cạnh =" + (j + 1));
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println("Hiển thị đồ thị bằng ma trận liên thuột");
		for (int i = 0; i < dinh; i++) {
			for (int j = 0; j < canh; j++) {
				System.out.println("Dinh tại " + (i + 1) + " cạnh =" + (j + 1) + " = " + a[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		int a[][] = new int[100][100];
		bieuDienDoThiBangMaTranLienThuot(a, 2, 2);
	}
}
