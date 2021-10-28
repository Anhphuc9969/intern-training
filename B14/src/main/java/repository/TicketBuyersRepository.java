package repository;

import dto.TicketBuyersDto;
import entity.TicketBuyers;
import java.util.List;

public interface TicketBuyersRepository {
    List<TicketBuyers> getAll();

    TicketBuyers findById(int id);

    boolean addNew(List<TicketBuyers> ticketBuyers);

    boolean updateTicketBuyers(TicketBuyers ticketBuyers);

    boolean deleteTicketBuyers(TicketBuyers ticketBuyers);

    List<TicketBuyersDto> getAllTicketBuyersDto();

}
