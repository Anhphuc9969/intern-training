
package Model;

import java.util.Scanner;

public class TeachingDeclaration {

    private Teacher teacher;
    private Subjects subjects;
    int numberClass;

    public TeachingDeclaration() {
    }

    public void enterStatistics(Teacher[] listTeacher , Subjects[] listSubjects , TeachingDeclaration[] listTeachingDeclaration )
    {

        int idTeacher;
        Subjects[] subjectsInputList=new Subjects[100];
        int lenSubjectsInput=0;
        int soTietDaCo=0;
        int idSubject;
        int classMax;
        boolean exist=false;

        //=true khi môn học tồn tại và chưa được nhập cho giảng viên trc đó
        boolean successInputSubject=false;

        Scanner sc = new Scanner(System.in);

        while (!exist) {
            System.out.println("Nhap ma Giang vien(100-999) :");
            idTeacher = sc.nextInt();

            for (int i = 0; i < 1000; i++)
            {
                if (listTeacher[i] != null && listTeacher[i].getId() == idTeacher)
                {
                    exist = true;
                    this.teacher = listTeacher[i];
                    break;
                }

            }
        }

        //Lấy số tiết đã có của giảng viên đó
        for(int i=0;i<1000;i++)
        {
            if(listTeachingDeclaration[i] == null)
            {
                break;
            }
            else
            {

                if(listTeachingDeclaration[i].getTeacher().getId() == this.teacher.getId())
                {
                    soTietDaCo += listTeachingDeclaration[i].getNumberClass()*listTeachingDeclaration[i].getSubjects().getTotalPeriod();
                }
            }
        }

        System.out.println("Số tiết giảng viên đó đã dạy là:"+soTietDaCo);


        //Lấy những môn mà giảng viên đó có thể dạy tiếp:
        //Nếu không có môn nào thì thoát

        for(int i=0;i<1000;i++)
        {
            if(listSubjects[i] == null)
            {
                break;
            }
            else
            {
                if((200-soTietDaCo)>listSubjects[i].getTotalPeriod())
                {
                    subjectsInputList[lenSubjectsInput++]=listSubjects[i];
                }
            }
        }
        System.out.println("Những môn học mà giảng viên đó có thể dạy tiếp:");

        for(int i=0;i<lenSubjectsInput;i++)
        {
            System.out.println(""+i+"."+subjectsInputList[i].getIdSubjects());
        }

        if(lenSubjectsInput == 0)
        {
            System.out.println("Không còn môn học nào thỏa mãn!");
            return;
        }

        exist=false;
        while (!exist)
        {

           System.out.println("Nhập mã môn học :");
           idSubject=sc.nextInt();
           for(int i=0 ;i<1000;i++)
           {
               if (subjectsInputList[i]==null)
               {

                   break;
               }
               else
               {
                   if (subjectsInputList[i].getIdSubjects() == idSubject)
                   {
                       exist = true;
                       boolean sucexit = false;//để check tên sách đã đc nhập trc đó,ko cho trùng tên sách
                       for (int k = 0; k < subjectsInputList.length; k++)
                       {
                           if (subjectsInputList[i]==null)
                           {
                               break;
                           }
                           if (subjectsInputList[k].getIdSubjects()== idSubject)
                           {
                               sucexit = false;
                               System.out.println("Môn học đã được mượn trước đó!");
                               break;
                           }
                       }
                       this.subjects=subjectsInputList[i];
                       break;
                   }
               }
           }
        }

        classMax=(200-soTietDaCo)/this.getSubjects().getTotalPeriod();
        classMax =classMax<3 ? classMax:3;

        do
        {
            System.out.println("Nhập số lớp:(<="+classMax+")");
            numberClass=sc.nextInt();
        }
        while (numberClass>classMax);

    }


    public static void sortByName(TeachingDeclaration[] list , int leng)
    {

        if (list == null || list.length == 0)
        {
            System.out.println("Bạn cần nhập danh sách giảng viên kê khai trước khi sắp xếp!");
            return;
         }

        for(int i=0 ; i<leng;i++)
        {
            for (int j=i+1 ; j<leng;j++)
            {
                int compareName=list[i].getSubjects().getSubjectName().compareTo(list[j].getSubjects().getSubjectName());

                if(compareName < 0 )
                {
                    TeachingDeclaration temp=list[i];
                    list[i]=list[j];
                    list[j]=temp;
                }
            }
        }
    }



    public static void sortGiamDan(TeachingDeclaration[] list, int len)
    {

        for(int i=0;i<len;i++)
        {
            for(int j=i+i;j<len;j++)
            {
                if(list[i].getSubjects().getTotalPeriod()<list[j].getSubjects().getTotalPeriod())
                {
                    TeachingDeclaration temp=list[i];
                    list[i]=list[j];
                    list[j]=temp;
                }
            }
        }
    }

    public void salary (Subjects[] listSubject, TeachingDeclaration[] list , int len ) {
        double soTietThucHanh;
        double salarys;

        for(int i=0;i<listSubject.length;i++){
            if(listSubject[i] == null){
                break;
            }else {
                soTietThucHanh = (listSubject[i].getTotalPeriod() - listSubject[i].getNumberOfTheoreticalPperiods());
                salarys = (listSubject[i].getNumberOfTheoreticalPperiods() * listSubject[i].getExpense()) + (soTietThucHanh * listSubject[i].getExpense() * 0.7);
                System.out.println("so tiet dậy thuc hanh " +soTietThucHanh);
                System.out.println("Số tiết dậy lý thuyết " + listSubject[i].getNumberOfTheoreticalPperiods());
                System.out.println("Số lương của giao viên "+ list[i].getTeacher().getId()+ " : " +salarys);
            }
        }
    }

    @Override
    public String toString() {
        return "TeachingDeclaration{" +
                "teacher=" + teacher +
                ", MonHoc=" + subjects +
                ", soLop=" + numberClass +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public int getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }
}




