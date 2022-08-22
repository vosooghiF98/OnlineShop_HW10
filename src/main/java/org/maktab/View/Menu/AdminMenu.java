package org.maktab.View.Menu;

import org.maktab.Check.Check;
import org.maktab.Entity.Admin;
import org.maktab.Exception.SignUpSignInException;
import org.maktab.Repository.Impl.AdminRepositoryImpl;
import org.maktab.Service.AdminService;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenu {
    AdminService adminService = new AdminService(new AdminRepositoryImpl());
    Check check = new Check();
    public Admin signUp(Scanner input) throws SQLException {
        System.out.print("Enter Your username : ");
        String username = input.next();
        System.out.print("Enter Your password : ");
        String password = input.next();
        Admin admin = new Admin(username,password);
        if (adminService.readByUsername(admin)){
            throw new SignUpSignInException("This username is Exist!");
        }else {
            adminService.create(admin);
            return adminService.read(admin);
        }
    }

    public Admin signIn(Scanner input) throws SQLException {
        System.out.print("Enter Your username : ");
        String username = input.next();
        System.out.print("Enter Your password : ");
        String password = input.next();
        Admin admin = adminService.read(new Admin(username,password));
        if (admin == null){
            throw new SignUpSignInException("username OR password is Not Exist!");
        }else {
            return admin;
        }
    }

    public Admin edit(Admin admin, Scanner input) throws SQLException {
        System.out.print("Enter New username : ");
        String username = input.next();
        System.out.print("Enter New password : ");
        String password = input.next();
        Admin admin1 = adminService.read(new Admin(username,password));
        adminService.update(admin1,admin.getId());
        return adminService.read(admin1);
    }

    public void remove(Admin admin) throws SQLException {
        adminService.delete(admin);
        System.exit(1);
    }
}
