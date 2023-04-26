package com.hdcompany.doitien.duc;

import java.util.Scanner;

import java.util.*;

// Thuật toán tham lam để tìm giải pháp 1 cách nhanh nhất.
// Thuật toán vét cạn là sắp xếp chọn ra giải pháp tối ưu nhất.
public class MainClass {
	public static void main(String[] args) {

		// -----------------VET CAN-------------------------
		int[] bills = { 2, 3 };
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so tien can doi: ");
		int amount = sc.nextInt();
		int count = 0;
		System.out.println("So to tien can tra la: ");
		for (int i = 0; i < bills.length && amount > 0; i++) {
			while (amount >= bills[i]) {
				System.out.print(bills[i] + " ");
				amount -= bills[i];
				count++;
			}
		}
		System.out.println("\nTong so to tien can tra la: " + count);

		// ------------------THAM LAM----------------------------
		Scanner scanner = new Scanner(System.in);

		// Nhập số loại tiền và mệnh giá của chúng
		System.out.print("Nhập số loại tiền: ");
		int n = scanner.nextInt();
		int[] menhGia = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập mệnh giá của tiền loại thứ " + (i + 1) + ": ");
			menhGia[i] = scanner.nextInt();
		}

		// Nhập số tiền cần rút
		System.out.print("Nhập số tiền cần rút: ");
		int soTienCanRut = scanner.nextInt();

		// Rút tiền và in kết quả
		int[] soTo = rutTien(menhGia, soTienCanRut);

		int tong = 0;
		for (int i = 0; i < n; i++) {
			tong = tong + menhGia[i] * soTo[i];
		}

		if (tong != soTienCanRut) {
			System.out.println("Doi khong thanh cong");
		} else {
			System.out.println("Số tiền cần rút ở mỗi mệnh giá:");
			for (int i = 0; i < n; i++) {
				System.out.println(menhGia[i] + ": " + soTo[i]);

			}
		}
	}

	public static int[] rutTien(int[] menhGia, int soTienCanRut) {
		Arrays.sort(menhGia); // sắp xếp các mệnh giá tiền giảm dần
		int n = menhGia.length;
		int[] soTo = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int count = soTienCanRut / menhGia[i];
			soTo[i] = count; // lưu số tờ tiền cần rút ở mệnh giá thứ i
			soTienCanRut -= count * menhGia[i]; // trừ số tiền đã rút được khỏi số tiền cần rút
		}
		return soTo;
	}

}
