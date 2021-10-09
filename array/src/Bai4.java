import  java.util.Scanner;
public class Bai4 {
    public static void listMang(){
        Scanner sc=new Scanner(System.in);
        int n,b;
        System.out.println("Nhap n:");
        n=sc.nextInt();
        System.out.println("Nhap c:");
        b=sc.nextInt();
        int [] a=new int[n];
        for(int i=0; i<n; i++)
        {
            a[i]=sc.nextInt();
        }
        int check=Math.abs(a[0]-b);
        int p=0;
        for(int i=1; i<n-1; i++)
        {
            if(check>Math.abs(a[i]-b)){
                check=Math.abs(a[i]-b);
                p=i;
            }
        }
        System.out.println("gần x nhất:"+a[p]+" vị trí ở "+p);
    }

    public static void main(String[] args) {
        listMang();
    }
}
