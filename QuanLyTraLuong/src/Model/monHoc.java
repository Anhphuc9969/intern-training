
package Model;
import java.util.Scanner;
public class monHoc {




    private int maMonHoc,tongSoTiet,soTietLyThuyet;
    private double mucKinhPhi;
    private String tenMon;

    private static int AUTO_ID = 100;


    public monHoc() {
        this.maMonHoc = this.AUTO_ID;
        this.AUTO_ID++;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }



    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public double getMucKinhPhi() {
        return mucKinhPhi;
    }

    public void setMucKinhPhi(double mucKinhPhi) {
        this.mucKinhPhi = mucKinhPhi;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void nhapMonHoc(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban nhap thong tin mon hoc:");

        System.out.println("Ma mon hoc  :"+this.getMaMonHoc());

        System.out.print("Nhap ten mon:");
        tenMon=sc.nextLine();


        System.out.print("Nhap tong so tiet:");
        tongSoTiet=sc.nextInt();


        System.out.print("Nhap so tiet ly thuyet:");
        soTietLyThuyet=sc.nextInt();

        System.out.println("Nhap muc kinh phi");
        mucKinhPhi=sc.nextDouble();



    }

    @Override
    public String toString() {
        return "monHoc{" +
                "maMonHoc=" + maMonHoc +
                ", tongSoTiet=" + tongSoTiet +
                ", soTietLyThuyet=" + soTietLyThuyet +
                ", mucKinhPhi=" + mucKinhPhi +
                ", tenMon='" + tenMon + '\'' +
                '}';
    }
}
