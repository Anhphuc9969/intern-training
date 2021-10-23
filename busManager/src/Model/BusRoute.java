package Model;

import java.util.Scanner;

public class BusRoute {

    private int idBusRoute, numberOfStops;
    private double distance;
    private static int AUTO_ID = 100;

    public BusRoute() {
        this.idBusRoute = this.AUTO_ID;
        this.AUTO_ID++;
    }

    public BusRoute(int numberOfStops, double distance) {
        this.idBusRoute = this.AUTO_ID;
        this.AUTO_ID++;
        this.numberOfStops = numberOfStops;
        this.distance = distance;
    }

    public void inputBusRoute() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Mời bạn nhập thông tin tuyến:");
        System.out.println("Mã tuyến :" + this.getIdBusRoute());

        System.out.print("Nhập khoảng cách km :");
        distance = sc.nextDouble();

        System.out.println("Mời bạn nhập số điểm dừng :");
        numberOfStops = sc.nextInt();

    }

    public int getIdBusRoute() {
        return idBusRoute;
    }


    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getAUTO_ID() {
        return AUTO_ID;
    }

    public void setAUTO_ID(int AUTO_ID) {
        this.AUTO_ID = AUTO_ID;
    }

    @Override
    public String toString() {
        return "BusRoute{" +
                "idBusRoute=" + idBusRoute +
                ", numberOfStops=" + numberOfStops +
                ", distance=" + distance +
                '}';
    }
}
