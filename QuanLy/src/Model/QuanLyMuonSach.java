package Model;

import Model.BanDoc;

import java.util.Arrays;
import java.util.Scanner;


public class QuanLyMuonSach  {
    private BanDoc banDoc;

    private Sach[] listSach=new Sach[5];
    private int tong=0;
    private int lenSach=0;

    private int[] quantities=new int[5];

    private int lenSoLuong=0;

    public QuanLyMuonSach(BanDoc banDoc, Sach[] listSach, int lenSach, int[] quantities, int lenSoLuong) {
        this.banDoc = banDoc;
        this.listSach = listSach;
        this.lenSach = lenSach;
        this.quantities = quantities;
        this.lenSoLuong = lenSoLuong;
    }
    public QuanLyMuonSach(){

    }
    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public Sach[] getListSach() {
        return listSach;
    }

    public void setListSach(Sach[] listSach) {
        this.listSach = listSach;
    }

    public int getLenSach() {
        return lenSach;
    }

    public void setLenSach(int lenSach) {
        this.lenSach = lenSach;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public void setQuantities(int[] quantities) {
        this.quantities = quantities;
    }

    public int getLenSoLuong() {
        return lenSoLuong;
    }

    public void setLenSoLuong(int lenSoLuong) {
        this.lenSoLuong = lenSoLuong;
    }

    public void muonSach(BanDoc[] banDocList, Sach[] sachList){
        String tenSach;
        int maBanDoc;
        int soLuong;
        int quantity;
        boolean exist=false;
        Scanner sc = new Scanner(System.in);

    while (!exist) {
        System.out.println("Nhap ma bạn doc(10000-99999) :");
        maBanDoc = sc.nextInt();

        for (int i = 0; i < 1000; i++) {
            if (banDocList[i] != null && banDocList[i].getMaBanDoc() == maBanDoc) {
                exist = true;
                this.banDoc = banDocList[i];
                break;
            }
        }
    }


    do {
        System.out.println("Bạn muốn mượn bao nhieu đầu sách khác nhau (1 đến 5)");
        soLuong = sc.nextInt();
    }
    while (soLuong < 1 || soLuong > 6);

    for (int i = 0; i < soLuong; i++) {

            exist = false;

            while (!exist) {

                System.out.println("Nhập tên đầu sách thứ " + (i + 1));
                tenSach = sc.nextLine();
                exist = false;
                for (int j = 0; j < 1000; j++) {
                    if (sachList[j] != null && sachList[j].getTenSach().equals(tenSach)) {
                        exist = true;

                        boolean existInSachList = false;//để check tên sách đã đc nhập trc đó,ko cho trùng tên sách
                        for (int k = 0; k < lenSach; k++) {
                            if (listSach[k].getTenSach().equals(tenSach)) {
                                exist = false;
                                System.out.println("Sách đã được mượn trước đó!");
                                break;
                            }
                        }

                        listSach[lenSach++] = sachList[j];

                    }
                }
            }

            //

            do {

                System.out.println("Moi ban nhap so lương sach :");
                quantity = sc.nextInt();

            } while (0 < quantity && quantity > 3);


            quantities[lenSoLuong++] = soLuong;
            tong =tong + quantity;
        }
        System.out.println("tong sach muon " + tong);
    }
    public static void sortGiamDan(QuanLyMuonSach[] list,int len){

        for(int i=0;i<len;i++){
            for(int j=i+i;j<len;j++){
                if(list[i].tong>list[j].tong){
                    QuanLyMuonSach temp=list[i];

                    list[i]=list[j];

                    list[j]=temp;
                }
            }
        }
    }


    public static void sortByName(BanDoc[] list ,int leng){
        if (list == null || list.length == 0) {
            System.out.println("Bạn cần nhập danh sách ban doc trước khi sắp xếp!");
            return;
        }

        for(int i=0 ; i<leng;i++){
            for (int j=i+1 ; j<leng;j++){
             int compareName=list[i].getHoTen().compareTo(list[j].getHoTen());

             if(compareName < 0 ){
                 BanDoc temp=list[i];

                 list[i]=list[j];

                 list[j]=temp;
             }
            }
        }
    }

    public static void findName(BanDoc[] listBanDoc,int len){
        String tenBanDoc;
        String result="";

        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap ten ban doc can tim :");
        tenBanDoc= sc.nextLine();
        for (int j = 0; j < len; j++) {
            if (listBanDoc[j] != null && listBanDoc[j].getHoTen().equals(tenBanDoc)) {
                result += listBanDoc[j].toString()+"\n";
            }
        }

        System.out.println(result);
    }

    @Override
    public String toString() {
        return "QuanLyMuonSach{" +
                "banDoc=" + banDoc +
                ", listSach=" + Arrays.toString(listSach) +
                ", lenSach=" + lenSach +
                ", quantities=" + Arrays.toString(quantities) +
                ", lenSoLuong=" + lenSoLuong +
                '}';
    }
}

