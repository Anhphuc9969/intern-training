package service;

import entity.TicketBuyers;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderTable {
    TicketBuyers ticketBuyers;
    List<TicketTable> ticketTables = new ArrayList<>();
    int sum;
    float priceTotal;

    public OrderTable(TicketBuyers ticketBuyers, List<TicketTable> ticketTables) {
        this.ticketBuyers = ticketBuyers;
        this.ticketTables = ticketTables;
    }
}
