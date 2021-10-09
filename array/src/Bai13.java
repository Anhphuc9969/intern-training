import java.util.Scanner;
public class Bai13 {
    public static int[][] mangnhapvao = new int[20][20];
    public static int[][] Mangxoaychieu = new int[20][20];
    public static int n;

    public static void main(String[] args) {
        System.out.println("Nhap ma tran vuong cap: ");
        n = new Scanner(System.in).nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = i + 1;
                int b = j + 1;
                System.out.println("Nhập phần thử thứ " + b + " hàng " + a + " = ");
                mangnhapvao[i][j] = new Scanner(System.in).nextInt();
            }
        }
        System.out.println("\nMa tran nhap vao la: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mangnhapvao[i][j] + "  ");
            }
            System.out.println("");
        }

        System.out.println("\nMa tran xoay 90 do: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Mangxoaychieu[i][j] = mangnhapvao[j][n - 1 - i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Mangxoaychieu[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
