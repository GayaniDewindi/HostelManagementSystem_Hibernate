package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.bo.SuperBO;

public interface DashboardBO extends SuperBO {

    int getPendingPaymentCount();

    int getRegisteredStudent();

    int getRoomCount();
}
