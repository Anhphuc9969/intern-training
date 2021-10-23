package Model;
import java.util.*;
public class AssignmentSheet {


    private Drives drives;
    private Map<BusRoute, Integer> busRouteMap = new HashMap<>();
    int quantitys = 0;


    public AssignmentSheet() {
    }

    public AssignmentSheet(Drives drives, Map<BusRoute, Integer> busRouteMap, int quantitys) {
        this.drives = drives;
        this.busRouteMap = busRouteMap;
        this.quantitys = quantitys;
    }


    public static void fakeDate() {
        List<BusRoute> busRouteList = new ArrayList<>(10);

    }


    public void inputAssignmentSheer(List<Drives> drivesList, List<BusRoute> busRouteList) {
        boolean exist = false;
        int idDrives;
        int idBusRoutes;
        int quantitys = 0;
        int number = 15;
        int quantityMax = 0;
        Scanner sc = new Scanner(System.in);


        while (!exist) {
            System.out.println("Nhập mã lái xe(10000-99999) :");
            idDrives = sc.nextInt();

            for (int i = 0; i < 1000; i++) {
                if (drivesList.get(i) != null && drivesList.get(i).getId() == idDrives) {
                    exist = true;
                    this.drives = drivesList.get(i);
                    break;
                }
            }
            System.out.println("list" + drivesList);
        }


        System.out.println("Nhập số lượng tuyến chạy của lái xe :");
        quantitys = sc.nextInt();

        for (int i = 0; i < quantitys; i++) {

            exist = false;

            while (!exist) {
                do {
                    System.out.println("Nhập mã tuyến thứ : " + (i + 1));
                    idBusRoutes = sc.nextInt();

                }
                while (idBusRoutes > 0 && idBusRoutes <= 15);

                exist = false;

                for (BusRoute b : busRouteList) {
                    if (b.getIdBusRoute() == idBusRoutes) {

                        exist = true;

                        //để check mã tuyến đã đc nhập trc đó,ko cho trùng mã tuyến
                        for (Map.Entry<BusRoute, Integer> entry : busRouteMap.entrySet()) {
                            if (entry.getKey().getIdBusRoute() == idBusRoutes) {
                                exist = false;
                                System.out.println("Mã tuyến đã được nhập trước đó!");
                                break;
                            }

                        }


                    }
                    for (int j = quantitys; j <= quantitys; j--) {
                        quantityMax = number - quantitys + 1;
                        System.out.println("số lượng max lượt chạy của lái xe là :" + quantityMax);
                    }

                    busRouteMap.put(b, quantityMax);
                }

            }


        }

    }

    public static void sortGiamDan(AssignmentSheet[] list, int len) {

        for (int i = 0; i < len; i++) {
            for (int j = i + i; j < len; j++) {
                if (list[i].quantitys > list[j].quantitys) {
                    AssignmentSheet temp = list[i];

                    list[i] = list[j];

                    list[j] = temp;
                }
            }

        }
    }

    public static void sortByName(Drives[] list ,int leng){
        if (list == null || list.length == 0) {
            System.out.println("Bạn cần nhập danh sách ban doc trước khi sắp xếp!");
            return;
        }

        for(int i=0 ; i<leng;i++){
            for (int j=i+1 ; j<leng;j++){
                int compareName=list[i].getName().compareTo(list[j].getName());

                if(compareName < 0 ){
                    Drives temp=list[i];

                    list[i]=list[j];

                    list[j]=temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AssignmentSheet{" +
                "drives=" + drives +
                ", busRouteMap=" + busRouteMap +
                ", quantitys=" + quantitys +
                '}';
    }

    public Drives getDrives () {
                return drives;
            }

            public void setDrives (Drives drives){
                this.drives = drives;
            }

            public Map<BusRoute, Integer> getBusRouteMap () {
                return busRouteMap;
            }

            public void setBusRouteMap (Map < BusRoute, Integer > busRouteMap){
                this.busRouteMap = busRouteMap;
            }
        }


