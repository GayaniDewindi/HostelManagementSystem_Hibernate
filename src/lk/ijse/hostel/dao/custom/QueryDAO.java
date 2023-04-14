package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SuperDAO;
import lk.ijse.hostel.entity.CustomEntity;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomEntity> getAllPendingPaymentStudent();
}
