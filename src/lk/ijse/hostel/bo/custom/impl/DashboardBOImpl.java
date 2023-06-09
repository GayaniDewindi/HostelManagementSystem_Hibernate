package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.DashboardBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.QueryDAO;
import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.entity.Room;

import java.util.ArrayList;

public class DashboardBOImpl implements DashboardBO {
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAOType(DAOType.QUERY);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAOType(DAOType.STUDENT);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAOType(DAOType.ROOM);

    @Override
    public int getPendingPaymentCount() {
        return queryDAO.getAllPendingPaymentStudent().size();
    }

    @Override
    public int getRegisteredStudent() {
        return studentDAO.getAllStudent().size();
    }
    @Override
    public int getRoomCount() {
        ArrayList<Room> rooms = roomDAO.getAll();
        int count=0;
        for (Room r:rooms) {
            count+=r.getQty();
        }
        System.out.println(count);
        return count;
    }
}
