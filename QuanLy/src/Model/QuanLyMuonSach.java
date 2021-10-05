package Model;

import Model.BanDoc;

import java.util.Arrays;
import java.util.Scanner;


public class QuanLyMuonSach  {
    private BanDoc banDoc;

    private Sach[] listSach=new Sach[5];

    private int lenSach=0;

    private int[] quantities=new int[5];

    private int lenSoLuong=0;




    public void muonSach(BanDoc[] banDocList,Sach[] sachList){
        String tenSach;
        int maBanDoc;
        int soLuong;
        int quantity;
        boolean exist=false;
        Scanner sc = new Scanner(System.in);

        while(!exist){
            System.out.println("Nhap ma bạn doc(10000-99999) :");
            maBanDoc=sc.nextInt();

            for (int i=0;i<1000;i++){
               if(banDocList[i]!=null && banDocList[i].getMaBanDoc()==maBanDoc){
                   exist=true;
                   this.banDoc=banDocList[i];
                   break;
               }
            }
        }



        do {
            System.out.println("Bạn muốn mượn bao nhieu đầu sách khác nhau (1 đến 5)");
            soLuong=sc.nextInt();
        }
        while (soLuong < 1 || soLuong>6);

        for(int i=0 ; i < soLuong ; i++){
            exist=false;

            while (!exist){

                System.out.println("Nhập tên đầu sách thứ "+ (i+1));
                tenSach=sc.nextLine();
                exist=false;
                for (int j=0 ; j<1000 ;j++){
                    if(sachList[j] !=null && sachList[j] .getTenSach().equals(tenSach)){
                        exist=true;

                        boolean existInSachList=false;//để check tên sách đã đc nhập trc đó,ko cho trùng tên sách
                        for(int k=0;k<lenSach;k++){
                            if(listSach[k].getTenSach().equals(tenSach)){
                                exist=false;
                                System.out.println("Sách đã được mượn trước đó!");
                                break;
                            }
                        }

                        listSach[lenSach++]=sachList[j];

                    }
                }
            }

            //

            do{
                System.out.println("Moi ban nhap so lương sach :");
                quantity=sc.nextInt();
            }while (0<quantity && quantity>3);
            quantities[lenSoLuong++]=soLuong;
        }

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

