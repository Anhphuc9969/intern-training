import java.util.Scanner;
import Model.monHoc;
import Model.giangVien;
import Model.keKhaiGiangDay;
public class main {
    public static monHoc[] monHocStorage=new monHoc[1000];
    public static int lenMonHocStorage=0;

    private static keKhaiGiangDay[] keKhaiStogare=new keKhaiGiangDay[1000];
    public static int lenKeKhaiStogare=0;

    public static giangVien[] giangVienStorage=new giangVien[1000];
    public static int lengiangVienStorage=0;

    public static void showMonHoc(){
        String result="";


        for(int i=0;i<lenMonHocStorage;i++){
            result+=monHocStorage[i].toString()+"\n";
        }

        System.out.println(result);
    }


    public static void showKeKhai(){
        String result="";


        for(int i=0;i<lenKeKhaiStogare;i++){
            result+=keKhaiStogare[i].toString()+"\n";
        }

        System.out.println(result);
    }
    public static void showGiangVien(){
        String result="";


        for(int i=0;i<lengiangVienStorage;i++){
            result+=giangVienStorage[i].toString()+"\n";
        }

        System.out.println( result);
    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("--------Quản lý trả lương--------");
            System.out.println("1.Nhập danh sách môn học. In ra danh sách môn học đã có  \n ");
            System.out.println("2.Nhập danh sách giảng viên.  In ra danh sách GV đã có  ");
            System.out.println("3.Quản lý mượn sách cho từng bạn đọc");
            System.out.println("4.Sắp xếp danh sách quản lý mượn sách");
            System.out.println("5.Tìm kiếm và hiển thị danh sách theo tên bạn đọc");
            System.out.println("6.Thoát");
            System.out.println("Moi ban chọn chương trình");
            input = sc.nextInt();

            switch (input){
                case 1 :
                   monHoc s=new monHoc();
                   s.nhapMonHoc();
                    monHocStorage[lenMonHocStorage++]=s;
                    showMonHoc();
                    break;


                case 2 :
                    giangVien gv =new giangVien();
                    gv.nhapGiangVien();
                    giangVienStorage[lengiangVienStorage++]=gv;
                    showGiangVien();
                    break;

                case 3:
                    keKhaiGiangDay KeKhai=new keKhaiGiangDay();

                    KeKhai.nhapThongKe(giangVienStorage,monHocStorage);
                    keKhaiStogare[lenKeKhaiStogare++]=KeKhai;
                    System.out.println(lenKeKhaiStogare);
                    showKeKhai();

                    break;
                case 4:

                    break;
            }
        }while (input>0 && input<7);

    }

    public static void main(String[] args) {
     menu();
    }
}
