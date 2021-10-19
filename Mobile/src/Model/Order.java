package Model;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Scanner;

public class Order {
    private Customers customers;
    private Telephone telephone;
    private int lenTelephone = 0;
    int quantitys;
    int sum;

    public Order(Customers customers, Telephone telephone) {
        this.customers = customers;
        this.telephone = telephone;
    }

    public Order() {
    }

    public void orderInput(Customers[] listCustomer, Telephone[] listTelephone, Order[] listOrder) {
        int idCustomers;
        boolean exist = false;
        int quantity;

        String nameTelephone;

        Scanner sc = new Scanner(System.in);

        while (!exist) {
            System.out.println("Mời bạn nhập mã khách hàng :");
            idCustomers = sc.nextInt();

            for (int i = 0; i < 1000; i++) {
                if (listCustomer[i] != null && listCustomer[i].getId() == idCustomers) {
                    exist = true;
                    this.customers = listCustomer[i];
                    break;
                }
            }
        }

        System.out.println("Mời bạn nhập số lượng hãng điện thoại muốn mua");
        quantity = sc.nextInt();


        for (int j = 0; j < quantity; j++) {
            exist = false;

            while (!exist) {

                System.out.println("Nhập tên hãng điện thoại thứ " + (j + 1));
                nameTelephone = sc.nextLine();
                exist = false;
                for (int k = 0; k < 1000; k++) {
                    if (listTelephone[k] != null && listTelephone[k].getManufacture().equals(nameTelephone)) {
                        exist = true;

                        System.out.println("Mời bạn nhập số lượng điện thoại muốn mua :");
                        quantitys = sc.nextInt();

                        listTelephone[lenTelephone++] = listTelephone[k];
                        System.out.println("Số lượng điện thoại muốn mua :" +listTelephone[k]+" Số lượng điện thoại :"+ quantitys);
                        break;
                    }
                }

            }
            this.sum=sum+quantitys;

        }

        System.out.println("Tổng số điện thoại muốn mua là:"+sum);
    }

    public static void sortByName(Order[] list ,int leng){
        if (list == null || list.length == 0) {
            System.out.println("Bạn cần nhập danh sách khách hàng trước khi sắp xếp!");
            return;
        }

        for(int i=0 ; i<leng;i++){
            for (int j=i+1 ; j<leng;j++){
                int compareName=list[i].getCustomers().getName().compareTo(list[j].getCustomers().getName());

                if(compareName < 0 ){
                    Order temp=list[i];

                    list[i]=list[j];

                    list[j]=temp;
                }
            }
        }
    }

    public static void sortGiamDan(Order[] list, int len){

        for(int i=0;i<len;i++){
            for(int j=i+i;j<len;j++){
                if(list[i].sum>list[j].sum){
                    Order temp=list[i];

                    list[i]=list[j];

                    list[j]=temp;
                    System.out.println("Tổng điện thoại : "+list[i].getCustomers().getId()+ " : "+list[i].sum +" \n" + "Tổng điện thoại"+ list[j].getCustomers().getId()+ " : " + list[j].sum);
                }
            }
        }
    }

    public static void moneyStatistics(Customers[] listCustomers ,Telephone[] listTelephone, Order[] listOrder,int leng){
        for (int i=0;i<listCustomers.length;i++){
            if(listCustomers[i] == null){
                break;
            }else {
                System.out.println("Khách hàng mã : " + listOrder[i].getCustomers().getId() + "Số tiền phải chi trả cho : " + listOrder[i].getTelephone().getUnitPrice() );
            }
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "customers=" + customers +
                ", telephone=" + telephone +
                ", lenTelephone=" + lenTelephone +
                ", quantitys=" + quantitys +
                '}';
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public int getLenTelephone() {
        return lenTelephone;
    }

    public void setLenTelephone(int lenTelephone) {
        this.lenTelephone = lenTelephone;
    }

    public int getQuantitys() {
        return quantitys;
    }

    public void setQuantitys(int quantitys) {
        this.quantitys = quantitys;
    }
}
