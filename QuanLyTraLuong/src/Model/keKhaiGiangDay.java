
package Model;
import java.util.Scanner;
public class keKhaiGiangDay {
    private giangVien giangVien;
    private monHoc monHoc;
    private giangVien[] listGiangVien=new giangVien[1000];
    private monHoc[] listMonHoc=new  monHoc[1000];
    private int[] listClass=new int[1000];
    private int lenSoLuong=0;
    private int[] listMon=new int[1000];

public void nhapThongKe(giangVien[] listGiangVien, monHoc[] listMonHoc  ){
    int maGiangVien;
    int soLuong;
    String
    boolean exist=false;
    Scanner sc = new Scanner(System.in);
    while (!exist) {
        System.out.println("Nhap ma Giang vien(100-999) :");
        maGiangVien = sc.nextInt();

        for (int i = 0; i < 1000; i++) {
            if (listGiangVien[i] != null && listGiangVien[i].getMaGV() == maGiangVien) {
                exist = true;
                this.giangVien = listGiangVien[i];
                break;
            }
        }
    }

    System.out.println("Mon giang vien day" );

    do {
        System.out.println("Giảng viên dậy bao nhiêu lớp (1 đến 3)");
        soLuong = sc.nextInt();
    }
    while (soLuong < 1 || soLuong > 4);
}
}
