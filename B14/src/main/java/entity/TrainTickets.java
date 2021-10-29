package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TRAIN_TICKETS")
public class TrainTickets implements Serializable{
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer5_seq")
    @SequenceGenerator(name = "customer5_seq", sequenceName = "customer5_seq", allocationSize = 1, initialValue = 1)
    private int ID;

    @Column(name = "TYPE_OF_CHAIR")
    private String TYPE_OF_CHAIR;

    @Column(name = "UNIT_PRICE")
    private String UNIT_PRICE;

    @OneToMany(mappedBy = "trainTickets", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> listOrder = new ArrayList<>();

    @Transient
    Scanner sc = new Scanner(System.in);


    private final static String GheVip = "Ghế vip";
    private final static String GheThuong= "Ghế thường";

    public void InputTrainTickets(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Mời bạn nhập thông tin vé tàu :");


        System.out.print("Đơn giá :");
        this.UNIT_PRICE=sc.nextLine();



        System.out.println("Nhập loại ghế :");
        System.out.println("1 Ghế vip");
        System.out.println("2 Ghế thường");

        int setup;

        do
        {
            System.out.println("Hay chon loại ghế:");
            setup=sc.nextInt();
            switch(setup)
            {
                case 1:
                    this.setTYPE_OF_CHAIR(GheVip);
                    break;
                case 2:
                    this.setTYPE_OF_CHAIR(GheThuong);
                    break;

            }
        }
        while (setup!=1&&setup!=2);
    }

    @Override
    public String toString() {
        return "TrainTickets{" +
                "ID=" + ID +
                ", TYPE_OF_CHAIR='" + TYPE_OF_CHAIR + '\'' +
                ", UNIT_PRICE='" + UNIT_PRICE + '\'' +
                '}';
    }


}
