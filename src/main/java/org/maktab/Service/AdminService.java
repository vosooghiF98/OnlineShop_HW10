package org.maktab.Service;

import org.maktab.Base.BaseRepository;
import org.maktab.Base.BaseService;
import org.maktab.Entity.Admin;
import org.maktab.Repository.Impl.AdminRepositoryImpl;

public class AdminService extends BaseService<Admin> {
    public AdminService(AdminRepositoryImpl adminRepository) {
        super(adminRepository);
    }
}
