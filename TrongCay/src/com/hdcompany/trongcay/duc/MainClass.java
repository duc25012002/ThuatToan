package com.hdcompany.trongcay.duc;

public class MainClass {
    public static int findDay(int[] d, int n) {
        int[] planted = new int[n]; // lưu lại ngày trồng của các hạt giống
        int day = 0; // ngày hiện tại
        while (true) {
            int index = -1; // chỉ số của hạt giống tiếp theo cần trồng
            int earliest = Integer.MAX_VALUE; // ngày sớm nhất mà hạt giống tiếp theo có thể được trồng
            // Tìm hạt giống tiếp theo cần trồng
            for (int i = 0; i < n; i++) {
                if (planted[i] == 0 && day >= d[i] && day + d[i] < earliest) {
                    index = i;
                    earliest = day + d[i];
                }
            }
            // Nếu không còn hạt giống nào cần trồng thì trả về kết quả
            if (index == -1) {
                return day;
            }
            // Trồng hạt giống tiếp theo vào ngày sớm nhất
            planted[index] = earliest;
            day++;
        }
    }

    public static void main(String[] args) {
        int[] d = {3, 4, 5, 6};
        int n = d.length;
        int result = findDay(d, n);
        System.out.println("Số ngày sớm nhất để tổ chức bữa tiệc ngoài vườn là " + result);
    }
}
