package org.maktab.Service;

import org.maktab.Base.BaseRepository;
import org.maktab.Base.BaseService;
import org.maktab.Entity.Admin;
import org.maktab.Repository.Impl.AdminRepositoryImpl;
import org.maktab.Repository.Impl.UserRepositoryImpl;

import java.sql.SQLException;

public class AdminService extends BaseService<Admin> {
    public AdminService(AdminRepositoryImpl adminRepository) {
        super(adminRepository);
    }

    public AdminRepositoryImpl adminRepository() {
        return (AdminRepositoryImpl) super.getRepository();
    }

    public boolean readByUsername(Admin admin) throws SQLException {
        return adminRepository().readByUsername(admin);
    }
}
