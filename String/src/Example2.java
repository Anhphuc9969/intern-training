import java.util.Scanner;

public class Example2 {
    public static void interlaced(){
        Scanner sc =  new Scanner(System.in);
        String chain;

        System.out.println("Mời bạn nhập chuỗi : /n" );
        chain= sc.nextLine();
        String chain1 =chain .toLowerCase();
        String search;


            for (int i = 0; i < chain1.length(); i+=3) {
                search = chain1.substring(i,i+2);
                chain1 = chain1.replaceAll(search , search.toUpperCase());
            }
             System.out.println(chain1);
    }

    public static void main(String[] args) {

      interlaced();


    }

}

