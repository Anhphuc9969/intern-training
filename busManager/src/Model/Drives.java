package Model;
import java.util.Scanner;
public class Drives {
    private static final String A="A";
    private static final String B="B";
    private static final String C="C";
    private static final String D="D";
    private static final String E="E";
    private static final String F="F";
    private int id;
    private String name,address,phoneNumber,level;
    private static int AUTO_ID = 10000;

    public Drives() {
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
    }

    public Drives( String name, String address, String phoneNumber, String level) {
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level = level;
    }


    public void inputDrives(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Mời bạn nhập thông tin lái xe:");
        System.out.println("Mã lái xe :"+this.getId());

        System.out.print("Nhập họ tên:");
        name=sc.nextLine();

        System.out.print("Nhập địa chỉ:");
        address=sc.nextLine();

        System.out.print("Nhập số điện thoại:");
        phoneNumber=sc.nextLine();

        System.out.println("Nhập trình độ:");
        System.out.println("1 A");
        System.out.println("2 B");
        System.out.println("3 C");
        System.out.println("4 D");
        System.out.println("5 E");
        System.out.println("6 F");


        int setup;

        do
        {
            System.out.println("Hãy chọn trình độ:");
            setup=sc.nextInt();
            switch(setup)
            {
                case 1:
                    this.setLevel(A);
                    break;
                case 2:
                    this.setLevel(B);
                    break;
                case 3:
                    this.setLevel(C);
                    break;
                case 4:
                    this.setLevel(D);
                    break;
                case 5:
                    this.setLevel(E);
                    break;
                case 6:
                    this.setLevel(F);
                    break;
            }
        }
        while (setup!=1&&setup!=2&&setup!=3&&setup!=4&&setup!=5&&setup!=6);
    }

    @Override
    public String toString() {
        return "Drives{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAUTO_ID() {
        return AUTO_ID;
    }

    public void setAUTO_ID(int AUTO_ID) {
        this.AUTO_ID = AUTO_ID;
    }
}
