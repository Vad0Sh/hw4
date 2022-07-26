package task3.service;

import task3.Entity.Marks;
import task3.Util;
import task3.dao.MarksDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksService extends Util implements MarksDAO {
    Connection connection = getConnection();

    @Override
    public void add(Marks marks) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "insert into marks (id, mark ) values (?, ?);";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,marks.getId());
            preparedStatement.setString(2, marks.getMark());
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
    public List<Marks> getAll() throws SQLException {
        List<Marks> marksList = new ArrayList<>();

        String sql ="Select Id, mark from marks;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
                Marks marks = new Marks();
                marks.setId(resultSet.getInt("id"));
                marks.setMark(resultSet.getString("mark"));
                marksList.add(marks);
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
        return marksList;
    }

    @Override
    public Marks getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Select Id, mark from marks where id=?;";
        Marks marks= new Marks();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt( 1 , id);

            ResultSet resultSet =preparedStatement.executeQuery(sql);

            marks.setId(resultSet.getInt("id"));
            marks.setMark(resultSet.getString("mark"));
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

        return marks;
    }

    @Override
    public void update(Marks marks) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "update marks set mark=? where id=?;";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, marks.getMark());
            preparedStatement.setInt(2, marks.getId());
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
    public void remove(Marks marks) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql= "delete from marks where id=?;";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,marks.getId());
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