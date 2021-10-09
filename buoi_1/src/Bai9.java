public class Bai9 {
    public static boolean checkThuamNghich(int n) {
        boolean checked = false;
        String s = String.valueOf(n);
        int length = s.length();
        int dem = 0;
        int end;
        if (s.length() % 2 != 0) {
            end = (s.length() - 1) / 2;
        } else {
            end = s.length() / 2;
        }
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == s.charAt(length - 1 - i)) {
                dem++;
            } else {
                checked = false;
                break;
            }
        }
        if (dem == (int) length / 2) {
            checked = true;
        }
        return checked;
    }

    public static int tongSo(int n) {
        String s = String.valueOf(n);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result + Character.getNumericValue(s.charAt(i));
        }
        return result;
    }


    public static boolean checkSo(int n){
        boolean kt0 = false;
        boolean kt6 = false;
        boolean kt8 = false;
        boolean check = false;
        int dem = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            int valueOfi = Character.getNumericValue(s.charAt(i));
            if(valueOfi == 0){
                kt0 = true;
                dem ++;
            } else if ( valueOfi == 6) {
                kt6 = true;
                dem ++;
            } else if(valueOfi == 8 ){
                kt8 = true;
                dem ++;
            } else {
                check = false;
                break;
            }
        }
        if( dem == s.length() && kt0 && kt6 && kt8){
            check = true;
        }
        return  check;
    }

    public static void main(String[] args) {
        String a = "";
        String b = "";
        String c = "";

        for( int i = 1000000 ; i< 1000000000 ; i ++){
            if(checkThuamNghich(i)){
                a = a + " ; " + i;
                if( checkSo(i)){
                    b = c + " ; " + i;
                }
                if(tongSo(i) % 10 == 0){
                    c = c + " ; " + i;
                }

            }
        }

        System.out.println(" thuan nghich co 7 -9  so la: " + a);
        System.out.println("thuan nghich co 7 - 9  so vaco 0,6,8 la: " + b);
        System.out.println(c);
    }
}
