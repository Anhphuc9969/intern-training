import java.util.ArrayList;
import java.util.List;
public class Bai8 {
    public static int DEC_10 = 10;

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        int count = 0;
        // in ra màn hình các số thuận nghịch có 6 chữ số
        for (int i = 100000; i < 1000000; i++) {
            if (isThuanNghich(i)) {
                System.out.println(i);

            }
        }

    }



    public static boolean isThuanNghich(int n) {
        List<Integer> listNumbers = new ArrayList<>();
        // phân tích số n thành các chữ số và lưu vào listNumbers
        do {
            listNumbers.add(n % DEC_10);
            n = n / DEC_10;
        } while (n > 0);
        // kiểm tra tính thuận nghịch
        int size = listNumbers.size();
        for (int i = 0; i < (size/2); i++) {
            if (listNumbers.get(i) != listNumbers.get(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
