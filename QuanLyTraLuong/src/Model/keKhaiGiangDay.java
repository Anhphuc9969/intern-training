
package Model;
import java.util.Arrays;
import java.util.Scanner;
public class keKhaiGiangDay {
    private giangVien GiangVien;

    private monHoc MonHoc;

    int soTiet;

    public keKhaiGiangDay() {
    }




    public void nhapThongKe(giangVien[] listGiangVien , monHoc[] listMonHoc ,keKhaiGiangDay[] listKeKhaiGiangDay ) {

        int maGiangVien;
        int maMonHoc;
        int soLuong;
        int soTietHienTai=0;
        String tenMon;
        int quantity;
        int soLopMax;
        boolean exist=false;
        boolean prevExist=false;


        Scanner sc = new Scanner(System.in);


        while (!exist) {
            System.out.println("Nhap ma Giang vien(100-999) :");
            maGiangVien = sc.nextInt();

            for (int i = 0; i < 1000; i++) {
                if (listGiangVien[i] != null && listGiangVien[i].getMaGV() == maGiangVien) {
                    exist = true;
                    this.GiangVien = listGiangVien[i];
                    break;
                }

            }
        }


        for(keKhaiGiangDay item:listKeKhaiGiangDay){
            soTietHienTai += item.MonHoc.getTongSoTiet();
        }



        while (!exist || prevExist){
            System.out.println("Nhap ma mon hoc");
            maMonHoc = sc.nextInt();

            for (int i = 0; i < 1000; i++) {
                if (listMonHoc[i] != null && listMonHoc[i].getMaMonHoc() == maMonHoc) {

                    //tồn tại môn học trong danh sách môn học
                    exist = true;

                    //check môn học đã nhập trước đó hay chưa
                    for (int k = 0; k < 1000; k++) {
                        if (listKeKhaiGiangDay[k].getMonHoc().getMaMonHoc() == maMonHoc) {
                            prevExist=true;
                            System.out.println("mã sách đã được nhập trước đó!");
                            break;
                        }
                    }

                    //Môn học chưa đươc nhập trước đó
                    if(prevExist==false){
                        this.MonHoc=listMonHoc[i];
                    }
                    break;
                }else{
                    System.out.println("Mã môn học không tồn tại");
                }
            }
        }


        soLopMax=(200-soTietHienTai)/this.getMonHoc().getTongSoTiet();





        do
        {
            System.out.println(" số tiết(1 đến 3)");
            soLuong = sc.nextInt();
            System.out.println("Số lớp giảng viên dậy môn học là :" + soLuong);
        }
        while (soLuong < 1 || soLuong > 3);



        System.out.println("tong so tiet day" + tong);
}






    public giangVien getGiangVien() {
        return GiangVien;
    }

    public void setGiangVien(giangVien giangVien) {
        GiangVien = giangVien;
    }

    public monHoc getMonHoc() {
        return MonHoc;
    }

    public void setMonHoc(monHoc monHoc) {
        MonHoc = monHoc;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

}




