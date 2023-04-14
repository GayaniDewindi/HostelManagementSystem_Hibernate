package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.SettingBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.entity.User;


public class SettingBOImpl implements SettingBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAOType(DAOType.USER);

    @Override
    public boolean updateUserNameAndPassword(UserDTO dto) {
        return userDAO.save(new User(dto.getUserName(), dto.getPassword()));
    }
}
