/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal;

import java.util.List;

/**
 *
 * @author Rasmus
 * @param <T>
 */
public interface IDAOController<T> {

    public T add(T t);

    public List<T> get();

}
