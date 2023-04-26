package com.hdcompany.xauconmax.duc;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;

public class App {
    public static void main(String[] args) throws Exception {
        String myfile = "/Users/mac/Documents/u_ứng dụng thuật toán/XauConChungMax/src/com/hdcompany/xauconmax/duc/array1.txt";
        String[] x = inputData(myfile);
        myfile = "/Users/mac/Documents/u_ứng dụng thuật toán/XauConChungMax/src/com/hdcompany/xauconmax/duc/array2.txt";
        String[] y = inputData(myfile);

        int n = x.length;
        int m = y.length;
        
        int[][] F = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    F[i][j] = 0;
                } else {
                    if (x[i - 1].equals(y[j - 1])) {
                        F[i][j] = F[i - 1][j - 1] + 1;
                    } else {
                        F[i][j] = Math.max(F[i - 1][j], F[i][j - 1]);
                    }
                }
            }
        }
        System.out.println(F[n][m]);
        ArrayList<String> xauChung = new ArrayList<String>();
        int t = 0;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(F[i][j] > t) {
                    xauChung.add(x[i-1]);
                    t++;
                }
            }
        }
        System.out.println("Xau chung: "+xauChung );
    }

    public static String[] inputData(String myfile) {

        try (BufferedReader reader = new BufferedReader(new FileReader(myfile))) {
            String line;
            line = reader.readLine();
            String[] array = line.split("");
            return array;
        }

        catch (Exception e) {
            return new String[1];
        }
    }
}