package Model;

import java.util.Scanner;

public class giangVien {

    private static final String GSTS="GS-TS";
    private static final String PGSTS="PGS-TS";
    private static final String GV="Giảng viên chính";
    private static final String TS="Thạc sĩ";



    private int maGV;
    private String hoTen, diaChi,soDienThoai,trinhDo;

    private static int AUTO_ID = 100;




    public giangVien() {
        this.maGV = this.AUTO_ID;
        this.AUTO_ID++;
    }


    public int getMaGV() {
        return maGV;
    }



    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void nhapGiangVien(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban nhap thong tin Giảng Viên:");

        System.out.println("Ma GV :"+this.getMaGV());

        System.out.print("Nhap ho ten:");
        hoTen=sc.nextLine();


        System.out.print("Nhap dia chi:");
        diaChi=sc.nextLine();


        System.out.print("Nhap so dien thoai:");
        soDienThoai=sc.nextLine();

        System.out.println("Nhap trinh do:");
        System.out.println("1 GSTS");
        System.out.println("2 PGSTS");
        System.out.println("3 Giang vien chinh");
        System.out.println("4 TS");
        int setup;
        do{
            System.out.println("Hay chon chuyen nganh:");
            setup=sc.nextInt();
            switch(setup){
                case 1:this.setTrinhDo(GSTS);
                    break;
                case 2:this.setTrinhDo(PGSTS);
                    break;
                case 3: this.setTrinhDo(GV);
                    break;
                case 4:this.setTrinhDo(TS);
                    break;
            }
        }
        while (setup!=1&&setup!=2&&setup!=3&&setup!=4);
    }

    @Override
    public String toString() {
        return "giangVien{" +
                "maGV=" + maGV +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", trinhDo='" + trinhDo + '\'' +
                '}';
    }
}
