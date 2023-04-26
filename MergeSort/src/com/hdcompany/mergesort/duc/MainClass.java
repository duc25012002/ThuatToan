package com.hdcompany.mergesort.duc;

import java.util.Arrays;

//Sắp xếp trộn chia mảng thành nhiều mảng con rồi sắp xếp sau đó ghép các mảng đã sắp xếp vào lại với nhau.
public class MainClass {

	public int[] merge(int[] a1, int[] a2) {
		// Trộn mảng.
		// a1 và a2 là các mảng đã được sắp xếp.
		// tạo mảng mới bằng tổng phần tử của 2 mảng con.
		int n = a1.length + a2.length;
		int[] result = new int[n];
		int i = 0, i1 = 0, i2 = 0;// i0 là chỉ số của mảng result, i1 là chỉ số mảng a1, i2 là chỉ số mảng a2.
		while (i < n) {
			if (i1 < a1.length && i2 < a2.length) { // a1 và a2 != rỗng.
				if (a1[i1] <= a2[i2]) {// a1 nhỏ hơn.
					result[i] = a1[i1];
					i++;
					i1++;
				} else {// a2 nhỏ hơn.
					result[i] = a2[i2];
					i++;
					i2++;
				}

			} else {// a1 hoặc a2 rỗng.
				if (i1 < a1.length) {// a1 không rỗng.
					result[i] = a1[i1];
					i++;
					i1++;
				} else {// a2 không rỗng
					result[i] = a2[i2];
					i++;
					i2++;
				}

			}
		}
		return result;
	}

	public int[] mergeSort(int a[], int l, int r) {

		// Điều kiện dừng.
		if (l > r) {
			return new int[0];
		}
		if (l == r) {
			int[] mangDonCuoi = { a[l] };
			return mangDonCuoi;
		}

		// Chia ra.
		System.out.println("Chia: " + l + "-" + r);
		int k = (l + r) / 2;// Chia đôi mảng.
		int[] a1 = mergeSort(a, l, k);// Chia đôi nửa trái.
		int[] a2 = mergeSort(a, k + 1, r);// Chia đôi nửa phải.

		int[] result = merge(a1, a2);
		return result;
	}

	public int[] sortArray(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		MainClass s = new MainClass();
		int a[] = { 1, 5, 3, 2, 8, 7, 6, 4 };
		System.out.println(Arrays.toString(s.mergeSort(a, 0, a.length - 1)));
	}

}
