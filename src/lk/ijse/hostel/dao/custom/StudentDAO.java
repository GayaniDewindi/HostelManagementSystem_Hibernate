package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.SQLUtil;
import lk.ijse.hostel.entity.Student;

import java.util.ArrayList;

public interface StudentDAO extends SQLUtil<Student> {
    ArrayList<Student> getAllStudent();
}
