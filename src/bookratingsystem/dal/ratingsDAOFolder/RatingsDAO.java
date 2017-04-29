/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.ratingsDAOFolder;

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
public class RatingsDAO {

    public boolean addRating(Connection con, int userId, String bookISBN, int rating) throws SQLException {
        String sql = "INSERT INTO BookRatings (UserId, BookId, Rating) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setString(2, bookISBN);
        ps.setInt(3, rating);

        return ps.execute();
    }

    public List<Integer> getRatings(Connection con, int userId) throws SQLException {
        List<Integer> listOfRatings = new ArrayList<>();
        String sql = "SELECT * FROM BookRatings WHERE UserId = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            listOfRatings.add(getOneRating(rs));
        }
        return listOfRatings;
    }

    private int getOneRating(ResultSet rs) throws SQLException {
        return rs.getInt("Rating");
    }
}
