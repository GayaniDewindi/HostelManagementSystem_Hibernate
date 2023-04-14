package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SQLUtil;
import lk.ijse.hostel.entity.Reservation;

import java.util.ArrayList;

public interface ReservationDAO extends SQLUtil<Reservation> {
    int getNotAvailableRoomCount(String room_type_id);

    String getLastId();

    ArrayList<Reservation> getAll();
}
