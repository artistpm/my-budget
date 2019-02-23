package hu.nemethi.mybudget.service;

import java.sql.SQLException;
import java.util.List;

public interface LanguageService<T> {

    T create(T t) throws SQLException;

    void delete(T t)throws SQLException;

    List<T> listAll();

}
