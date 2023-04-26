package com.hdcompany.quicksort.duc;

import java.util.Arrays;

//Sắp xếp nhanh ném các phần tử nhỏ hơn khoá sang trái, lớn hơn khoá sang phải.
public class MainClass {
	public static void main(String[] args) {
		int[] arr = { 6, 7, 8, 5, 4, 1, 2, 3 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	static void quickSort(int arr[], int l, int r) {
		// Điều kiện dừng.
		if (l >= r) {
			return;
		}
		// Chọn key.
		int key = arr[(l + r) / 2]; // (0 + 7/2) = 3.
		// Phân bố mảng theo khóa.
		int k = partition(arr, l, r, key);
		// Chia đôi mảng rồi lặp lại.
		quickSort(arr, l, k - 1);
		quickSort(arr, k, r);
	}

	// Trả về chốt (pivot).
	static int partition(int a[], int l, int r, int key) {
		while (l <= r) {
			// l đi từ phần tử >= key để đổi chỗ.
			while (a[l] < key) {// nếu đúng thì tăng l và tìm tiếp.
				l++;
			}
			// r đi từ phần tử <= key để đổi chỗ.
			while (a[r] > key) {
				r--;
			}
			// đổi chỗ hai phần tử đang đứng không đúng vị trí.
			if (l <= r) {
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
				l++;
				r--;
			}
		}
		return l;

	}
}
