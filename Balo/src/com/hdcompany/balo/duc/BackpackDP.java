package com.hdcompany.balo.duc;

import java.io.BufferedReader;
import java.io.FileReader;

public class BackpackDP {
	public static int b;
	public static int[] a;
	public static int[] p;

	public static void main(String[] args) throws Exception {
		inputData();
		float[] pp = new float[a.length];
		for (int i = 0; i < pp.length; i++) {
			pp[i] = (float) p[i] / a[i];
		}
		int khoiLuongConLai = b;
		int giaTri = 0;
		while (khoiLuongConLai > 0) {
			float max = 0;
			int max_index = -1;
			for (int i = 0; i < pp.length; i++) {
				if (pp[i] > max) {
					max = pp[i];
					max_index = i;
				}
			}

			int soLuong = khoiLuongConLai / a[max_index];
			if (soLuong != 0) {
				khoiLuongConLai = khoiLuongConLai - soLuong * a[max_index];
				pp[max_index] = 0;
				giaTri = soLuong * p[max_index];
				System.out.println("lay duoc " + soLuong + " do vat thu " + max_index);
			}

		}
		System.out.println("Tong gia tri lay duoc la: " + giaTri);

	}

	public static void inputData() {
		String myfile = "/Users/mac/Documents/u_ứng dụng thuật toán/Balo/src/com/hdcompany/balo/duc/mydata.txt";
		try (BufferedReader rd = new BufferedReader(new FileReader(myfile))) {
			String line;
			int rows = 0;
			while ((line = rd.readLine()) != null) {
				String[] values = line.split(" ");
				if (rows == 0) {
					b = Integer.parseInt(values[0]);
				} else if (rows == 1) {
					a = new int[values.length];
					for (int i = 0; i < values.length; i++) {
						a[i] = Integer.parseInt(values[i]);
					}
				} else {
					p = new int[values.length];
					for (int i = 0; i < values.length; i++) {
						p[i] = Integer.parseInt(values[i]);
					}
				}
				rows++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}