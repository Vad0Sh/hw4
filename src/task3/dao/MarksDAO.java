package task3.dao;

import task3.Entity.Marks;

import java.sql.SQLException;
import java.util.List;

public interface MarksDAO {
    //create
    void add(Marks marks) throws SQLException;
    //read
    List<Marks> getAll() throws SQLException;

    Marks getById(int id) throws SQLException;

    //update
    void update (Marks marks) throws SQLException;
    //delete
    void remove(Marks marks) throws SQLException;
}
