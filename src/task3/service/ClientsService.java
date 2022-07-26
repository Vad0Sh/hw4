package task3.service;

import task3.Entity.Clients;
import task3.Util;
import task3.dao.ClientsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsService extends Util implements ClientsDAO {
    Connection connection = getConnection();

    @Override
    public void add(Clients clients) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "insert into clients (id, name, age, phone ) values (?, ?, ?, ?);";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,clients.getId());
            preparedStatement.setString(2,clients.getName());
            preparedStatement.setInt(3,clients.getAge());
            preparedStatement.setString(4,clients.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public List<Clients> getAll() throws SQLException {
        List<Clients> clientsList = new ArrayList<>();

        String sql ="Select Id, name, age, phone from clients;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
                Clients clients = new Clients();
                clients.setId(resultSet.getInt("id"));
                clients.setName(resultSet.getString("name"));
                clients.setAge(resultSet.getInt("age"));
                clients.setPhone(resultSet.getString("phone"));
                clientsList.add(clients);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return clientsList;
    }

    @Override
    public Clients getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Select Id, name, age, phone from clients where id=?;";
        Clients clients = new Clients();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt( 1 , id);

            ResultSet resultSet =preparedStatement.executeQuery(sql);

           clients.setId(resultSet.getInt("id"));
           clients.setName(resultSet.getString("name"));
           clients.setAge(resultSet.getInt("age"));
           clients.setPhone(resultSet.getString("phone"));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return clients;
    }

    @Override
    public void update(Clients clients) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "update clients set name=?, age=?, phone=? where id=?;";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, clients.getName());
            preparedStatement.setInt(2, clients.getAge());
            preparedStatement.setString(3, clients.getPhone());
            preparedStatement.setInt(4, clients.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public void remove(Clients clients) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "delete from clients where id=?;";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,clients.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }
}
