package com.hdcompany.selectionsort.duc;

//Sắp xếp chọn là sắp xếp tìm kiếm những phần tử nhỏ nhất đưa lên đầu
public class MainClass {
	public static void main(String[] args) {
		int[] arr = { 64, 25, 12, 22, 11 };
		selectionSort(arr);
		System.out.println("Sorted array:");
		printArray(arr);
	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			int viTriNhoNhat = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[viTriNhoNhat]) {
					viTriNhoNhat = j;
				}
			}

			int temp = arr[viTriNhoNhat];
			arr[viTriNhoNhat] = arr[i];
			arr[i] = temp;
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
