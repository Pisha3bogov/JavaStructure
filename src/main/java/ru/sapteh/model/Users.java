package ru.sapteh.model;

import java.util.Objects;

public class Users {
    private long id;
    private String firstName;
    private String lastName;

    public Users() {

    }

    public Users(long id, String firstName,String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Users (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId (long id) {
        this.id = id;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public long getId () {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public String toString () {
        return "ID = " + id + "\n" +
                "First name = " + firstName + "\n" +
                "Last name = " + lastName + "\n";
    }
}
