package com.hdcompany.hoanvi.duc;

import java.io.BufferedReader;
import java.io.*;
import java.util.Arrays;


//Thuật toán quay lui, kiểm tra xem hàm đã được duyệt qua hay chưa.
public class MainClass {
	public static int[] check;
	public static int[] hoanVi;

	public static int[] readData() {
		String filename = "C:\\Users\\UYEN\\Desktop\\Code\\TimHoanVi\\src\\com\\hdcompany\\hoanvi\\duc\\mydata.txt";
		int[] array = new int[1];
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(" ");
				if (row == 0) {
					int n = Integer.parseInt(values[0]);
					array = new int[n];
					row++;
				} else {
					for (int i = 0; i < values.length; i++) {
						array[i] = Integer.parseInt(values[i]);
					}
				}
			}
			return array;
		} catch (IOException e) {
			return array;
		}
	}

	public static void main(String[] args) throws Exception {
		int[] a = readData();
		int n = a.length;
		check = new int[n];
		hoanVi = new int[n];
		hoanVi(a, 0);
	}

	private static void hoanVi(int[] a, int i) {
		for (int j = 0; j < a.length; j++) {
			if (check[j] == 0) {
				check[j] = 1;
				if (i < a.length) {
					hoanVi[i] = a[j];
				}

				if (i == a.length - 1) {
					System.out.println(Arrays.toString(hoanVi));
				} else {
					hoanVi(a, i + 1);
				}
				check[j] = 0;
			}
		}
	}

}