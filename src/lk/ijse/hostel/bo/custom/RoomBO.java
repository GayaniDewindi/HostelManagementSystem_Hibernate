package lk.ijse.hostel.bo.custom;


import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.RoomDTO;

import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    boolean saveRoom(RoomDTO dto);

    boolean deleteRoom(RoomDTO dto);

    boolean updateRoom(RoomDTO dto);

    ArrayList<RoomDTO> loadAll();
}
