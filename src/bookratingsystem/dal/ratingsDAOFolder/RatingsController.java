/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.ratingsDAOFolder;

import static bookratingsystem.BookRatingSystem.BOOK_ISBN;
import bookratingsystem.be.User;
import bookratingsystem.dal.DBConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
            System.out.println("Failed to connect to database!\n"
                    + ex.getMessage());
        }
        ratingsDAO = new RatingsDAO();
    }

    public void addRating(int userId, String[] bookISBN, int[] ratings) {
//        Connection con;
        try (Connection con = cm.getConnection()) {
            con.setAutoCommit(false);
            boolean errorHappened = false;
            for (int i = 0; i < bookISBN.length; i++) {
                if (!ratingsDAO.addRating(con, userId, bookISBN[i], ratings[i])) { //TODO RKL: Returns false, when it should return true.
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
            System.out.println("Failed to add rating to database!\n"
                    + ex.getMessage());
            ex.printStackTrace();

        }
    }

    public List<User> addRatingsToUsers(List<User> users) {
        try (Connection con = cm.getConnection()) {
            for (User user : users) {
                List<Integer> ratings = ratingsDAO.getRatings(con, user.getId());
                for (int i = 0; i < BOOK_ISBN.length; i++) {
                    user.addBookRating(BOOK_ISBN[i], ratings.get(i));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Failed to get ratings for users!\n"
                    + ex.getMessage());
            ex.printStackTrace();
        }
        return users;
    }

}
