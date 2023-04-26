package com.hdcompany.duongdingannhat.duc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class MainClass {
	public static void main(String[] args) throws Exception {
		int[][] doThi = inputData();
		int rows = doThi.length;
		int col = doThi[0].length;
		ArrayList<Integer> duongDi = new ArrayList<>();
		boolean[] visited = new boolean[rows];
		int literation = 0;
		int start = 0;
		int end = 4;
		int current = start;
		duongDi.add(start);
		// Khởi tạo mảng duyệt, cho tất cả là vô cực
		int[][] mangDuyet = new int[rows][col];
		for (int i = 0; i < col; i++) {
			mangDuyet[0][i] = 9999;
		}
		// Khởi tạo điểm bắt đầu đầu tiên bằng 0.
		mangDuyet[0][current] = 0;

		// bắt đầu tính mảng duyệt.
		while (current != end && literation < rows - 1) {// vẫn chưa xét đến cuối
			literation++;
			if (!visited[current]) {// nếu phần tử hiện tại chưa thăm
				visited[current] = true;
				for (int i = 0; i < rows; i++) {
					if (doThi[current][i] != 0) {// Nếu hai đồ thị có nối
						mangDuyet[literation][i] = Math.min(doThi[current][i] + mangDuyet[literation - 1][current],
								mangDuyet[literation - 1][i]);// công thức
					} else {// Nếu không nối thì lấy giá trị cũ ném xuống
						mangDuyet[literation][i] = mangDuyet[literation - 1][i];
					}
				}
				int min = 9999;
				for (int i = 1; i < mangDuyet[literation].length; i++) {
					if (min > mangDuyet[literation][i] && !visited[i]) {
						min = mangDuyet[literation][i];
						current = i;
						duongDi.add(i);

					}
				}
			} else {
				mangDuyet[literation][current] = mangDuyet[literation - 1][current];//nếu đã được thăm
			}

		}

		System.out.println("Do dai tu " + start + " den " + end + " la " + mangDuyet[literation][end]);
		ArrayList<Integer> duongDuyet = new ArrayList<Integer>();
		duongDuyet.add(current);
		while (current != start) {
			int min = 9999;
			int min_index = -1;
			for (int i = 0; i < rows; i++) {
				if (mangDuyet[i][current] < min) {
					min = mangDuyet[i][current];
					min_index = i;
				}
			}
			current = duongDi.get(min_index - 1);
			duongDuyet.add(current);
		}
		Collections.reverse(duongDuyet);
		System.out.println(duongDuyet);
	}

	public static int[][] inputData() {
		int[][] doThi = new int[0][0];
		String myfile = "/Users/mac/Documents/u_ứng dụng thuật toán/DuongDiNganNhat/src/com/hdcompany/duongdingannhat/duc/mydata.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(myfile))) {
			String line;
			int rows = -1;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(" ");
				if (rows == -1) {
					int n = Integer.parseInt(values[0]);
					doThi = new int[n][n];
				} else {
					for (int i = 0; i < values.length; i++) {
						doThi[rows][i] = Integer.parseInt(values[i]);
					}
				}
				rows++;
			}
			return doThi;
		} catch (Exception e) {
			return doThi;
		}

	}
}