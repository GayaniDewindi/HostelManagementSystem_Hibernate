package lk.ijse.hostel.dao;

public interface SQLUtil<T> extends SuperDAO{
    boolean save(T entity);
    boolean delete(T entity);
    boolean update(T entity);
//    ArrayList<T> get();
}
