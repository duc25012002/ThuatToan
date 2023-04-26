package com.hdcompany.tohop.duc;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int k = 2;
		int[] combo = new int[k];
		printCombinations(arr, combo, 0, 0);
	}

	public static void printCombinations(int[] arr, int[] combo, int i, int j) {
		if (j == combo.length) { // Nếu combo đã chứa k phần tử
			System.out.println(Arrays.toString(combo)); // In ra combo
			return;
		}
		if (i == arr.length) { // Nếu đã duyệt hết tất cả các phần tử
			return;
		}
		combo[j] = arr[i]; // Chọn phần tử ở vị trí i vào combo
		printCombinations(arr, combo, i + 1, j + 1); // Gọi đệ quy để thêm phần tử vào combo
		printCombinations(arr, combo, i + 1, j); // Không chọn phần tử ở vị trí i vào combo
	}
}
