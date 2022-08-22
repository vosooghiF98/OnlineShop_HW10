package org.maktab.View.Menu;

import org.maktab.Check.Check;
import org.maktab.Entity.User;
import org.maktab.Exception.SignUpSignInException;
import org.maktab.Repository.Impl.UserRepositoryImpl;
import org.maktab.Service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {
    UserService userService = new UserService(new UserRepositoryImpl());
    Check check = new Check();
    public User signUp(Scanner input) throws SQLException {
        System.out.print("Enter Your First Name : ");
        String firstName = check.checkName(input);
        System.out.print("Enter Your Last Name : ");
        String lastName = check.checkName(input);
        String nationalCode = check.checkNationalCode(input);
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

    public User signIn(Scanner input) throws SQLException {
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

    public User edit(User user, Scanner input) throws SQLException {
        System.out.print("Enter New username : ");
        String username = input.next();
        System.out.print("Enter New password : ");
        String password = input.next();
        User user1 = userService.read(new User(username,password));
        userService.update(user1,user.getId());
        return userService.read(user1);
    }

    public void remove(User user) throws SQLException {
        userService.delete(user);
        System.exit(1);
    }
}
