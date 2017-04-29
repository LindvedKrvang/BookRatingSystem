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

    public void addRating(int userId, String[] bookISBN, int[] ratings) {
        Connection con;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);
            boolean errorHappened = false;
            for (int i = 1; i < bookISBN.length; i++) {
                if (!ratingsDAO.addRating(con, userId, bookISBN[i], ratings[i])) {
//                    errorHappened = true;
                }
            }
            if (errorHappened) {
                con.rollback();
                System.out.println("Rollback executed!");
            } else {
                con.commit();
                System.out.println("Succesfully added ratings to database!");
            }
        } catch (SQLException ex) {
            System.out.println("Failed to add rating to database!\n" + ex.getMessage());

        }
    }

}
