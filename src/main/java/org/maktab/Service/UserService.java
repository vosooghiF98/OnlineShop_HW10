package org.maktab.Service;

import org.maktab.Base.BaseRepository;
import org.maktab.Base.BaseService;
import org.maktab.Entity.User;
import org.maktab.Repository.Impl.CartRepositoryImpl;
import org.maktab.Repository.Impl.UserRepositoryImpl;

import java.sql.SQLException;

public class UserService extends BaseService<User> {
    public UserService(UserRepositoryImpl userRepository) {
        super(userRepository);
    }

    public UserRepositoryImpl userRepository() {
        return (UserRepositoryImpl) super.getRepository();
    }

    public boolean readByNationalCode(User user) throws SQLException {
        return userRepository().readByNationalCode(user);
    }

    public boolean readByUsername(User user) throws SQLException {
        return userRepository().readByUsername(user);
    }
}
