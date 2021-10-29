package org.example;

import entity.Order;
import entity.TicketBuyers;
import entity.TrainTickets;
import repository.OrderRepository;
import repository.TicketBuyersImpl;
import repository.TrainTicketsImpl;
import repository.TrainTicketsRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App {
    private static TicketBuyersImpl TBIplm = new TicketBuyersImpl();
    private static TrainTicketsRepository TTIplm = new TrainTicketsImpl();
    private static List<TicketBuyers> ticketBuyersList=new ArrayList<>();
    public static int lenDriverStorage=0;
    private static List<TrainTickets> trainTicketsList  =new ArrayList<>();

    private static List<Order> orderList=new ArrayList<>();
    private static OrderRepository OR =new OrderRepository();

    private static int len=0;

    public static void showTicketBuyer()
    {
        for (TicketBuyers d:ticketBuyersList){
            System.out.println(d);
        }
    }

    public static void showTrainTickets(){
        for (TrainTickets t:trainTicketsList){
            System.out.println(t);
        }
    }

    public static void   showOrder(){
        for (Order O:orderList){
            System.out.println(O);
        }
    }


    public static void menu() {




        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("--------Quản lý bán vé--------");
            System.out.println("1.Nhập danh sách người mua vé. In ra danh sách người mua đã có     ");
            System.out.println("2.Nhập danh sách loại vé.  In ra danh sách các loại vé đã có   ");
            System.out.println("3.Nhập danh sách hóa đơn mua vé cho mỗi người mua và in danh sách ra màn hình");
            System.out.println("4.Sắp xếp danh sách hóa đơn   Theo Họ tên nguoi mua   ");
            System.out.println("5.Sắp xếp danh sách hóa đơn   Theo Số lượng vé mua (giảm dần)");
            System.out.println("6.Lập bảng kê số tiền phải tra cho mỗi người mua ");
            System.out.println("7.Thoát");
            System.out.println("Moi ban chọn chương trình");

            input = sc.nextInt();

            switch (input) {
                case 1:
                    TicketBuyers A = new TicketBuyers();
                    A.InputTicketBuyers();
                    ticketBuyersList.add(A);
                    TBIplm.addNew(ticketBuyersList);
                    showTicketBuyer();
                    break;

                case 2:
                    TrainTickets T = new TrainTickets();
                    T.InputTrainTickets();
                    trainTicketsList.add(T);
                    TTIplm.addNew(trainTicketsList);
                    showTrainTickets();
                    break;
                   

                case 3:
                    Order O=new Order();
                    O.InputOrder(ticketBuyersList,trainTicketsList);// nhap nguoi mua và nhap ve
                    orderList.add(O);
                    OR.addOrder(orderList);
                    OR.getAllOrder();

                    showOrder();
                    break;
                case 4:
                    Order ASS=new Order();
                    ASS.sortByName(ticketBuyersList);
                    showTicketBuyer();
                    break;
                case 5:

                    Order ASSS=new Order();
                    ASSS.sortByTotalRoute(orderList);
                    showTrainTickets();
                    break;
                case 6:

            }
        } while (input > 0 && input < 7);
    }

    public static void main(String[] args) {
       menu();

    }
}
