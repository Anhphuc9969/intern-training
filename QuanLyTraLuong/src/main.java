import java.util.Scanner;
import Model.Subjects;
import Model.Teacher;
import Model.TeachingDeclaration;

public class main {

    public static Subjects[] subjectStorage=new Subjects[1000];
    public static int lenSubjectStorage=0;

    private static TeachingDeclaration[] TeachingDeclarationStogare=new TeachingDeclaration[10];
    public static int lenTeachingDeclarationStogare=0;

    public static Teacher[] TeacherStorage=new Teacher[1000];
    public static int lenTeacherStorage=0;

    public static void fakeData()
    {
        subjectStorage[lenSubjectStorage++]=new Subjects("Hóa",50,15,34);
        subjectStorage[lenSubjectStorage++]=new Subjects("Lý",70,15,34);
        subjectStorage[lenSubjectStorage++]=new Subjects("Sinh",60,19,34);

        TeacherStorage[lenTeacherStorage++]=new Teacher("Phuc","TH","034546555","GSTS");
        TeacherStorage[lenTeacherStorage++]=new Teacher("Nui","TH","034546555","GSTS");
        TeacherStorage[lenTeacherStorage++]=new Teacher("Minh","TH","034546555","GSTS");

    }

    public static void showSubject()
    {
        String result="";

        for(int i=0;i<lenSubjectStorage;i++)
        {
            result+=subjectStorage[i].toString()+"\n";
        }

        System.out.println(result);
    }

    public static void showDeclaration()
    {
        String result="";


        for(int i=0;i<lenTeachingDeclarationStogare;i++)
        {
            result+=TeachingDeclarationStogare[i].toString()+"\n";
        }

        System.out.println(result);
    }

    public static void showTeacher()
    {
        String result="";

        for(int i=0;i<lenTeacherStorage;i++)
        {
            result+=TeacherStorage[i].toString()+"\n";
        }

        System.out.println( result);
    }

    public static void menu()
    {
        fakeData();
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("--------Quản lý trả lương--------");
            System.out.println("1.Nhập danh sách môn học. In ra danh sách môn học đã có  ");
            System.out.println("2.Nhập danh sách giảng viên.  In ra danh sách GV đã có  ");
            System.out.println("3.Lập Bảng kê khai giảng dạy cho mỗi giảng viên và in danh sách ra màn hình");
            System.out.println("4.Sắp xếp danh sách kê khai giảng dạy theo họ tên giảng viên     ");
            System.out.println("5.Sắp xếp danh sách kê khai giảng dạy theo số tiết giảng dạy mỗi môn (giảm dần)");
            System.out.println("6.Tính toán và lập bảng tính tiền công cho mỗi giảng viên");
            System.out.println("7.Thoát");
            System.out.println("Moi ban chọn chương trình");

            input = sc.nextInt();

            switch (input){
                case 1 :
                   Subjects s=new Subjects();
                   s.nhapMonHoc();
                    subjectStorage[lenSubjectStorage++]=s;
                    showSubject();
                    break;


                case 2 :
                    Teacher gv =new Teacher();
                    gv.nhapGiangVien();
                    TeacherStorage[lenTeacherStorage++]=gv;
                    showTeacher();
                    break;

                case 3:
                    TeachingDeclaration KeKhai=new TeachingDeclaration();

                    KeKhai.enterStatistics(TeacherStorage,subjectStorage,TeachingDeclarationStogare);
                    TeachingDeclarationStogare[lenTeachingDeclarationStogare++]=KeKhai;
                    System.out.println(lenTeachingDeclarationStogare);
                    showDeclaration();

                    break;
                case 4:
                    TeachingDeclaration qlll = new TeachingDeclaration();

                    qlll.sortByName(TeachingDeclarationStogare,lenTeachingDeclarationStogare);
                    showDeclaration();
                    break;
                case 5:
                    TeachingDeclaration qll = new TeachingDeclaration();
                    qll.sortGiamDan(TeachingDeclarationStogare ,lenTeachingDeclarationStogare);

                    showDeclaration();
                    break;
                case 6:
                     TeachingDeclaration qllll=new TeachingDeclaration();
                     qllll.salary(subjectStorage,TeachingDeclarationStogare,lenTeachingDeclarationStogare);
            }
        }while (input>0 && input<7);

    }

    public static void main(String[] args) {
     menu();
    }
}
