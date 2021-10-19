import Model.Customers;
import Model.Order;
import Model.Telephone;

import java.util.Scanner;
public class Main
{

    public static Telephone[] telephoneStorage=new Telephone[1000];
    public static int lenTelephoneStorage=0;

    public static Customers[] customersStorage=new Customers[1000];
    public static int lenCustomerStorage=0;

    public static Order[] orderStorage=new Order[1000];
    public static int lenOrderStorage=0;

    public static void fakeData()
    {
        customersStorage[lenCustomerStorage++]=new Customers("phuc","thanh hóa","0866465801","mua lẻ");
        customersStorage[lenCustomerStorage++]=new Customers("khoi","thanh hóa","0866465801","mua lẻ");
        customersStorage[lenCustomerStorage++]=new Customers("minh","thanh hóa","0866465801","mua lẻ");


        telephoneStorage[lenTelephoneStorage++]=new Telephone("nokia","vang",999);
        telephoneStorage[lenTelephoneStorage++]=new Telephone("iphone","vang",999);
        telephoneStorage[lenTelephoneStorage++]=new Telephone("samsung","vang",999);


    }

    public static void showTelephone(){
        String result="";

        for(int i=0;i<lenTelephoneStorage;i++)
        {
            result+=telephoneStorage[i].toString()+"\n";
        }

        System.out.println(result);
    }

    public static void showCustomers(){
        String result="";

        for(int i=0;i<lenCustomerStorage;i++)
        {
            result+=customersStorage[i].toString()+"\n";
        }

        System.out.println(result);
    }

    public static void  showOrder(){
        String result="";

        for (int i=0 ; i<lenOrderStorage;i++)
        {
            result+=customersStorage[i].toString()+"\n";
        }
        System.out.println(result);
    }

    public static void menu()
    {
        fakeData();
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("--------QUẢN LÝ BÁN ĐIỆN THOẠI DI ĐỘNG--------");
            System.out.println("1.Nhập danh sách Khách hàng   . In ra danh sách khách hàng đã có   ");
            System.out.println("2.Nhập danh sách sản phẩm Điện thoại di động mới.  In ra danh sách sản phẩm đã có  ");
            System.out.println("3.Nhập danh sách mua hàng cho mỗi khách hàng đã có và in danh sách ra màn hình ");
            System.out.println("4.Sắp xếp danh sách mua hàng theo Họ tên khách hàng     ");
            System.out.println("5.Sắp xếp danh sách mua hàng theo Số lượng điện thoại đặt mua (giảm dần)");
            System.out.println("6.Lập bảng kê tổng số tiền phải trả cho mỗi khách hàng");
            System.out.println("7.Thoát");
            System.out.println("Moi ban chọn chương trình");

            input = sc.nextInt();

            switch (input){
                case 1 :
                    Telephone s=new Telephone();
                    s.inputTelephone();
                    telephoneStorage[lenTelephoneStorage++]=s;
                    showTelephone();
                    break;


                case 2 :
                    Customers c =new Customers();
                    c.inputCustomers();
                    customersStorage[lenCustomerStorage++]=c;
                    showCustomers();
                    break;

                case 3:
                    Order O=new Order();

                    O.orderInput(customersStorage,telephoneStorage,orderStorage);
                    orderStorage[lenOrderStorage++]=O;
                    System.out.println(lenOrderStorage);
                    showOrder();

                    break;
                case 4:
                    Order Or = new Order();

                    Or.sortByName(orderStorage,lenOrderStorage);
                    showOrder();
                    break;

                case 5:

                    Order Orr = new Order();

                    Orr.sortGiamDan(orderStorage,lenOrderStorage);
                    showOrder();
                    break;
                case 6:
                    Order Orrr = new Order();
                    Orrr.moneyStatistics(customersStorage,telephoneStorage,orderStorage,lenOrderStorage);
                    break;
            }
        }while (input>0 && input<7);

    }

    public static void main(String[] args) {
        menu();
    }
}
