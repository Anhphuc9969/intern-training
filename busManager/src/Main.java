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
            System.out.println("1.Nhập danh sách Lái xe. In ra danh sách lái xe đã có   ");
            System.out.println("2.Nhập danh sách Tuyến.  In ra danh sách các tuyến đã có  ");
            System.out.println("3.Lập Bảng kê khai giảng dạy cho mỗi giảng viên và in danh sách ra màn hình");
            System.out.println("4.Sắp xếp danh sách phân công Theo Họ tên lái xe   ");
            System.out.println("5.Sắp xếp danh sách phân công Theo Số lượng tuyến đảm nhận trong ngày (giảm dần)");
            System.out.println("6.Lập bảng kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
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
