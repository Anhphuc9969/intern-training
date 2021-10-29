package repository;


import dto.TicketBuyersDto;
import entity.TrainTickets;
import org.hibernate.query.Query;
import repository.TicketBuyersRepository;
import entity.TicketBuyers;
import org.hibernate.query.NativeQuery;
import utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class TicketBuyersImpl implements TicketBuyersRepository {

    @Override
    public List<TicketBuyers> getAll() {

//            Session session = HibernateUtils.getSessionFactory().openSession();
//            try
//            {
//                session.beginTransaction();
//                List<TicketBuyers> ticketBuyersList =  session.createQuery("from TICKET_BUYERS").list();
//                return ticketBuyersList;
//            } catch (HibernateException e)
//            {
//            } finally
//            {
//                session.close();
//            }
        return null;
    }


    public static List<TicketBuyers> getAllUser() {

        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            List<TicketBuyers> ticketBuyers = (List<TicketBuyers>) session.createQuery("from TICKET_BUYERS").list();
//            session.getTransaction().commit();
            return ticketBuyers;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public TicketBuyers findById(int id) {
        return null;
    }

    @Override
    public boolean addNew(List<TicketBuyers> ticketBuyers) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            for (TicketBuyers nmv : ticketBuyers) {
                session.save(nmv);
            }
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateTicketBuyers(TicketBuyers ticketBuyers) {
        return false;
    }

    @Override
    public boolean deleteTicketBuyers(TicketBuyers ticketBuyers) {
        return false;
    }

    @Override
    public List<TicketBuyersDto> getAllTicketBuyersDto() {
        return null;
    }

//    public List<TicketBuyers> getAllTicketBuyers() {
//        Session session = HibernateUtils.getSessionFactory().openSession();
//        List<TicketBuyers> ticketBuyers = new ArrayList<>();
//        try {
//             ticketBuyers = (List<TicketBuyers>) session.createQuery("from TICKET_BUYERS").list();
//            return ticketBuyers;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return ticketBuyers;
//    }


}

