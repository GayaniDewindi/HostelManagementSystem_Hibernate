package lk.ijse.hostel.bo.custom.impl;

import lk.ijse.hostel.bo.custom.ReservationBO;
import lk.ijse.hostel.dao.DAOFactory;
import lk.ijse.hostel.dao.DAOType;
import lk.ijse.hostel.dao.custom.ReservationDAO;
import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dto.ReservationDTO;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.entity.Reservation;
import lk.ijse.hostel.entity.Room;
import lk.ijse.hostel.entity.Student;

import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getInstance().getDAOType(DAOType.ROOM);
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getInstance().getDAOType(DAOType.RESERVATION);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getInstance().getDAOType(DAOType.STUDENT);

    @Override
    public RoomDTO getRoom(String room_type_id) {
        Room room = roomDAO.get(room_type_id);
        return new RoomDTO(
                room.getRoom_type_id(),
                room.getType(),
                room.getKey_money(),
                room.getQty()
        );
    }

    @Override
    public int getNotAvailableRoomCount(String room_type_id) {
        return reservationDAO.getNotAvailableRoomCount(room_type_id);
    }

    @Override
    public boolean saveRegistration(ReservationDTO dto) {
        Student student = new Student();
        student.setStudent_id(dto.getStudent_id());
        Room room = new Room();
        room.setRoom_type_id(dto.getRoom_type_id());
        return reservationDAO.save(
                new Reservation(
                        dto.getRes_id(),
                        dto.getDate(),
                        student,
                        room,
                        dto.getStatus()
                )
        );
    }

    @Override
    public boolean deleteRegistration(ReservationDTO dto) {
        Student student = new Student();
        student.setStudent_id(dto.getStudent_id());
        Room room = new Room();
        room.setRoom_type_id(dto.getRoom_type_id());
        return reservationDAO.delete(
                new Reservation(
                        dto.getRes_id(),
                        dto.getDate(),
                        student,
                        room,
                        dto.getStatus()
                )
        );
    }
    @Override
    public boolean updateRegistration(ReservationDTO dto) {
        Student student = new Student();
        student.setStudent_id(dto.getStudent_id());
        Room room = new Room();
        room.setRoom_type_id(dto.getRoom_type_id());
        return reservationDAO.update(
                new Reservation(
                        dto.getRes_id(),
                        dto.getDate(),
                        student,
                        room,
                        dto.getStatus()
                )
        );
    }

    @Override
    public ArrayList<ReservationDTO> getAll() {
        Student student;
        Room room;
        ArrayList<Reservation> arrayList = reservationDAO.getAll();
        ArrayList<ReservationDTO> dtos = new ArrayList<>();
        for (Reservation r : arrayList) {
            student = r.getStudent();
            room = r.getRoom();
            dtos.add(
                    new ReservationDTO(
                            r.getRes_id(),
                            r.getDate(),
                            student.getStudent_id(),
                            room.getRoom_type_id(),
                            r.getStatus()
                    )
            );
        }
        return dtos;
    }

    @Override
    public String getLastId() {
        return reservationDAO.getLastId();
    }

}
