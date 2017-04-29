/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.userDAOFolder;

import bookratingsystem.be.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class UserDAO {

    public User addUser(Connection con, User user) throws SQLException {
        String sql = "INSERT INTO Users (Name) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getName());
        ps.executeUpdate();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        generatedKeys.next();
        int id = generatedKeys.getInt(1);
        return new User(user.getName(), id);
    }

    public List<User> getAllUsers(Connection con) throws SQLException {
        String sql = "SELECT * FROM Users";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<User> listOfUsers = new ArrayList<>();
        while (rs.next()) {
            listOfUsers.add(getOneUser(rs));
        }
        return listOfUsers;
    }

    private User getOneUser(ResultSet rs) throws SQLException {
        String name = rs.getString("Name");
        int id = rs.getInt("Id");
        return new User(name, id);
    }
}
