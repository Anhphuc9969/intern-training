import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m,n,k;

        m=sc.nextInt();
        n=sc.nextInt();
        k=sc.nextInt();


        int[][] A = new int[m][n];
        int[][] B = new int[n][k];
        int[][] C = new int[m*n][n*k];


        System.out.println("Nhập mảng A ");
        nhapmang(A,m,n);
        System.out.println("Nhập mảng B ");
        nhapmang(B,n,k);
        System.out.println("Mảng A");
        xuatmang(A,m,n);
        System.out.println("Mảng B");
        xuatmang(B,n,k);
        System.out.println("Mảng sau khi nhân");
        xuatmang(C,m,k);
    }

    private static void xuatmang(int[][] c, int d, int e) {
        for (int i=0; i<d; i++){
            for (int j=0; j<e; j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    private static void nhapmang(int[][] c, int d, int e) {
        for (int i = 0; i<d;i++){
            for (int j=0;j<e; j++){
                c[i][j] = new Scanner(System.in).nextInt();
            }
        }
    }


}
