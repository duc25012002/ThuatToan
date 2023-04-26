package com.hdcompany.biendoixau.duc;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập xâu x: ");
		String x = scanner.nextLine();

		System.out.print("Nhập xâu y: ");
		String y = scanner.nextLine();

		int steps = transformString(x, y);

		if (steps == -1) {
			System.out.println("Không thể biến đổi xâu x thành xâu y");
		} else {
			System.out.println("Số thao tác nhỏ nhất để biến đổi xâu x thành xâu y là: " + steps);
		}
	}

	public static int transformString(String x, String y) {
		if (x.length() != y.length()) {
			return -1; // không thể biến đổi
		}
		int count = 0;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) != y.charAt(i)) {
				count++;
				char c = y.charAt(i);
				x = x.substring(0, i) + c + x.substring(i + 1);// trả về chuỗi con bắt đầu từ 0 đến i và công với chuỗi
																// con bắt đầu từ i + 1
			}
		}
		System.out.println(x);
		return count;
	}
}
