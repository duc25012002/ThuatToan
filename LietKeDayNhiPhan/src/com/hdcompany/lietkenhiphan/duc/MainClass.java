package com.hdcompany.lietkenhiphan.duc;

public class MainClass {
	public static void main(String[] args) {
		int n = 4;
		generateBinarySequences(n, "");
	}

	public static void generateBinarySequences(int n, String seq) {
		if (seq.length() == n) {
			System.out.println(seq);
			return;
		}

		generateBinarySequences(n, seq + "0");
		generateBinarySequences(n, seq + "1");
	}
}
