package lk.ijse.hostel.bo.custom;

import lk.ijse.hostel.bo.SuperBO;
import lk.ijse.hostel.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto);

    boolean deleteStudent(StudentDTO dto);

    boolean updateStudent(StudentDTO dto);

    ArrayList<StudentDTO> getAllStudent();
}
