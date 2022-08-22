package org.maktab.Repository;

import org.maktab.Base.BaseRepository;
import org.maktab.Entity.Admin;

import java.sql.SQLException;

public interface AdminRepository extends BaseRepository<Admin> {

    boolean readByUsername(Admin admin) throws SQLException;
}
