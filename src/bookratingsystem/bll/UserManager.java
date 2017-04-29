/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.bll;

import bookratingsystem.be.User;
import bookratingsystem.dal.FacadeDAL;

/**
 *
 * @author Rasmus
 */
public class UserManager {

    private final FacadeDAL mFacadeDAL;

    public UserManager() {
        mFacadeDAL = FacadeDAL.getInstance();
    }

    public User addUser(User user) {
        return mFacadeDAL.addUser(user);
    }

}
