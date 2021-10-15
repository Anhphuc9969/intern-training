package Model;

import java.util.Scanner;

public class Teacher {

    private static final String GSTS="GS-TS";
    private static final String PGSTS="PGS-TS";
    private static final String GV="Giảng viên chính";
    private static final String TS="Thạc sĩ";



    private int id;
    private String name, address,phoneNumber,level;
    private static int AUTO_ID = 100;


    public Teacher() {
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
    }


    public Teacher(String name, String address, String phoneNumber, String level) {
        this.id = this.AUTO_ID;
        this.AUTO_ID++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level = level;
    }


    public void nhapGiangVien(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Moi ban nhap thong tin Giảng Viên:");
        System.out.println("Ma GV :"+this.getId());

        System.out.print("Nhap ho ten:");
        name=sc.nextLine();

        System.out.print("Nhap dia chi:");
        address=sc.nextLine();

        System.out.print("Nhap so dien thoai:");
        phoneNumber=sc.nextLine();

        System.out.println("Nhap trinh do:");
        System.out.println("1 GSTS");
        System.out.println("2 PGSTS");
        System.out.println("3 Giang vien chinh");
        System.out.println("4 TS");

        int setup;

        do
        {
            System.out.println("Hay chon chuyen nganh:");
            setup=sc.nextInt();
            switch(setup)
            {
                case 1:
                    this.setLevel(GSTS);
                    break;
                case 2:
                    this.setLevel(PGSTS);
                    break;
                case 3:
                    this.setLevel(GV);
                    break;
                case 4:
                    this.setLevel(TS);
                    break;
            }
        }
        while (setup!=1&&setup!=2&&setup!=3&&setup!=4);
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
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

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }
}
