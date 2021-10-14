import java.util.Scanner;
public class Example3 {
    private String st;

    public Example3(String s) {
        st = s;
    }

    public Example3() { }


    public void nhapXau()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap xau: ");
        st =sc.nextLine();
    }


    public void hienThi()
    {
        System.out.println(st);
    }



    public void chuannHoa() {
        st = st.trim().toLowerCase();
        st = st.replaceAll("\\s+", " ");
        String[] temp = st.split(" ");
        st = "";
        for (int i = 0; i < temp.length; i++) {
            st += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1)
                st += " ";
        }
    }


    public void xoaKhoang()
    {
        st=st.trim().toLowerCase();
        st = st.replaceAll("\\s+", " ");

    }


    public static void main(String[] args)
    {
        Example3 a = new Example3();
        a.nhapXau();
        a.xoaKhoang();
        a.chuannHoa();
        System.out.println("Xau sau khi chuan hoa: ");
        a.hienThi();

    }
}