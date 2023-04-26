package com.hdcompany.congviec.duc;

import java.util.Arrays;
import java.util.Comparator;

//Thuật toán tham lam 
public class MainClass {

	public static void main(String[] args) {
		int[][] congViec = { { 1, 3 }, { 1, 2 }, { 4, 7 }, { 6, 9 }, { 8, 10 }, { 9, 11 } };
		int n = congViec.length;

		// Sắp xếp các công việc theo thời gian kết thúc tăng dần
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (congViec[i][1] > congViec[j][1]) {
					// Swap congViec[i] and congViec[j]
					int[] temp = congViec[i];
					congViec[i] = congViec[j];
					congViec[j] = temp;
				}
			}
		}

		// Chọn các công việc không chồng chéo lên nhau
		int[] chonCongViec = new int[n];
		int k = 0;
		chonCongViec[k] = 0;
		for (int i = 1; i < n; i++) {
			if (congViec[i][0] >= congViec[chonCongViec[k]][1]) {
				k++;
				chonCongViec[k] = i;
			}
		}

		// In ra dãy công việc được chọn
		System.out.println("Maximum job sequence:");
		for (int i = 0; i <= k; i++) {
			System.out.println("Job " + chonCongViec[i] + ": start time = " + congViec[chonCongViec[i]][0]
					+ ", end time = " + congViec[chonCongViec[i]][1]);
		}
	}
}
