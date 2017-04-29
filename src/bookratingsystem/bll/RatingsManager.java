/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.bll;

import bookratingsystem.dal.FacadeDAL;

/**
 *
 * @author Rasmus
 */
public class RatingsManager {

    private final FacadeDAL mFacadeDAL;

    public RatingsManager() {
        mFacadeDAL = FacadeDAL.getInstance();
    }

    /**
     * Adds the parsed users ratings to the parsed books.
     *
     * @param userID
     * @param bookISBN
     * @param ratings
     */
    public void addRatingsToUser(int userID, String[] bookISBN, int[] ratings) {
        mFacadeDAL.addRatingsToUser(userID, bookISBN, ratings);
    }

}
