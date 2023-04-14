package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SQLUtil;
import lk.ijse.hostel.entity.User;


public interface UserDAO extends SQLUtil<User> {
    User get(String userName);
}
