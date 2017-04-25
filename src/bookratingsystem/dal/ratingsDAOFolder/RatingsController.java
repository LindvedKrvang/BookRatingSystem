/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.ratingsDAOFolder;

import bookratingsystem.dal.DBConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Rasmus
 */
public class RatingsController {

    private DBConnectionManager cm;

    private RatingsDAO ratingsDAO;

    public RatingsController() {
        try {
            cm = DBConnectionManager.getInstance();
        } catch (IOException ex) {
            System.out.println("Failed to connect to database!\n" + ex.getMessage());
        }
        ratingsDAO = new RatingsDAO();
    }

    public void addRating(int userId, String[] bookNames, int[] ratings) {
        Connection con;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);
            for (int i = 1; i < bookNames.length; i++) {
                ratingsDAO.addRating(con, userId, bookNames[i], ratings[i]);
            }
            con.commit();
        } catch (SQLException ex) {
            System.out.println("Failed to add rating to database!\n" + ex.getMessage());

        }
    }

}
