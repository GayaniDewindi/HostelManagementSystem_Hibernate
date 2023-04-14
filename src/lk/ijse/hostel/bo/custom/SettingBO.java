package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.UserDTO;

public interface SettingBO extends SuperBO {
    boolean updateUserNameAndPassword(UserDTO dto);
}
