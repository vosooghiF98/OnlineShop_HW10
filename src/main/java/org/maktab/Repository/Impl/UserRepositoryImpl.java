package org.maktab.Repository.Impl;

import org.maktab.Config.DBConfig;
import org.maktab.Entity.User;
import org.maktab.Repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void create(User user) throws SQLException {
        String query = """
                insert into users (first_name, last_name, national_code, user_name, password) 
                values (?,?,?,?,?)
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getNationalCode());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public User read(User user) throws SQLException {
        String query = """
                select * from users where user_name = ? and password = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                User user1 = new User(resultSet.getString("user_name"), resultSet.getString("password"));
                user1.setId(resultSet.getInt("id"));
                user1.setFirstName(resultSet.getString("first_name"));
                user1.setLastName(resultSet.getString("last_name"));
                user1.setNationalCode(resultSet.getString("national_code"));
                return user1;
            }
            return null;
        }
    }

    @Override
    public void update(User user, int id) throws SQLException {
        String query = """
                update users set user_name = ? , password = ? where id = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(User user) throws SQLException {
        String query = """
                delete from users where user_name = ? and password = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public boolean readByNationalCode(User user) throws SQLException {
        String query = """
                select * from users where national_code = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, user.getNationalCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    @Override
    public boolean readByUsername(User user) throws SQLException {
        String query = """
                select * from users where  user_name = ?
                """;
        try(PreparedStatement preparedStatement= DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }
}
