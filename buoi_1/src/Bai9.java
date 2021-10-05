public class Bai9 {
    public static void main(String[] args) {

        System.out.println("Liệt kê tất cả số nguyên tố có 6 chữ số:");
        for (int i = 1000001; i < 999999999; i+=2) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }

    }


    public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
