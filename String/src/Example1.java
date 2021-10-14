public class Example1 {

    public static void main(String[] args) {

        for (int i=100000; i<= 999999; i++){
            String s="";
            s+=i;
            if (isCheckThuanNghich(s)){
                System.out.println(i);
            }
        }
    }




    private static boolean isCheckThuanNghich(String s) {
                int a = s.length();
                for (int i=0; i<a ;i++){
                    if (s.charAt(i) != s.charAt(a-i-1)){
                    return false;
                }
            }
            return true;
    }

}
