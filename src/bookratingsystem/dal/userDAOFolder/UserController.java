/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.userDAOFolder;

import bookratingsystem.be.User;
import bookratingsystem.dal.DBConnectionManager;
import bookratingsystem.dal.IDAOController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class UserController implements IDAOController<User> {

    private DBConnectionManager cm;
    private UserDAO userDAO;

    public UserController() {
        try {
            cm = DBConnectionManager.getInstance();
        } catch (IOException ex) {
            System.out.println("Failed to get connectio to database!\n" + ex.getMessage());
        }
        userDAO = new UserDAO();
    }

    @Override
    public User add(User t) {
        try {
            return userDAO.addUser(cm.getConnection(), t);
        } catch (SQLException ex) {
            System.out.println("Failed to add User to database!\n" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<User> get() {
        try {
            return userDAO.getAllUsers(cm.getConnection());
        } catch (SQLException ex) {
            System.out.println("Failed to get all Users from database!\n" + ex.getMessage());
            return null;
        }
    }

}
