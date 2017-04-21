/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.TransActionExample;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Rasmus
 */
public class VolunteerController {

    private ExampleSQLDAO dao;
    private ConnectionManager cm;

    public Volunteer addVolunteer(String name, int age) throws SQLException {
        cm = new ConnectionManager();
        dao = new ExampleSQLDAO();

        Connection con = cm.getConnection();
        return dao.addVolunteer(con, name, age);
    }
}
