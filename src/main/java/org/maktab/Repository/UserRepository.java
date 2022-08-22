package org.maktab.Repository;

import org.maktab.Base.BaseRepository;
import org.maktab.Entity.User;

import java.sql.SQLException;

public interface UserRepository extends BaseRepository<User> {
    boolean readByNationalCode(User user) throws SQLException;

    boolean readByUsername(User user) throws SQLException;
}
