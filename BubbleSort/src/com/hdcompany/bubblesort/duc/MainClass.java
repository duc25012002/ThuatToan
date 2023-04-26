package com.hdcompany.bubblesort.duc;

import java.util.Arrays;
import java.util.Iterator;

//Sắp xếp nổi bọt đổi chỗ 2 phần tử với nhau, phần tử nào có giá trị nhỏ hơn thì lên trước.
public class MainClass {
	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11 };
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void bubbleSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}

			}

		}

	}

}
