

import Model.BanDoc;
import Model.QuanLyMuonSach;
import Model.Sach;
import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.util.Scanner;

public class Main {
    public static Sach[] sachStorage=new Sach[1000];

    public static int lenSachStorage=0;
    private static QuanLyMuonSach[] listmuonsach=new QuanLyMuonSach[1000];
    public static int lenMuonSach=0;
    public static BanDoc[] banDocStorage=new BanDoc[1000];

    public static int lenBanDocStorage=0;

    public static void showSach(){
        String result="";


        for(int i=0;i<lenSachStorage;i++){
            result+=sachStorage[i].toString()+"\n";
        }

        System.out.println(result);
    }

    public static void showBanDoc(){
        String result="";


        for(int i=0;i<lenBanDocStorage;i++){
            result+=banDocStorage[i].toString()+"\n";
        }

        System.out.println(result);
    }
    public static void showMuonSach(){
        String result="";


        for(int i=0;i<lenMuonSach;i++){
            result+=listmuonsach[i].toString()+"\n";
        }

        System.out.println(result);
    }
    public static void muonSach(){
        showBanDoc();

    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("--------Quản lý mượn sách thư viện--------");
            System.out.println("1.Nhập danh sách đầu sách mới");
            System.out.println("2.Nhập danh sách bạn đọc");
            System.out.println("3.Quản lý mượn sách cho từng bạn đọc");
            System.out.println("4.Sắp xếp danh sách quản lý mượn sách");
            System.out.println("5.Tìm kiếm và hiển thị danh sách theo tên bạn đọc");
            System.out.println("6.Thoát");
            System.out.println("Moi ban chọn chương trình");
            input = sc.nextInt();

            switch (input){
                case 1 :
                            Sach s =new Sach();
                            s.nhapSach();
                            sachStorage[lenSachStorage++]=s;
                            showSach();
                    break;


                case 2 :
                    BanDoc bd =new BanDoc();
                    bd.nhapBanDoc();
                    banDocStorage[lenBanDocStorage++]=bd;
                    showBanDoc();
                    break;

                case 3:
                    QuanLyMuonSach ql =new QuanLyMuonSach();
                    ql.muonSach(banDocStorage,sachStorage);
                    listmuonsach[lenMuonSach++]=ql;
                    showMuonSach();
                    break;

            }
        }while (input>0 && input<7);

    }

    public static void main(String[] args) {
        menu();
    }
}
