package repository;

import entity.Order;
import entity.TicketBuyers;
import entity.TrainTickets;
import org.hibernate.Session;
import utils.ConnnectionUtils;
import utils.HibernateUtils;
import org.hibernate.query.Query;
import java.util.List;
public class OrderRepository {
    public static void addOrder(List<Order> orderList){
        if (ConnnectionUtils.isEmpty(orderList)) {
            return;
        }

        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
//            session.beginTransaction();
            session.getTransaction().begin();
            for (Order O: orderList) {
                O.toString();

                TicketBuyers ticketBuyers=O.getTicketBuyers();
                TrainTickets trainTickets=O.getTrainTickets();
                session.save(O);
            }
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    public  static List<Order> getAllOrder() {
        String sql = "From ORDER_TRAIN_TICKETS";
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Order> query = session.createQuery(sql);
            List<Order> orderList = query.getResultList();
            session.getTransaction().commit();

            return orderList;
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return null;

    }


}
