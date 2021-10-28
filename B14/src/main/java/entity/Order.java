package entity;

import javax.persistence.*;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.OrderTable;
import service.TicketTable;

import java.util.*;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER_TRAIN_TICKETS")
public class Order {

    @Transient
    private TicketBuyers ticketBuyerss;
    private static List<OrderTable> orderTableList = new ArrayList<>();
    private static List<OrderTable> orderTables = new ArrayList<>();
    @Transient
    private Map<TrainTickets, Integer> trainTicketsIntegerMap = new HashMap<>();


    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order6_seq")
    @SequenceGenerator(name = "order6_seq", sequenceName = "order6_seq", allocationSize = 1, initialValue = 1)
    private int ID;

//    @Column(name = "TICKET_BUYERS_ID")
//    private int TICKET_BUYERS_ID;
//
//    @Column(name = "TRAIN_TICKETS_ID")
//    private int TRAIN_TICKETS_ID;

    @ManyToOne
    @JoinColumn(name = "TICKET_BUYERS_ID", nullable = false)
    private TicketBuyers ticketBuyers;

    @ManyToOne
    @JoinColumn(name = "TRAIN_TICKETS_ID", nullable = false)
    private TrainTickets trainTickets;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;


    public void InputOrder(List<TicketBuyers> ticketBuyersList, List<TrainTickets> trainTicketsList) {
        int idTicketBuyers;
        int idTrainTickets;
        int ticketTotle =0;
        float price = 0;
        int quantitys;
        boolean exist = false;
        Scanner sc = new Scanner(System.in);
        while (!exist) {
            System.out.println("Nhập mã người mua vé(10000-99999) :");
            idTicketBuyers = sc.nextInt();

            for (int i = 0; i < 1000; i++) {
                if (ticketBuyersList.get(i) != null && ticketBuyersList.get(i).getID() == idTicketBuyers) {
                    exist = true;
                    this.ticketBuyerss = ticketBuyersList.get(i);
                    break;
                }
            }
            System.out.println("list" + ticketBuyersList);
        }

        do {
            System.out.println("Nhập số lượng loại vé tàu :");
            quantitys = sc.nextInt();
        }
        while (quantitys < 0 || quantitys > 20);

        for (int i = 0; i < quantitys; i++) {


            //
            exist = true;

            while (exist) {


                System.out.println("Nhập mã vé thứ : " + (i + 1));
                idTrainTickets = sc.nextInt();

                //check exist in busRouteList
                for (TrainTickets b : trainTicketsList) {
                    if (b.getID() == idTrainTickets) {


                        exist = false;
                        //để check mã ve đã đc nhập trc đó,ko cho trùng mã ve
                        for (Map.Entry<TrainTickets, Integer> entry : trainTicketsIntegerMap.entrySet()) {
                            if (entry.getKey().getID() == idTrainTickets) {
                                System.out.println("Mã vé tàu đã được nhập trước đó!");
                                exist = true;
                                break;
                            }
                        }
                        //end

                        boolean sucxist = false;
                        if (!sucxist) {

                            //Nhập số lượng vé
                            do {
                                System.out.println("Nhập số lượng vé:");
                                quantity = sc.nextInt();
                            } while (quantitys + quantity > 20);

                            trainTicketsIntegerMap.put(b, quantity);


                        }


                    }

                }


            }

        }

    }

    public static void sortByTotalRoute(List<Order> list) {
        Collections.sort(list, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.trainTicketsIntegerMap.size()<o1.trainTicketsIntegerMap.size()?1:-1;
            }
        });
    };



    public static void sortByName(List<TicketBuyers> list){
        Collections.sort(list, new Comparator<TicketBuyers>() {
            @Override
            public int compare(TicketBuyers o1, TicketBuyers o2) {
                return o1.getNAME().compareTo(o2.getNAME());
            }
        });
    }

    @Override
    public String toString() {
        return "Order{" +
                "ticketBuyerss=" + ticketBuyerss +
                ", trainTicketsIntegerMap=" + trainTicketsIntegerMap +
                ", ID=" + ID +
                ", quantity=" + quantity +
                ", ticketBuyers=" + ticketBuyers +
                ", trainTickets=" + trainTickets +
                '}';
    }
}
