import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, count;
        int[] arr, res;
        System.out.println("Moi ban nhap so phan tu cua mang: ");
        n = sc.nextInt();
        arr = new int[n];
        res = new int[n];
        System.out.println("MOi ban nhap so phan tu cua mang: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            res[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = i + 1; j < n; j++) {
                if (res[j] != 0 && arr[i] == arr[j]) {
                    count++;
                    res[j] = 0;
                }

            }
            if (res[i] != 0) {
                res[i] = count;
            }

        }

        int max = res[0];
        for (int i = 0; i < n; i++) {
            if (res[i] > max) {
                max = res[i];
            }
        }
        System.out.println("So  lan xuat hien nhat la: " + max + "So do la : ");
        for (int i = 0; i < n; i++) {
            if (res[i] == max) {
                System.out.print(arr[i] + ", ");
            }

        }
        System.out.println("\b\b");
    }
    }

