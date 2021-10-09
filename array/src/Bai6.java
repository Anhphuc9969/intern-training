import java.util.Scanner;
public class Bai6{
        public static void main(String[] args) {
            System.out.println("Nhập số  phần tử mảng a: ");
            int n = new Scanner(System.in).nextInt();
            System.out.println("Nhập số phần tử mảng b: ");
            int m = new Scanner(System.in).nextInt();
            System.out.println("Nhập p: ");
            int p = new Scanner(System.in).nextInt();
            int[]a = new int[n];
            int[]b = new int[m];
            System.out.println("Nhập mảng của a: ");
            nhap(a,n);
            System.out.println("Nhập mảng của b: ");
            nhap(b,m);
            if (p>=0 && p<=n){
                xuat(a,0,p);
                xuat(b,0,m);
                xuat(a,p,n);
            }
        }

        private static void xuat(int[] a, int d, int c) {
            for (int i = d; i<c; i++){
                System.out.print(a[i]+" ");
            }
        }

        private static void nhap(int[] a, int n) {
            for (int i = 0; i < n; i++) {
                a[i] = new Scanner(System.in).nextInt();
            }
        }
}
