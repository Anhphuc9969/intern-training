package Model;

import java.util.Scanner;
public class Subjects {

    private int idSubjects,totalPeriod,numberOfTheoreticalPperiods;
    private double expense;
    private String subjectName;

    private static int AUTO_ID = 100;

    public Subjects() {
        this.idSubjects = this.AUTO_ID;
        this.AUTO_ID++;
    }

    public Subjects(String subjectName, int totalPeriod, int numberOfTheoreticalPperiods, double expense) {
        this.idSubjects = this.AUTO_ID;
        this.AUTO_ID++;
        this.totalPeriod = totalPeriod;
        this.numberOfTheoreticalPperiods = numberOfTheoreticalPperiods;
        this.expense = expense;
        this.subjectName = subjectName;
    }


    public void nhapMonHoc(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Moi ban nhap thong tin mon hoc:");

        System.out.println("Ma mon hoc  :"+this.getIdSubjects());

        System.out.print("Nhap ten mon:");
        subjectName=sc.nextLine();


        System.out.print("Nhap tong so tiet:");
        totalPeriod=sc.nextInt();


        System.out.print("Nhap so tiet ly thuyet:");
        numberOfTheoreticalPperiods=sc.nextInt();

        System.out.println("Nhap muc kinh phi");
        expense=sc.nextDouble();



    }

    @Override
    public String toString() {
        return "Subjects{" +
                "idSubjects=" + idSubjects +
                ", totalPeriod=" + totalPeriod +
                ", NumberOfTheoreticalPperiods=" + numberOfTheoreticalPperiods +
                ", expense=" + expense +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }


    public int getIdSubjects() {
        return idSubjects;
    }



    public int getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(int totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public int getNumberOfTheoreticalPperiods() {
        return numberOfTheoreticalPperiods;
    }

    public void setNumberOfTheoreticalPperiods(int numberOfTheoreticalPperiods) {
        numberOfTheoreticalPperiods = numberOfTheoreticalPperiods;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }
}
