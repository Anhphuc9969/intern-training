package Model;
import java.util.Scanner;
public class Customers extends Persons {
    private int id;
    private String CustomerGroup;

    private final static String RETAIL = "Mua lẻ";
    private final static String BUY_WHOLESALE = "Mua buôn";
    private final static String BUY_ONLINE ="Mua online";

    private static int AUTO_ID = 10000;

    public Customers() {
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
    }

    public Customers(String name, String address, String phoneNumber, String customerGroup) {
        super(name, address, phoneNumber);
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
        CustomerGroup = customerGroup;
    }

    public void inputCustomers(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Mời bạn nhập thông tin khách hàng:");
        System.out.println("Ma khách hàng :"+this.getId());
        super.inputReceipt();
        System.out.println("Nhập nhóm khách hàng:");
        System.out.println("1 Mua lẻ");
        System.out.println("2 Mua buôn ");
        System.out.println("3 Mua qua mạng");

        int setup;

        do
        {
            System.out.println("Hãy chọn nhóm khách hàng:");
            setup=sc.nextInt();
            switch(setup)
            {
                case 1:
                    this.setCustomerGroup(RETAIL);
                    break;
                case 2:
                    this.setCustomerGroup(BUY_WHOLESALE);
                    break;
                case 3:
                    this.setCustomerGroup(BUY_ONLINE);
                    break;
            }
        }
        while (setup!=1&&setup!=2&&setup!=3);
    }

    public int getId() {
        return id;
    }


    public String getCustomerGroup() {
        return CustomerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        CustomerGroup = customerGroup;
    }

    public static String getRETAIL() {
        return RETAIL;
    }

    public static String getBuyWholesale() {
        return BUY_WHOLESALE;
    }

    public static String getBuyOnline() {
        return BUY_ONLINE;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", CustomerGroup='" + CustomerGroup + '\'' +
                "name='" + this.getName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                '}';
    }

}
