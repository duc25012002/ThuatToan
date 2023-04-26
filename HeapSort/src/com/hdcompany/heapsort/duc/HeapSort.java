package com.hdcompany.heapsort.duc;

import java.util.Arrays;

///Sắp xếp vun đống tìm phần tử lớn nhất rồi ném ra ngoài

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = { 6, 7, 8, 5, 4, 1, 2, 3 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void heapSort(int[] arr) {
		int n = arr.length;
		int lastParentNode = n / 2 - 1;

		// Xây dựng heap (sắp xếp lại mảng).
		for (int i = lastParentNode; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// Lấy lần lượt một phần tử trong heap.
		for (int i = n - 1; i >= 0; i--) {
			// Di chuyển nút gốc hiện tại đến cuối.
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Gọi max heapify trên heap đã giảm.
			heapify(arr, i, 0);

		}
	}

	/*
	 * Heapify một cây con được gốc tại node i (i = 3), đó là một chỉ số trong mảng
	 * arr[]. n = 8 là kích thước của heap.
	 */
	static void heapify(int[] arr, int n, int i) {
		int nutGoc = i;
		int nutTrai = 2 * i + 1;
		int nutPhai = 2 * i + 2;

		// Nếu nút con trái lớn hơn nút gốc.
		if (nutTrai < n && arr[nutTrai] > arr[nutGoc]) {
			nutGoc = nutTrai;
		}
		// Nếu nút con phải lớn hơn nút gốc.
		if (nutPhai < n && arr[nutPhai] > arr[nutGoc]) {
			nutGoc = nutPhai;
		}

		// Nếu nutGoc không phải nút gốc.
		if (nutGoc != i) {
			int temp = arr[i];
			arr[i] = arr[nutGoc];
			arr[nutGoc] = temp;
			heapify(arr, n, nutGoc);
		}

	}

}
