package hu.nemethi.mybudget.service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface GenericService<T> {

    T create(T t) throws SQLException;

    void delete(String id)throws SQLException;

    T modify(T t)throws SQLException;

    List<T> listAllByUserId(UUID userId) throws SQLException;

    void deleteAllByUserId(UUID userId) throws SQLException;
}
