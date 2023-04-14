package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.dto.RoomDTO;

import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    RoomDTO getRoom(String room_type_id);

    int getNotAvailableRoomCount(String room_type_id);

    boolean saveRegistration(ReservationDTO dto);

    boolean deleteRegistration(ReservationDTO dto);

    boolean updateRegistration(ReservationDTO dto);

    ArrayList<ReservationDTO> getAll();

    String getLastId();
}
