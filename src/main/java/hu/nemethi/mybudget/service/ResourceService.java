package hu.nemethi.mybudget.service;

import java.sql.SQLException;
import java.util.List;

public interface ResourceService<T> {

    T create(T t) throws SQLException;

    void delete(String id)throws SQLException;

    T modify(T t)throws SQLException;

    List<T> listAll() throws SQLException;
}
