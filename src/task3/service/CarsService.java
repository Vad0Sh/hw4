package task3.service;

import task3.Entity.Cars;
import task3.Util;
import task3.dao.CarsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarsService extends Util implements CarsDAO {
    Connection connection = getConnection();

    @Override
    public void add(Cars cars) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "insert into cars (id, mark_id, model, price) values (?, ?, ?, ?);";
    try{
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,cars.getId());
        preparedStatement.setInt(2,cars.getMark_id());
        preparedStatement.setString(3,cars.getModel());
        preparedStatement.setInt(3,cars.getPrice());
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
    public List<Cars> getAll() throws SQLException {
        List<Cars> carsList = new ArrayList<>();

        String sql ="Select Id, mark_id, model, price from cars;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
                Cars cars = new Cars();
                cars.setId(resultSet.getInt("id"));
                cars.setMark_id(resultSet.getInt("mark_id"));
                cars.setModel(resultSet.getString("model"));
                cars.setPrice(resultSet.getInt("price"));
                carsList.add(cars);
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
        return carsList;
    }

    @Override
    public Cars getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Select Id, mark_id, model, price from cars where id=?;";
        Cars cars = new Cars();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt( 1 , id);

            ResultSet resultSet =preparedStatement.executeQuery(sql);

                cars.setId(resultSet.getInt("id"));
                cars.setMark_id(resultSet.getInt("mark_id"));
                cars.setModel(resultSet.getString("model"));
                cars.setPrice(resultSet.getInt("price"));
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

        return cars;
    }

    @Override
    public void update(Cars cars) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "update cars set mark_id=?, model=?, price=? where id=?;";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cars.getMark_id());
            preparedStatement.setString(2,cars.getModel());
            preparedStatement.setInt(3,cars.getPrice());
            preparedStatement.setInt(4,cars.getId());
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
    public void remove(Cars cars) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "delete from cars where id=?;";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cars.getId());
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
