import java.util.*;
import java.util.Scanner;

public class Example5
{
    public static void convert(String s)
    {
        StringTokenizer st= new StringTokenizer(s);
        StringBuffer sb= new StringBuffer();
        String arr[]= new String[10];
        int i=1;

        while(st.hasMoreTokens())
        {
            arr[i]= st.nextToken();
            i++;
        }

        sb.append(arr[3]).append("  "); sb.append(arr[1]).append("  "); sb.append(arr[2]).append("  ");
        System.out.println("Sau khi hoán đổi : "+sb);

    }


    public static void main(String[] args) {
        String s0= new String();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhập xâu họ tên: ");
        s0= in.nextLine();
        convert(s0);

    }
}
