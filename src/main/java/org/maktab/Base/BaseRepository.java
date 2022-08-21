package org.maktab.Base;

import java.sql.SQLException;

public interface BaseRepository<T> {
    void create(T t) throws SQLException;
    T read(T t) throws SQLException;
    void update(T t, int id) throws SQLException;
    void delete(T t) throws SQLException;
}
