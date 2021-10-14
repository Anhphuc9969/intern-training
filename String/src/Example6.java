import java.util.*;
import java.util.Scanner;

public class Example6
{
    public static void sortAlphabet(String s)
    {
        StringTokenizer st= new StringTokenizer(s);
        ArrayList<String> arr= new ArrayList<>();
        int n= st.countTokens();
        int i=0;

        while(st.hasMoreTokens())
        {
            String s1=st.nextToken();
            arr.add(s1);

        }
        Collections.sort(arr);
        System.out.println(arr.toString());
    }

    public static void main(String[] args)
    {

        Scanner in= new Scanner(System.in);
        System.out.println("Mời bạn nhập xâu : ");
        String s2= in.nextLine();
        sortAlphabet(s2);
    }
}
