package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.LogInBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.entity.User;


public class LogInBOImpl implements LogInBO {
    private final UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAOType(DAOType.USER);

    @Override
    public UserDTO getUser(String userName) {
        User user = userDAO.get(userName);
        return new UserDTO(user.getUserName(), user.getPassword());
    }
}
