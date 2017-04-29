/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.gui.model;

import bookratingsystem.be.User;
import bookratingsystem.bll.UserManager;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rasmus
 */
public class UserModel {

    private static UserModel instance;

    private final UserManager mUserManager;
    private final ObservableList<User> mListOfUsers;

    public static UserModel getInstance() {
        if (instance == null) {
            instance = new UserModel();
        }
        return instance;
    }

    private UserModel() {
        mUserManager = new UserManager();
        mListOfUsers = FXCollections.observableArrayList();
        mListOfUsers.addAll(mUserManager.getUsers());
    }

    public ObservableList<User> getListOfUsers() {
        return mListOfUsers;
    }

    /**
     * Ads a User to the observable list.
     *
     * @param user
     */
    public void addUser(User user) {
        mListOfUsers.add(user);
    }

    /**
     * Adds a List of Users to the observablelist.
     *
     * @param users
     */
    public void addUser(List<User> users) {
        mListOfUsers.addAll(users);
    }
}
