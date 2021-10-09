import java.util.Scanner;
public class Bai8 {
    public static void nhap(int heared[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < heared.length; i++) {
            System.out.print("Nhập phần tử thứ " + i );
            heared[i] = scanner.nextInt();
        }

    }


    //-----
    public static void xuat(int heared[]) {
        for (int i = 0; i < heared.length; i++) {
            System.out.print(heared[i] );
        }
    }
//----


    public static void duongDai(int a[]){
        int max = 1;
        int dodai = 1;
        int vitribatdau = -1;
        for(int i = 0; i< a.length-1; i++){

            if( a[i] <= a[i+1]){
                dodai ++;
                if( max < dodai){
                    max = dodai;
                    vitribatdau = i+1-(max-1);

                }

            }else {
                dodai = 1;


            }
        }
        System.out.println("\n max = " + max);
        System.out.println("vi tri bat dau: " + vitribatdau);
    }


    // ---
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n < 0 || n > 1000);


        int heared[] = new int[n];

        nhap(heared);
        System.out.println("\n mảng vừa nhập: ");
       xuat(heared);
        duongDai(heared);
    }
}
