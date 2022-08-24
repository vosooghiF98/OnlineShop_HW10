package org.maktab.View.Menu;

import org.maktab.Check.Check;
import org.maktab.Entity.Admin;
import org.maktab.Entity.User;
import org.maktab.Exception.SignUpSignInException;
import org.maktab.Repository.Impl.AdminRepositoryImpl;
import org.maktab.Service.AdminService;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenu {
    Scanner input = new Scanner(System.in);
    AdminService adminService = new AdminService(new AdminRepositoryImpl());
    Check check = new Check();
    public Admin signUp() throws SQLException {
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

    public Admin signIn() throws SQLException {
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

    public Admin edit(Admin admin) throws SQLException {
        System.out.print("Enter New username : ");
        String username = input.next();
        System.out.print("Enter New password : ");
        String password = input.next();
        Admin newAdmin = new Admin(username,password);
        if (adminService.readByUsername(newAdmin)){
            throw new SignUpSignInException("This username is Exist!");
        }else {
            adminService.update(newAdmin, admin.getId());
            System.out.println("Edit Is Successfully.");
            return adminService.read(newAdmin);
        }
    }

    public void remove(Admin admin) throws SQLException {
        System.out.print("Are You Sure About Delete Your Account (Y/N) : ");
        boolean yn = check.checkYN();
        if (yn) {
            adminService.delete(admin);
            System.out.println("Delete Is Successfully.");
            System.exit(1);
        }else {
            System.out.println("Delete Isn't Successfully.");
        }
    }
}
