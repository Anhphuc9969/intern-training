package reponsitory;

import model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.time.LocalDate;
import java.util.List;


public class StudentReponsitory {

    public boolean insertStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public boolean update(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> getAllStudent()
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            return session.createQuery("from STUDENTS_MANAGEMENT ").list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByName(String name)
    {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from STUDENTS_MANAGEMENT where lower(fullName) like lower(to_char(concat(concat('%', :student_name), '%'))) ");
            query.setParameter("student_name", name);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByGender(String gender){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from STUDENTS_MANAGEMENT where gender = :student_gender");
            query.setParameter("student_gender", gender);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByHometown(String homeTown){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from STUDENTS_MANAGEMENT where hometown = :student_hometown");
            query.setParameter("student_hometown", homeTown);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByClassName(String className){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from STUDENTS_MANAGEMENT where className = :student_className");
            query.setParameter("student_className", className);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByMajor(String major){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from STUDENTS_MANAGEMENT where major = :student_major");
            query.setParameter("student_major", major);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByAverage(double min, double max){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from STUDENTS_MANAGEMENT where averageMmark between :student_markMin and :student_markMax");
            query.setParameter("student_markMin", min);
            query.setParameter("student_markMax", max);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
