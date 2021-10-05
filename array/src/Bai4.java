import  java.util.Scanner;
public class Bai4 {
       const int N = 1e6;

    int a[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


            int n;
            cin >> n;
            map<int, int> cnt;
            for(int i = 0; i < n;i++){
                cin >> a[i];
            }

            for(int i = 0; i < n;i++){
                cnt[a[i]]++;
            }
            for(auto it : cnt){
                cout << "Gia tri " << it.first << " xuat hien " << it.second << " lan!\n";
            }
        }
    }
}
