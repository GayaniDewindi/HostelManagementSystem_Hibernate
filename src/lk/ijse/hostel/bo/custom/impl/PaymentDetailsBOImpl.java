package lk.ijse.hostel.bo.custom.impl;



import lk.ijse.hostel.bo.custom.PaymentDetailsBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.QueryDAO;
import lk.ijse.hostel.dto.CustomDTO;
import lk.ijse.hostel.entity.CustomEntity;

import java.util.ArrayList;

public class PaymentDetailsBOImpl implements PaymentDetailsBO {
    private QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAOType(DAOType.QUERY);

    @Override
    public ArrayList<CustomDTO> getAllPendingPaymentStudent() {
        ArrayList<CustomEntity> customEntities = queryDAO.getAllPendingPaymentStudent();
        ArrayList<CustomDTO> customDTOS = new ArrayList<>();
        for (CustomEntity c : customEntities) {
            customDTOS.add(
                    new CustomDTO(
                            c.getStudent_id(),
                            c.getName(),
                            c.getAddress(),
                            c.getContact_no(),
                            c.getDob(),
                            c.getGender()
                    )
            );
        }
        return customDTOS;
    }
}
