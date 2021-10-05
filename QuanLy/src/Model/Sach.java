package Model;

import java.util.Scanner;

public class Sach {



    private static final String KHTN="Khoa học tự nhiên";
    private static final String VHNT="Văn hoa nghệ thuật";
    private static final String DTVT="Điện tử viễn thông";
    private static final String CNTT="Công  nghệ thông tin";




    private int maSach;
    private String tenSach, tacGia,chuyenNganh;
    private int namXB;
    private static int AUTO_ID = 10000;


    public Sach() {
        this.maSach=this.AUTO_ID;
        this.AUTO_ID++;
    }




    public int getMaSach() {
        return maSach;
    }


    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }



    public void nhapSach(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban nhap thong tin sach:");

        System.out.println("Ma Sach :"+this.getMaSach());

        System.out.print("Nhap ten sach:");
        tenSach=sc.nextLine();


        System.out.print("Nhap ten tac gia:");
        tacGia=sc.nextLine();


        System.out.print("Nhap nam xuat ban sach:");
        namXB=sc.nextInt();

        System.out.println("Nhap chuyen nganh:");
        System.out.println("1 Khoa Hoc Tu Nhien");
        System.out.println("2 Van Hoa Nghe Thuat");
        System.out.println("3 Dien Tu Vien Thong");
        System.out.println("4 Cong Nghe Thong Tin");
        int setup;
        do{
            System.out.println("Hay chon chuyen nganh:");
            setup=sc.nextInt();
            switch(setup){
                case 1:this.setChuyenNganh(KHTN);
                    break;
                case 2:this.setChuyenNganh(VHNT);
                    break;
                case 3: this.setChuyenNganh(DTVT);
                    break;
                case 4:this.setChuyenNganh(CNTT);
                    break;
            }
        }
        while (setup!=1&&setup!=2&&setup!=3&&setup!=4);
    }

    @Override
    public String toString() {
        return "Sach{" +
                ", maSach=" + maSach +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                ", namXB=" + namXB +
                '}';
    }


}
