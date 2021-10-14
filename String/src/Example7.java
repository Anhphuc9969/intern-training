import java.util.Scanner;
public class Example7
{
    public static void main(String[] args)
    {
        Scanner in= new Scanner(System.in);

        System.out.println("Nhập xâu thứ 1: ");
        String s1=in.nextLine();

        System.out.println("nhap xâu thứ 2: ");
        String s2= in.nextLine();

        int n=s2.length();
        String s= new String();
        String check;

        System.out.println("Các vị trí của s2 trong s1 : ");

        for(int i=0;i<s1.length()-n+1;i++)
        {
            check=s1.substring(i, i+n);
            if(check.equals(s2))
            {
                System.out.print(i + "   ");
            }
        }

        s1= s1.replaceAll(s2, s);

        System.out.println("\n xâu s1 bị xóa trong xâu s2: ");
        System.out.println(s1);


    }

}
