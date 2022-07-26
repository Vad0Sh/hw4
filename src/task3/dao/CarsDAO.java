package task3.dao;

import task3.Entity.Cars;

import java.sql.SQLException;
import java.util.List;

public interface CarsDAO {
    //create
    void add(Cars cars) throws SQLException;
    //read
    List<Cars> getAll() throws SQLException;

    Cars getById(int id) throws SQLException;

    //update
    void update (Cars cars) throws SQLException;
    //delete
    void remove(Cars cars) throws SQLException;
}
