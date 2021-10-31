package service;

import model.Student;
import reponsitory.StudentReponsitory;
import DTO.StudentDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
public class StudentService {
    StudentReponsitory studentReponsitory = new StudentReponsitory();

    public List<Student> getListStudent() {
        return studentReponsitory.getAllStudent();
    }


    public List<Student> getListStudentByName(String name){
        return studentReponsitory.getStudentByName(name);
    }

    public List<Student> getListStudentByGender(String gender){
        return studentReponsitory.getStudentByGender(gender);
    }

    public List<Student> getListStudentByHometown(String hometown){
        return studentReponsitory.getStudentByHometown(hometown);
    }

    public List<Student> getListStudentByClassName(String className){
        return studentReponsitory.getStudentByClassName(className);
    }

    public List<Student> getListStudentByMajor(String major){
        return studentReponsitory.getStudentByMajor(major);
    }

    public List<Student> getListStudentAverageMark(double min, double max){
        return studentReponsitory.getStudentByAverage(min, max);
    }

    public boolean insert(StudentDTO studentDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Student student = new Student();
        try {
            student.setBirthday(sdf.parse(studentDTO.getBirthday()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setAverageMmark(studentDTO.getAverageMark());
        student.setGender(studentDTO.getGender());
        student.setClassName(studentDTO.getClassName());
        student.setHometown(studentDTO.getHometown());
        student.setMajor(studentDTO.getMajor());
        student.setFullName(studentDTO.getFullName());
        if (student.getFullName() == null){
            return false;
        }
        if (student.getBirthday() == null){
            return false;
        }
        if (student.getClassName() == null || student.getClassName().length() > 50 || student.getClassName().length() < 1){
            return false;
        }
        if (student.getMajor() == null){
            return false;
        }
        if (student.getHometown() == null){
            return false;
        }
        if (student.getGender() == null){
            return false;
        }
        if (student.getAverageMmark() > 10 || student.getAverageMmark() < 0){
            return false;
        }
        return studentReponsitory.insertStudent(student);
    }

    public boolean update(Student student) {
        if(student.getID() <= 0){
            return false;
        }
        if (student.getFullName() == null){
            return false;
        }
        if (student.getBirthday() == null){
            return false;
        }else {
            Period period = Period.between(LocalDate.ofEpochDay(student.getBirthday().getDate()), LocalDate.now());
            if(period.getYears() > 100 || period.getYears() < 0){
                return false;
            }
        }
        if (student.getClassName() == null || student.getClassName().length() > 50 || student.getClassName().length() < 1){
            return false;
        }
        if (student.getMajor() == null){
            return false;
        }
        if (student.getHometown() == null){
            return false;
        }
        if (student.getGender() == null){
            return false;
        }
        if (student.getAverageMmark() > 10 || student.getAverageMmark() < 0){
            return false;
        }
        return studentReponsitory.update(student);
    }

    public boolean removeStudent(int id) {
        return studentReponsitory.deleteStudent(id);
    }
}
