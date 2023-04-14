package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.AddUserBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.Student;

import java.util.ArrayList;

public class AddUserBOImpl implements AddUserBO {
    private StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAOType(DAOType.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO dto) {
        return studentDAO.save(
                new Student(
                        dto.getStudent_id(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact_no(),
                        dto.getDob(),
                        dto.getGender()
                )
        );
    }

    @Override
    public boolean deleteStudent(StudentDTO dto) {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO dto) {
        return false;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() {
        return null;
    }
}
