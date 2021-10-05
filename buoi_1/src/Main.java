import java.util.Scanner;
public class Main {
    //bai1a
    public static int TinhTongSoChan(float n) {
        int s = 0;
        for (int i = 2; i <= n; i += 2) {
            s += i;
        }

        return s;
    }

    public static int TinhTongSoLe(float n) {
        int s = 0;
        for (int i = 1; i <= n; i += 2) {
            s += i;
        }

        return s;
    }
//bai1b
    public static double TinhTongSoTuNhien(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
//bai2
    public static int UocSo(int n) {
        int dem = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                dem++;
                System.out.println(" ước số của" + n + "là" + i);
            }
        }
        return dem;
    }

    ;
    //bai3
public static int Tong(int so){
    int soTemp;
    int tong = 0;
    soTemp = so;
    while (soTemp != 0) {
        tong += soTemp % 10;
        soTemp /= 10;
    }
    return tong;
}


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Nhập vào số nguyên n = ");
        int n = sc.nextInt();

        System.out.println("Tổng từ 2 đến " + n + " la = " + TinhTongSoChan(n));
        System.out.println("Tổng từ 1 đến " + n + " la = " + TinhTongSoLe(n));
        System.out.println("Tổng từ 1 đến " + (float) 1 / n + " la = " + TinhTongSoTuNhien(n));
        System.out.println("Tổng số ước số " + n + " la = " + UocSo(n));

        int b, c, temp1, temp2, uscln, bscnn;


        System.out.println("Nhập vào số thứ nhất: ");
        b = sc.nextInt();
        System.out.println("Nhập vào số thứ hai: ");
        c = sc.nextInt();

        while ((b <= 0) || (c <= 0)) {
            System.out.println("Nhập lại hai số nguyên dương!");
            System.out.println("Nhập vào số thứ nhất: ");
            b = sc.nextInt();
            System.out.println("Nhập vào số thứ hai: ");
            c = sc.nextInt();
        }


        temp1 = b;
        temp2 = c;
        while (temp1 != temp2) {
            if (temp1 > temp2) {
                temp1 -= temp2;
            } else {
                temp2 -= temp1;
            }
        }
        uscln = temp1;

        System.out.println("Ước số chung lớn nhất của " + b + " và " + c + " = " + uscln);
        System.out.println("Bội số chung nhỏ nhất của " + b + " và " + c + " = " +
                ((b * c) / uscln));


        int P, Q, t = 0;
        System.out.println("Nhập vào số thứ nhất: ");
        P = sc.nextInt();
        System.out.println("Nhập vào số thứ hai: ");
        Q = sc.nextInt();
        if (P > Q) {
            System.out.println("Moi ban nhap lai Q phải lớn hơn P");
        } else {
            for (int x = P; x < Q; x++) {
                for (int d = x + 1; d < Q; d++) {
                    for (int i = 1; i <= x; i++) {
                        if (x % i == 0 && d % i == 0) {
                            t++;
                        }
                    }
                    if (t == 1) {
                        System.out.println("Cặp số nguyên tố cùng nhau là" + x + "và" + d);
                    }
                    t=0;
                }
            }
        }
        int so;
        System.out.println("Nhập vào số nguyên: ");
        so = sc.nextInt();



        System.out.println("Tổng các chữ số của Số " + so + "là :" + Tong(so) );

        sc.close();
    }
}
