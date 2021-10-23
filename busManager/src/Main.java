import Model.AssignmentSheet;
import Model.BusRoute;
import Model.Drives;

import java.util.*;
public class Main {

    private static List<Drives> drivesList=new ArrayList<>();
    public static int lenDriverStorage=0;
    private static List<BusRoute> busRouteList  =new ArrayList<BusRoute>();
    private static List<AssignmentSheet> assignmentSheetList=new ArrayList<>();
    private static int len=0;

    public static void showDrives()
    {
        for (Drives d:drivesList){
            System.out.println(d);
        }
    }

    public static void showBusRoute(){
        for (BusRoute b:busRouteList){
            System.out.println(b);
        }
    }

    public static void   showAssignmentSheet(){
        for (AssignmentSheet As:assignmentSheetList){
            System.out.println(As);
        }
    }

    public static void menu() {

        //fake data
        drivesList.add(new Drives("Phúc","Thanh Hóa","0912212121","A"));
        drivesList.add(new Drives("Hiền","Hà Nội","012222222","B"));

        busRouteList.add(new BusRoute(10,5));
        busRouteList.add(new BusRoute(20,10));



        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("--------Quản lý trả lương--------");
            System.out.println("1.Nhập danh sách môn học. In ra danh sách môn học đã có  ");
            System.out.println("2.Nhập danh sách giảng viên.  In ra danh sách GV đã có  ");
            System.out.println("3.Lập Bảng kê khai giảng dạy cho mỗi giảng viên và in danh sách ra màn hình");
            System.out.println("4.Sắp xếp danh sách kê khai giảng dạy theo họ tên giảng viên     ");
            System.out.println("5.Sắp xếp danh sách kê khai giảng dạy theo số tiết giảng dạy mỗi môn (giảm dần)");
            System.out.println("6.Tính toán và lập bảng tính tiền công cho mỗi giảng viên");
            System.out.println("7.Thoát");
            System.out.println("Moi ban chọn chương trình");

            input = sc.nextInt();

            switch (input) {
                case 1:
                     Drives A = new Drives();
                     A.inputDrives();
                     drivesList.add(A);
                     showDrives();
                    break;


                case 2:
                    BusRoute B=new BusRoute();
                    B.inputBusRoute();
                    busRouteList.add(B);
                    showBusRoute();
                    break;

                case 3:
                    AssignmentSheet AS=new AssignmentSheet();
                    AS.inputAssignmentSheer(drivesList,busRouteList);
                    assignmentSheetList.add(AS);
                    showAssignmentSheet();
                    break;
                case 4:
                    AssignmentSheet ASS=new AssignmentSheet();
                    ASS.sortByName(drivesList);
                    showDrives();

                    break;
                case 5:
                    AssignmentSheet ASSS=new AssignmentSheet();
                    ASSS.sortByTotalRoute(assignmentSheetList);
                    showBusRoute();

                    break;
                case 6:

            }
        } while (input > 0 && input < 7);
    }

    public static void main(String[] args) {
        menu();
    }
}
