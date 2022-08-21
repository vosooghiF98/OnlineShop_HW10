package org.maktab.Service;

import org.maktab.Base.BaseRepository;
import org.maktab.Base.BaseService;
import org.maktab.Entity.User;
import org.maktab.Repository.Impl.UserRepositoryImpl;

public class UserService extends BaseService<User> {
    public UserService(UserRepositoryImpl userRepository) {
        super(userRepository);
    }
}
