package task3.dao;

import task3.Entity.Clients;

import java.sql.SQLException;
import java.util.List;

public interface ClientsDAO {
    //create
    void add(Clients clients) throws SQLException;
    //read
    List<Clients> getAll() throws SQLException;

    Clients getById(int id) throws SQLException;

    //update
    void update (Clients clients) throws SQLException;
    //delete
    void remove(Clients clients) throws SQLException;
}
