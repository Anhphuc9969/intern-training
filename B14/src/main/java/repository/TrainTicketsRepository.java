package repository;

import java.util.List;

import dto.TrainTicketsDto;
import entity.TrainTickets;

public interface TrainTicketsRepository {
    List<TrainTickets> getAll();

    TrainTickets findById(int id);

    boolean addNew(List<TrainTickets> trainTickets);

    boolean updateTrainTickets(TrainTickets trainTickets);

    boolean deleteTrainTickets(TrainTickets trainTickets);

    List<TrainTicketsDto> getAllTrainTicketsDto();
}
