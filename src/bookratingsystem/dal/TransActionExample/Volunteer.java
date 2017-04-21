/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.TransActionExample;

/**
 *
 * @author Rasmus
 */
public class Volunteer {

    private final int mId;
    private String mName;
    private int mAge;

    public Volunteer(int id, String name, int age) {
        mId = id;
        mName = name;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public int getId() {
        return mId;
    }

    public void setAge(int age) {
        this.mAge = age;
    }

}
