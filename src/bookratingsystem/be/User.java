/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class User {

    private String mName;
    private int mId;
    private List<Integer> mListOfRatings;

    public User(String name) {
        mName = name;
        mId = 0;
        mListOfRatings = new ArrayList<>();
    }

    public User(String name, int id) {
        mName = name;
        mId = id;
        mListOfRatings = new ArrayList<>();
    }

    public User(User user) {
        mName = user.getName();
        mId = user.getId();
        mListOfRatings = new ArrayList<>();
    }

    public String getName() {
        return mName;
    }

    public int getId() {
        return mId;
    }

    public void addRating(int rating) {
        mListOfRatings.add(rating);
    }

    public List<Integer> getRatings() {
        return mListOfRatings;
    }

}
