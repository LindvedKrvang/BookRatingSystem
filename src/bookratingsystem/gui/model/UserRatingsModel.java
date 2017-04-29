/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.gui.model;

import bookratingsystem.be.User;
import bookratingsystem.bll.RatingsManager;
import bookratingsystem.bll.UserManager;

/**
 *
 * @author Rasmus
 */
public class UserRatingsModel {

    public static UserRatingsModel instance;

    private final UserManager mUserManager;
    private final RatingsManager mRatingsManager;

    public static UserRatingsModel getInstance() {
        if (instance == null) {
            instance = new UserRatingsModel();
        }
        return instance;
    }

    private UserRatingsModel() {
        mUserManager = new UserManager();
        mRatingsManager = new RatingsManager();
    }

    public void addUserAndRatingToDatabase(User u, String[] bookISBN, int[] ratings) {
        User user = mUserManager.addUser(u);
        mRatingsManager.addRatingsToUser(user.getId(), bookISBN, ratings);
    }
}
