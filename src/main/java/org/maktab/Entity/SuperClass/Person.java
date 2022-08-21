package org.maktab.Entity.SuperClass;

import org.maktab.Base.BaseEntity;

import java.util.Objects;

public abstract class Person implements BaseEntity {
    private int id;
    private String username;
    private String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return username.equals(person.username) && password.equals(person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
