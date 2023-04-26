package com.hdcompany.tongdayconlonnhat.duc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class MainClass {

	public static void main(String[] args) throws Exception {
		int[] s = dataInput();
		int n = s.length;

		// Thời gian chạy code.
		long begin = Calendar.getInstance().getTimeInMillis();
//		DuyetDayCon(s, n);
		chiaDeTri(s, n);
		// quyHoachDong(s);
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Executed Time: " + (end - begin) + " ms");

	}

	/*
	 * Duyệt dãy con cộng dồn giá trị từ vitri đầu đến vitricuối rồi so sánh với
	 * max_sum.
	 */
	public static void DuyetDayCon(int[] s, int n) {
		int max_sum = -999999;
		int start_index = 0;
		int end_index = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += s[j];
				if (sum > max_sum) {
					max_sum = sum;
					start_index = i;// lưu vị trí của i.
					end_index = j;// lưu vị trí của j.
				}
			}
		}
		// In kết quả
		System.out.println("Tong lon nhat: " + max_sum);
		System.out.print("Day con tuong ung: ");
		for (int i = start_index; i <= end_index; i++) {
			System.out.print(s[i] + " ");
		}
	}

	/*
	 * Quy hoạch động: Tổng của thằng trước + giá trị hiện tại so sánh với giá trị
	 * hiện tại
	 */
	public static void quyHoachDong(int[] s) {
		int n = s.length;
		int[] dp = new int[n]; // Tạo mảng dp để lưu trữ dãy con liên tiếp có tổng lớn nhất tại vị trí i

		// Khởi tạo giá trị đầu tiên
		dp[0] = s[0];
		int maxSum = dp[0];
		int end_index = 0;
		/*
		 * Tính toán dãy con liên tiếp có tổng lớn nhất tại vị trí i bằng cách so sánh
		 * // giá trị của số đang xét và tổng của số đó với dãy con liên tiếp có tổng
		 * lớn nhất tại vị trí i-1.
		 */
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(s[i], dp[i - 1] + s[i]);
			if (maxSum < dp[i]) {
				maxSum = dp[i];
				end_index = i;
			}
		}
		System.out.println("MaxSum = " + maxSum);
		System.out.println("end_index: " + end_index);

	}

	// Chia để trị
	public static void chiaDeTri(int[] s, int n) {
		int start_index = -1;
		int end_index = -1;
		int max_sum = timConMax(s, 0, n - 1);
		// In kết quả
		System.out.println("Tổng lớn nhất: " + max_sum);
	}

	// Chia để trị
	public static int timConMax(int[] a, int l, int r) {
		if (l == r) {
			return a[l];
		}
		int mid = (l + r) / 2;
		int left_sum = timConMax(a, l, mid);
		int right_sum = timConMax(a, mid + 1, r);
		int crossing_sum = findMaxCrossingSubarraySum(a, l, mid, r);
		System.out.println(crossing_sum);
		return Math.max(Math.max(right_sum, left_sum), crossing_sum);
	}

	// Chia để trị
	public static int findMaxCrossingSubarraySum(int[] a, int l, int mid, int r) {
		int left_sum = -999;
		int sum = 0;
		for (int i = mid; i >= l; i--) {
			sum = sum + a[i];
			if (sum > left_sum)
				left_sum = sum;
		}
		int right_sum = -999;
		sum = 0;
		for (int i = mid + 1; i <= r; i++) {
			sum = sum + a[i];
			if (sum > right_sum)
				right_sum = sum;
		}
		return left_sum + right_sum;
	}

	public static int[] dataInput() {

		String fileName = "/Users/mac/Documents/u_ứng dụng thuật toán/TongDayConLonNhat/src/com/hdcompany/tongdayconlonnhat/duc/mydata.txt";
		int[] array = new int[1];
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(" ");
				if (row == 0) {
					int n = Integer.parseInt(values[0]);
					array = new int[n];
					row++;
				}
				for (int col = 0; col < values.length; col++) {
					array[col] = Integer.parseInt(values[col]);
				}
			}
			return array;
		} catch (IOException e) {
			e.printStackTrace();
			return array;
		}
	}
};
