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
        int idDrives;//id tài xế
        int idBusRoutes;//id tuyến chạy
        int quantity;//số lượng lượt chạy trong mỗi tuyến

        Scanner sc = new Scanner(System.in);


        //mã tài xế
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
        //


        //số tuyến
        do {
            System.out.println("Nhập số lượng tuyến chạy của lái xe :");
            quantitys = sc.nextInt();
        }
        while (quantitys< 0 || quantitys > 15);


        //Nhập mã tuyến và số lượt chạy cho mỗi tuyến
        for (int i = 0; i < quantitys; i++) {


            //
            exist = true;

            while (exist) {


                System.out.println("Nhập mã tuyến thứ : " + (i + 1));
                idBusRoutes = sc.nextInt();

                //check exist in busRouteList
                for (BusRoute b : busRouteList) {
                    if (b.getIdBusRoute() == idBusRoutes) {


                        exist=false;
                        //để check mã tuyến đã đc nhập trc đó,ko cho trùng mã tuyến
                        for (Map.Entry<BusRoute, Integer> entry : busRouteMap.entrySet()) {
                            if (entry.getKey().getIdBusRoute() == idBusRoutes) {
                                System.out.println("Mã tuyến đã được nhập trước đó!");
                                exist=true;
                                break;
                            }
                        }
                        //end

                        boolean sucxist=false;
                        if(!sucxist) {

                            //Nhập số lượt chạy
                            do{
                                System.out.println("Nhập số lượt chạy:");
                                quantity=sc.nextInt();
                            }while (quantitys+quantity>15);

                            busRouteMap.put(b, quantity);

                        }

                    }

                }


            }

        }


    }



//    public static void sortGiamDan(AssignmentSheet[] list, int len) {
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i + i; j < len; j++) {
//                if (list[i].quantitys > list[j].quantitys) {
//                    AssignmentSheet temp = list[i];
//
//                    list[i] = list[j];
//
//                    list[j] = temp;
//                }
//            }
//
//        }
//    }

    public static void sortByName(List<Drives> list ,int leng){
        if (list == null || list.size() == 0) {
            System.out.println("Bạn cần nhập danh sách ban doc trước khi sắp xếp!");
            return;
        }

        for(int i=0 ; i<leng;i++){
            for (int j=i+1 ; j<leng;j++){
                int compareName=list.get(i).getName().compareTo(list.get(j).getName());

                if(compareName < 0 ){
                    Drives temp=list.get(i);

                    list.get(i)=list.get(j);

                    list.get(j)=temp;
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


