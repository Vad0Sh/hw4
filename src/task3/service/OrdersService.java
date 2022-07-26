package task3.service;

import task3.Entity.Clients;
import task3.Entity.Orders;
import task3.Util;
import task3.dao.OrdersDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersService extends Util implements OrdersDAO {
    Connection connection = getConnection();

    @Override
    public void add(Orders orders) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "insert into orders (id, car_id, client_id ) values (?, ?, ?);";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orders.getId());
            preparedStatement.setInt(2,orders.getCar_id());
            preparedStatement.setInt(3,orders.getClient_id());
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
    public List<Orders> getAll() throws SQLException {
        List<Orders> ordersList = new ArrayList<>();

        String sql ="Select Id, car_id, client_id from orders;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
                Orders orders = new Orders();
                orders.setId(resultSet.getInt("id"));
                orders.setCar_id(resultSet.getInt("car_id"));
                orders.setClient_id(resultSet.getInt("order_id"));

                ordersList.add(orders);
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
        return ordersList;
    }
    @Override
    public Orders getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Select Id, car_id, order_id from orders where id=?;";
        Orders orders = new Orders();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt( 1 , id);

            ResultSet resultSet =preparedStatement.executeQuery(sql);

            orders.setId(resultSet.getInt("id"));
            orders.setCar_id(resultSet.getInt("car_id"));
            orders.setClient_id(resultSet.getInt("client_id"));
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

        return orders;
    }

    @Override
    public void update(Orders orders) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "update orders set car_id=?, client_id=? where id=?;";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orders.getCar_id());
            preparedStatement.setInt(2, orders.getClient_id());
            preparedStatement.setInt(3, orders.getId());
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
    public void remove(Orders orders) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "delete from orders where id=?;";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orders.getId());
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
