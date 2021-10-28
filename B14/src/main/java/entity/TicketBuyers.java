package entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import java.util.List;
import java.util.Scanner;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TICKET_BUYERS")


public class TicketBuyers implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket5_seq")
    @SequenceGenerator(name = "ticket5_seq", sequenceName = "ticket5_seq", allocationSize = 1, initialValue = 1)
    private int ID;

    @Column(name = "NAME")
    private String NAME;

    @Column(name = "ADDRESS")
    private String ADDRESS;

    @Column(name = "PHONE_NUMBER")
    private int PHONE_NUMBER;

    @Column(name = "TYPE_OF_BUYER")
    private String TYPE_OF_BUYER;

    @OneToMany(mappedBy = "ticketBuyers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> listOrder = new ArrayList<>();

    @Transient
    Scanner sc = new Scanner(System.in);
    private final static String MuaLe = "mua le";
    private final static String MuaTapThe= "mua tap the";
    private final static String MuaQuaMang= "mua qua mang";

    public void InputTicketBuyers(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Mời bạn nhập thông tin người mua vé :");


        System.out.print("Nhap ho ten:");
        this.NAME=sc.nextLine();

        System.out.print("Nhap dia chi:");
        this.ADDRESS=sc.nextLine();

        System.out.print("Nhap so dien thoai:");
        this.PHONE_NUMBER=sc.nextInt();

        System.out.println("Nhập loại người mua :");
        System.out.println("1 Mua lẻ");
        System.out.println("2 Mua tập thể");
        System.out.println("3 Mua qua mạng");


        int setup;

        do
        {
            System.out.println("Hay chon chuyen nganh:");
            setup=sc.nextInt();
            switch(setup)
            {
                case 1:
                    this.setTYPE_OF_BUYER(MuaLe);
                    break;
                case 2:
                    this.setTYPE_OF_BUYER(MuaTapThe);
                    break;
                case 3:
                    this.setTYPE_OF_BUYER(MuaQuaMang);
                    break;

            }
        }
        while (setup!=1&&setup!=2&&setup!=3);
    }

    @Override
    public String toString() {
        return "TicketBuyers{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", PHONE_NUMBER=" + PHONE_NUMBER +
                ", TYPE_OF_BUYER='" + TYPE_OF_BUYER + '\'' +
//                ", listOrder=" + listOrder +

                '}';
    }
}
