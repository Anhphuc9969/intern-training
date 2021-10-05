package Model;
import java.util.Scanner;


public class BanDoc  {
    private static final String SV="Sinh Vien";

    private static final String HV="Hoc Vien";

    private static final String GV="Giao Vien";

    private int maBanDoc ;
    private String hoTen , diaChi , loai,sDT;
    private static int AUTO_ID = 10000;
    public BanDoc(){
        this.maBanDoc=this.AUTO_ID;
        this.AUTO_ID++;
    }


    public int getMaBanDoc() {
        return maBanDoc;
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }


    public void nhapBanDoc(){
        Scanner in=new Scanner(System.in);

        System.out.println("Moi ban nhap thong tin ban doc:");

        System.out.println("Ma Sach:"+this.getMaBanDoc());

        System.out.println("Nhap ho ten cua ban doc:");
        hoTen=in.nextLine();


        System.out.println("Nhap dia chi cua ban doc:");
        diaChi=in.nextLine();


        System.out.println("Nhap so dien thoai cua ban doc:");
        sDT=in.nextLine();



        System.out.println("1 Sinh Vien");
        System.out.println("2 Hoc Vien");
        System.out.println("3 Giao Vien");
        int setup;
        do{
            setup=in.nextInt();
            System.out.println("Moi ban chon loai:");
            switch(setup){
                case 1:this.setLoai(SV);
                    break;
                case 2:this.setLoai(HV);
                    break;
                case 3:this.setLoai(GV);

                    break;

            }
        }
        while (setup!=1&&setup!=2&&setup!=3);
    }

    @Override
    public String toString() {
        return "BanDoc{" +
                "maBanDoc=" + maBanDoc +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", loai='" + loai + '\'' +
                ", sDT='" + sDT + '\'' +
                '}';
    }
}
