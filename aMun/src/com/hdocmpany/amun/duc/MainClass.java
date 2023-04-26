package com.hdocmpany.amun.duc;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) throws Exception {
		int a, n;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao so can tinh: ");
		a = sc.nextInt();
		System.out.println("Nhap vao so mu: ");
		n = sc.nextInt();
		System.out.println(a + " mu " + n + " = " + soMu(a, n));
	}

	public static int soMu(int a, int n) {
		if (n == 0) {
			return 1;
		} else {
			if (n == 1) {
				return a;
			} else {
				if (n % 2 == 0) {
					//Nếu n là số chẵn
					return soMu(a, n / 2) * soMu(a, n / 2);
				} else {
					return soMu(a, n - 1) * soMu(a, 1);
				}
			}
		}
	}
}