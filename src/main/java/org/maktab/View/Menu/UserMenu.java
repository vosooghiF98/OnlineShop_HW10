package org.maktab.View.Menu;

import org.maktab.Check.Check;
import org.maktab.Entity.User;
import org.maktab.Exception.SignUpSignInException;
import org.maktab.Repository.Impl.UserRepositoryImpl;
import org.maktab.Service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {
    Scanner input = new Scanner(System.in);
    UserService userService = new UserService(new UserRepositoryImpl());
    Check check = new Check();
    public User signUp() throws SQLException {
        System.out.print("Enter Your First Name : ");
        String firstName = check.checkName();
        System.out.print("Enter Your Last Name : ");
        String lastName = check.checkName();
        String nationalCode = check.checkNationalCode();
        System.out.print("Enter Your username : ");
        String username = input.next();
        System.out.print("Enter Your password : ");
        String password = input.next();
        User user = new User(username,password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setNationalCode(nationalCode);
        if (userService.readByNationalCode(user)){
            throw new SignUpSignInException("This National Code is Exist!");
        }else if (userService.readByUsername(user)){
            throw new SignUpSignInException("This username is Exist!");
        }else {
            userService.create(user);
            return userService.read(user);
        }
    }

    public User signIn() throws SQLException {
        System.out.print("Enter Your username : ");
        String username = input.next();
        System.out.print("Enter Your password : ");
        String password = input.next();
        User user = userService.read(new User(username,password));
        if (user == null){
            throw new SignUpSignInException("username OR password is Not Exist!");
        }else {
            return user;
        }
    }

    public User edit(User user) throws SQLException {
        System.out.print("Enter New username : ");
        String username = input.next();
        System.out.print("Enter New password : ");
        String password = input.next();
        User newUser = new User(username,password);
        if (userService.readByUsername(newUser)){
            throw new SignUpSignInException("This username is Exist!");
        }else {
            userService.update(newUser, user.getId());
            System.out.println("Edit Is Successfully.");
            return userService.read(newUser);
        }
    }

    public void remove(User user) throws SQLException {
        System.out.print("Are You Sure About Delete Your Account (Y/N) : ");
        boolean yn = check.checkYN();
        if (yn) {
            userService.delete(user);
            System.out.println("Delete Is Successfully.");
            System.exit(1);
        }else {
            System.out.println("Delete Isn't Successfully.");
        }
    }
}
