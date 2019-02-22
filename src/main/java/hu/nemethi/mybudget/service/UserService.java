package hu.nemethi.mybudget.service;

import hu.nemethi.mybudget.dto.UserDto;

import java.sql.SQLException;
import java.util.UUID;

public interface UserService<T> {

    T create(T t) throws SQLException;

    void delete(UUID id) throws SQLException;

    T modify(T t) throws SQLException;

    T findByUserId(T t);

    UserDto login(UserDto userDto);

    void logout(Integer userId);

}
