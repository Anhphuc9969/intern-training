package repository;

import dto.TrainTicketsDto;
import entity.TrainTickets;
import dto.TicketBuyersDto;
import repository.TicketBuyersRepository;
import entity.TicketBuyers;
import org.hibernate.query.NativeQuery;
import utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import java.util.ArrayList;
import java.util.List;

public class TrainTicketsImpl implements TrainTicketsRepository{

    @Override
    public ArrayList<TrainTickets> getAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            List<TrainTickets> trainTicketsList = (List<TrainTickets>) session.createQuery("from TRAIN_TICKETS").list();
         return (ArrayList<TrainTickets>) trainTicketsList;
        } catch (HibernateException e){

        }finally {
            session.close();
        }


        return null;
    }


    public static ArrayList<TrainTickets> getAllTrainTickets() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            List<TrainTickets> trainTicketsList = (List<TrainTickets>) session.createQuery("from TRAIN_TICKETS").list();
            return (ArrayList<TrainTickets>) trainTicketsList;
        } catch (HibernateException e){

        }finally {
            session.close();
        }


        return null;
    }

    @Override
    public TrainTickets findById(int id) {
        return null;
    }

    @Override
    public boolean addNew(List<TrainTickets> trainTicketsList) {
        Session session = HibernateUtils.getSessionFactory().openSession();


        try {
            session.beginTransaction();
            for ( TrainTickets vt: trainTicketsList

            ) {
                session.save(vt);
            }
            session.getTransaction().commit();
            return true;

        }catch (HibernateException e){
            session.getTransaction().rollback();

        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateTrainTickets(TrainTickets trainTickets) {
        return false;
    }

    @Override
    public boolean deleteTrainTickets(TrainTickets trainTickets) {
        return false;
    }

    @Override
    public List<TrainTicketsDto> getAllTrainTicketsDto() {
        return null;
    }


}
