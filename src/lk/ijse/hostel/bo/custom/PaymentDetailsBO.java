package lk.ijse.hostel.bo.custom;


import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.CustomDTO;

import java.util.ArrayList;

public interface PaymentDetailsBO extends SuperBO {

    ArrayList<CustomDTO> getAllPendingPaymentStudent();
}
