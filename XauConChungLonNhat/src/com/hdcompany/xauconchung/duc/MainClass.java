package com.hdcompany.xauconchung.duc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		String str1 = "BACDB";
		String str2 = "BDCB";

		int m = str1.length();
		int n = str2.length();

		// Khởi tạo ma trận dp
		int[][] dp = new int[m + 1][n + 1];

		// Tính toán ma trận dp
		int maxLength = 0; // Độ dài của xâu con chung dài nhất
		int endIndex = 0; // Chỉ số cuối cùng của xâu con chung dài nhất trong xâu str1
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > maxLength) {
						maxLength = dp[i][j];
						endIndex = i;
					}
				} else {
					dp[i][j] = 0;
				}
			}
		}

		// Xâu con chung dài nhất
		String lcs = str1.substring(endIndex - maxLength, endIndex); // cắt chuỗi

		// In ra kết quả
		System.out.println("The longest common substring has length " + maxLength + " and is \"" + lcs + "\".");
	}
}
