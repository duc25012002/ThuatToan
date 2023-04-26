package com.hdcompany.bonho.duc;

import java.util.*;

import java.util.Arrays;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        int[] kichThuocChuongTrinh = {1, 3, 6, 8, 10}; // Kích thước của các chương trình
        int dungLuongBangNho = 10; // Dung lượng của mỗi băng nhớ
        
        // Sắp xếp các chương trình theo thứ tự giảm dần của kích thước
        Arrays.sort(kichThuocChuongTrinh);
        int soLuongChuongTrinh = kichThuocChuongTrinh.length;
        
        int dungLuongBangNho1 = 0, dungLuongBangNho2 = 0;
        int[] chuongTrinhTrenBangNho = new int[soLuongChuongTrinh];
        
        // Duyệt từng chương trình theo thứ tự đã sắp xếp, đưa chương trình vào băng nhớ nào có dung lượng còn trống lớn hơn.
        for (int i = soLuongChuongTrinh-1; i >= 0; i--) {
            if (dungLuongBangNho1 + kichThuocChuongTrinh[i] <= dungLuongBangNho - dungLuongBangNho2) {
                dungLuongBangNho1 += kichThuocChuongTrinh[i];
                chuongTrinhTrenBangNho[i] = 1;
            } else if (dungLuongBangNho2 + kichThuocChuongTrinh[i] <= dungLuongBangNho - dungLuongBangNho1) {
                dungLuongBangNho2 += kichThuocChuongTrinh[i];
                chuongTrinhTrenBangNho[i] = 2;
            } else {
                System.out.println("Không đủ dung lượng để lưu trữ chương trình " + (i+1));
            }
        }
        
        // In kết quả
        for (int i = 0; i < soLuongChuongTrinh; i++) {
            System.out.println("Chương trình " + (i+1) + " được lưu trữ trên băng nhớ " + chuongTrinhTrenBangNho[i]);
        }
    }
}
