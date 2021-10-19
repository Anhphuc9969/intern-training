package Model;
import java.util.Scanner;
public class Telephone {

    private int idTelephone;
    private String manufacture;
    private String model;
    private double unitPrice;

    private static int AUTO_ID = 10000;

    public Telephone() {

        this.idTelephone = this.AUTO_ID;
        this.AUTO_ID++;
    }

    public Telephone( String manufacture, String model, double unitPrice) {

        this.idTelephone = this.AUTO_ID;
        this.AUTO_ID++;
        this.manufacture = manufacture;
        this.model = model;
        this.unitPrice = unitPrice;
    }

    public void inputTelephone(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Mời bạn nhập thông tin Telephone:");

        System.out.println("Mã telephone  :"+this.getIdTelephone());

        System.out.print("Nhập hãng sản xuất:");
        manufacture=sc.nextLine();

        System.out.print("Nhap model:");
        model=sc.nextLine();

        System.out.print("Nhap đơn giá:");
        unitPrice=sc.nextDouble();

    }

    @Override
    public String toString() {
        return "Telephone{" +
                "idTelephone=" + idTelephone +
                ", manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public int getIdTelephone() {
        return idTelephone;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }
}
