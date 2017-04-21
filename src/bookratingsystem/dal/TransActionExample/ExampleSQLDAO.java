/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.TransActionExample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 *
 * @author Rasmus
 */
public class ExampleSQLDAO {

    private ConnectionManager connectionManager;

    public void somethingWithTransactions(Connection con, String name, int age) throws SQLException {

        con.setAutoCommit(false);

        addVolunteer(con, name, age);
        //More code!
        Savepoint spA = con.setSavepoint("A");
        //Do something awesome that we can "unsave".
        con.rollback(spA);
        con.commit();
    }

    public Volunteer addVolunteer(Connection con, String name, int age) throws SQLException {
        String sql = "INSERT INTO Volunteers (Name, Age) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, name);
        ps.setInt(2, age);

        ps.executeUpdate();

        ResultSet key = ps.getGeneratedKeys();

        int id = key.getInt(1);
        return new Volunteer(id, name, age);

    }
}
