package org.maktab.Repository.Impl;

import org.maktab.Base.BaseRepository;
import org.maktab.Config.DBConfig;
import org.maktab.Entity.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl implements BaseRepository<Admin> {
    @Override
    public void create(Admin admin) throws SQLException {
        String query = """
                insert into admin (user_name, password)
                values (?,?)
                """;
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public Admin read(Admin admin) throws SQLException {
        String query = """
                select * from admin where user_name = ? and password = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Admin admin1 = new Admin(resultSet.getString("user_name"), resultSet.getString("password"));
                admin1.setId(resultSet.getInt("id"));
                return admin1;
            }
            return null;
        }
    }

    @Override
    public void update(Admin admin, int id) throws SQLException {
        String query = """
                update admin set user_name = ? and password = ? where id = ?
                """;
        try(PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Admin admin) throws SQLException {
        String query = """
                delete from admin where user_name = ? and password = ?
                """;
        try (PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query)){
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.executeUpdate();
        }
    }
}
