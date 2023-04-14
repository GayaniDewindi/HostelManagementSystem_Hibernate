package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SQLUtil;
import lk.ijse.hostel.entity.Room;

import java.util.ArrayList;

public interface RoomDAO extends SQLUtil<Room> {
    Room get(String room_type_id);

    ArrayList<Room> getAll();
}
